package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Build.VERSION;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.k;

public final class i
{
  public static boolean a(String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        long l = af.d();
        b(k.c(paramString1, true), k.c(paramString2, true));
        o.e("MicroMsg.AppBrand.FileMove", "move, os rename works, cost = %d", new Object[] { Long.valueOf(af.d() - l) });
        return true;
      }
      catch (Exception localException)
      {
        o.b("MicroMsg.AppBrand.FileMove", "move, os rename exp = %s", new Object[] { af.a(localException) });
      }
    }
    return new com.tencent.luggage.wxa.rt.i(paramString1).a(new com.tencent.luggage.wxa.rt.i(paramString2));
  }
  
  private static void b(String paramString1, String paramString2)
  {
    new i.a().a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.i
 * JD-Core Version:    0.7.0.1
 */