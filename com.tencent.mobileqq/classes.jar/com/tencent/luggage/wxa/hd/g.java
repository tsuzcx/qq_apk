package com.tencent.luggage.wxa.hd;

import android.content.SharedPreferences.Editor;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.w;
import com.tencent.tfd.sdk.wxa.ITuringDID;
import com.tencent.tfd.sdk.wxa.TuringDIDConfig;
import com.tencent.tfd.sdk.wxa.TuringDIDConfig.Builder;
import com.tencent.tfd.sdk.wxa.TuringDIDService;

public class g
{
  private static w a = w.a("OAIDService");
  private static boolean b = false;
  
  public static String a()
  {
    return a.getString("OAIDService#OAID", "");
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      if (!b)
      {
        b = true;
        o.d("OAIDService", "Turing VersionInfo: %s, uniqueId: %s init", new Object[] { TuringDIDService.getVersionInfo(), paramString });
        TuringDIDService.init(TuringDIDConfig.newBuilder(r.a()).uniqueId(paramString).build());
        paramString = TuringDIDService.getTuringDID(r.a());
        if (paramString.getErrorCode() != 0)
        {
          o.b("OAIDService", "getOAID fail: %d", new Object[] { Integer.valueOf(paramString.getErrorCode()) });
          return false;
        }
        paramString = paramString.getAIDTicket();
        o.d("OAIDService", "getOAID success: %s", new Object[] { paramString });
        a.putString("OAIDService#OAID", paramString).commit();
      }
      return true;
    }
    finally {}
  }
  
  public static void b(String paramString)
  {
    b = true;
    a.putString("OAIDService#OAID", paramString).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.g
 * JD-Core Version:    0.7.0.1
 */