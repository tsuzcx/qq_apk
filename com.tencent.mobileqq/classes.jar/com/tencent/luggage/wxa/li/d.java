package com.tencent.luggage.wxa.li;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;

public class d
{
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  @TargetApi(21)
  public static boolean b()
  {
    if (a()) {
      return r.a().getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
    }
    return false;
  }
  
  public static boolean c()
  {
    Context localContext = r.a();
    if (!localContext.getPackageManager().hasSystemFeature("android.hardware.nfc")) {
      return false;
    }
    return NfcAdapter.getDefaultAdapter(localContext) != null;
  }
  
  public static boolean d()
  {
    NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(r.a());
    if (localNfcAdapter == null)
    {
      o.d("MicroMsg.HceUtils", "alvinluo no nfc chip !");
      return false;
    }
    return localNfcAdapter.isEnabled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.li.d
 * JD-Core Version:    0.7.0.1
 */