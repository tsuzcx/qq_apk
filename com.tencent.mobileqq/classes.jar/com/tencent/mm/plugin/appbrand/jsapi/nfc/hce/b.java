package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.nfc.cardemulation.HostApduService;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.luggage.wxa.li.a;
import com.tencent.luggage.wxa.li.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public class b
{
  public static b a;
  private static final byte[] l = { 0, 0 };
  private static long m = -1L;
  private String b = null;
  private ArrayList<String> c;
  private int d;
  private boolean e = false;
  private boolean f = true;
  private boolean g = false;
  private boolean h = false;
  private a i = new b.a(this, null);
  private com.tencent.luggage.wxa.li.b j = new b.b(this, null);
  private ResultReceiver k;
  private HostApduService n;
  
  static
  {
    a = null;
    if (a == null) {
      a = new b();
    }
  }
  
  private void a(byte[] paramArrayOfByte, boolean paramBoolean, HostApduService paramHostApduService)
  {
    try
    {
      o.d("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND sendResponseCommandToSystem isDefaultCommand: %b, hasCommandNotResponded: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.f) });
      if (this.f)
      {
        this.f = false;
        long l1 = System.currentTimeMillis();
        o.d("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND send response command time: %d, cost: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l1 - m) });
        if (paramHostApduService != null) {
          paramHostApduService.sendResponseApdu(paramArrayOfByte);
        } else {
          o.b("MicroMsg.HCEServiceMgr", "alvinluo sendResponseCommandToSystem hceService is null");
        }
        if (paramBoolean) {
          c.a(this.b);
        }
      }
      return;
    }
    finally {}
  }
  
  @TargetApi(21)
  public void a()
  {
    if (this.c != null)
    {
      Object localObject1 = this.n;
      if (localObject1 != null)
      {
        localObject1 = NfcAdapter.getDefaultAdapter((Context)localObject1);
        if (localObject1 == null)
        {
          o.b("MicroMsg.HCEServiceMgr", "alvinluo NfcAdapter is null when register aids");
          return;
        }
        if (Build.VERSION.SDK_INT < 21)
        {
          o.b("MicroMsg.HCEServiceMgr", "alvinluo android version: %d is not satisfied when register aids", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
          return;
        }
        localObject1 = CardEmulation.getInstance((NfcAdapter)localObject1);
        if (localObject1 != null) {
          try
          {
            Object localObject2 = new ComponentName(this.n, this.n.getClass());
            boolean bool = ((CardEmulation)localObject1).registerAidsForService((ComponentName)localObject2, "payment", this.c);
            o.d("MicroMsg.HCEServiceMgr", "alvinluo register aids result: %b", new Object[] { Boolean.valueOf(bool) });
            if (bool)
            {
              d(true);
              localObject1 = ((CardEmulation)localObject1).getAidsForService((ComponentName)localObject2, "payment");
              if ((localObject1 != null) && (((List)localObject1).size() > 0))
              {
                int i1 = 0;
                while (i1 < ((List)localObject1).size())
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("dynamicAIDList aid=");
                  ((StringBuilder)localObject2).append((String)((List)localObject1).get(i1));
                  o.b("MicroMsg.HCEServiceMgr", ((StringBuilder)localObject2).toString());
                  i1 += 1;
                }
              }
            }
            else
            {
              d(false);
              return;
            }
          }
          catch (Exception localException)
          {
            o.a("MicroMsg.HCEServiceMgr", localException, "alvinluo HCEService register aid exception", new Object[0]);
            d(false);
          }
        }
        return;
      }
    }
    o.b("MicroMsg.HCEServiceMgr", "alvinluo mAidList is null, or mHceService is null fail to register");
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    o.d("MicroMsg.HCEServiceMgr", "alvinluo genCallHCEService type = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != 13)
    {
      if (paramInt != 31)
      {
        if (paramInt != 32)
        {
          switch (paramInt)
          {
          default: 
            return;
          case 24: 
            paramString = this.j;
            if (paramString == null) {
              break;
            }
            paramString.d();
            return;
          case 23: 
            paramString = this.j;
            if (paramString == null) {
              break;
            }
            paramString.c();
            return;
          case 22: 
            paramString = this.j;
            if (paramString == null) {
              break;
            }
            paramString.b();
            return;
          case 21: 
            paramString = this.j;
            if (paramString == null) {
              break;
            }
            paramString.a();
            return;
          }
        }
        else if (this.i != null)
        {
          paramBundle = paramBundle.getString("key_apdu_command");
          this.i.b(paramString, paramBundle);
        }
      }
      else if (this.i != null)
      {
        paramBundle = paramBundle.getString("key_apdu_command");
        this.i.a(paramString, paramBundle);
      }
    }
    else
    {
      b();
      paramString = this.n;
      if (paramString != null) {
        paramString.stopSelf();
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.d = paramIntent.getIntExtra("key_time_limit", 1500);
    int i1 = this.d;
    if (i1 < 1500)
    {
      o.d("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d smaller than: %d and set a valid value", new Object[] { Integer.valueOf(i1), Integer.valueOf(1500) });
      this.d = 1500;
    }
    i1 = this.d;
    if (i1 > 60000)
    {
      o.d("MicroMsg.HCEServiceMgr", "alvinluo HCEService timeLimit: %d, bigger than: %d and set a valid value", new Object[] { Integer.valueOf(i1), Integer.valueOf(60000) });
      this.d = 60000;
    }
    o.d("MicroMsg.HCEServiceMgr", "alvinluo HCEService valid timeLimit: %d", new Object[] { Integer.valueOf(this.d) });
  }
  
  public void a(HostApduService paramHostApduService, ResultReceiver paramResultReceiver)
  {
    o.d("MicroMsg.HCEServiceMgr", "alvinluo setHceService");
    this.n = paramHostApduService;
    this.k = paramResultReceiver;
  }
  
  public void a(Bundle paramBundle)
  {
    o.d("MicroMsg.HCEServiceMgr", "alvinluo HCE EVENT mm to AppBrand");
    ResultReceiver localResultReceiver = this.k;
    if (localResultReceiver != null) {
      localResultReceiver.send(10002, paramBundle);
    }
  }
  
  public void a(String paramString, int paramInt, Bundle paramBundle)
  {
    paramBundle.putString("key_appid", paramString);
    paramBundle.putInt("key_event_type", paramInt);
    a(paramBundle);
  }
  
  public void a(String paramString, ArrayList<String> paramArrayList)
  {
    this.b = paramString;
    this.c = paramArrayList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  @TargetApi(21)
  public void b()
  {
    Object localObject1 = this.n;
    if (localObject1 == null)
    {
      o.b("MicroMsg.HCEServiceMgr", "alvinluo mHceService is null fail to unregisterAids");
      return;
    }
    localObject1 = NfcAdapter.getDefaultAdapter((Context)localObject1);
    if (localObject1 == null) {
      return;
    }
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    localObject1 = CardEmulation.getInstance((NfcAdapter)localObject1);
    if (localObject1 != null)
    {
      Object localObject2 = this.n;
      localObject2 = new ComponentName((Context)localObject2, localObject2.getClass());
      o.d("MicroMsg.HCEServiceMgr", "alvinluo HCEService unregister aids");
      ((CardEmulation)localObject1).removeAidsForService((ComponentName)localObject2, "payment");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  protected void d(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      localBundle.putInt("errCode", 0);
      localBundle.putString("errMsg", "");
    }
    else
    {
      localBundle.putInt("errCode", 13006);
      localBundle.putString("errMsg", "register aids failed");
    }
    a(this.b, 12, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b
 * JD-Core Version:    0.7.0.1
 */