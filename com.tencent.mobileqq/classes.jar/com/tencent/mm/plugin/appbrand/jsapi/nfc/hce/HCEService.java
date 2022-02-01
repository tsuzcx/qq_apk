package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Base64;
import com.tencent.luggage.wxa.qz.o;
import java.nio.charset.StandardCharsets;

@TargetApi(19)
public class HCEService
  extends HostApduService
{
  private String a = null;
  
  public void onCreate()
  {
    super.onCreate();
    o.d("MicroMsg.HCEService", "alvinluo HCEService onCreate");
  }
  
  public void onDeactivated(int paramInt)
  {
    o.d("MicroMsg.HCEService", "alvinluo HCEService onDeactivated reason: %d", new Object[] { Integer.valueOf(paramInt) });
    b.a.b(false);
    b.a.c(false);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_on_deactivated_reason", paramInt);
    b.a.a(this.a, 41, localBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    o.d("MicroMsg.HCEService", "alvinluo HCEService onDestroy");
    b.a.b();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.HCEService", "alvinluo HCEService onStartCommand");
    long l1 = System.currentTimeMillis();
    o.d("MicroMsg.HCEService", "alvinluo HCEService onStartCommand start: %d", new Object[] { Long.valueOf(l1) });
    if (paramIntent == null) {
      return super.onStartCommand(paramIntent, paramInt1, paramInt2);
    }
    try
    {
      b.a.a(this, (ResultReceiver)paramIntent.getParcelableExtra("HCE_Result_Receiver"));
      this.a = paramIntent.getStringExtra("key_appid");
      b.a.a(paramIntent);
      b.a.a(this.a, paramIntent.getStringArrayListExtra("key_aid_list"));
      b.a.a();
      b.a.a(false);
      long l2 = System.currentTimeMillis();
      o.d("MicroMsg.HCEService", "alvinluo HCEService onStartCommand end: %d, total: %d", new Object[] { Long.valueOf(l2), Long.valueOf(l2 - l1) });
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.HCEService", localException, "under dos attack(?): invalid key_result_receiver", new Object[0]);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public byte[] processCommandApdu(byte[] paramArrayOfByte, Bundle paramBundle)
  {
    o.d("MicroMsg.HCEService", "alvinluo HCECOMMAND processCommandApdu, received command from system: %s", new Object[] { c.a(paramArrayOfByte) });
    paramArrayOfByte = Base64.encode(paramArrayOfByte, 2);
    paramBundle = new Bundle();
    paramBundle.putString("key_apdu_command", new String(paramArrayOfByte, StandardCharsets.UTF_8));
    b.a.a(31, this.a, paramBundle);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService
 * JD-Core Version:    0.7.0.1
 */