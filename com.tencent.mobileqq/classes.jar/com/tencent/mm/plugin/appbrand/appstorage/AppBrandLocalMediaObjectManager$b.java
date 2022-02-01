package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rr.a;
import java.util.Locale;

final class AppBrandLocalMediaObjectManager$b
  implements AppBrandLocalMediaObjectManager.a
{
  public a a(String paramString1, String paramString2, String paramString3)
  {
    String str1 = paramString3;
    if (af.c(paramString3)) {
      str1 = AppBrandLocalMediaObjectManager.b();
    }
    try
    {
      long l = AppBrandLocalMediaObjectManager.c(paramString2);
      paramString2 = String.format(Locale.US, "%d|%s", new Object[] { Long.valueOf(l), str1 });
      try
      {
        paramString2 = AppBrandLocalMediaObjectManager.a(paramString2, paramString1);
      }
      catch (Exception paramString2)
      {
        o.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", paramString2, "attachMediaObject, enc exp = ", new Object[0]);
        paramString2 = null;
      }
      if (af.c(paramString2)) {
        return null;
      }
      paramString3 = new StringBuilder();
      paramString3.append("tmp_");
      paramString3.append(paramString2);
      String str2 = paramString3.toString();
      paramString2 = new StringBuilder();
      paramString2.append(AppBrandLocalMediaObjectManager.b(paramString1));
      paramString2.append(str2);
      paramString2 = paramString2.toString();
      paramString3 = new StringBuilder();
      paramString3.append("wxfile://");
      paramString3.append(str2);
      if (af.c(str1))
      {
        paramString1 = "";
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append('.');
        paramString1.append(str1);
        paramString1 = paramString1.toString();
      }
      paramString3.append(paramString1);
      paramString1 = paramString3.toString();
      o.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", new Object[] { paramString1, paramString2 });
      return a.a(paramString1, paramString2, str1);
    }
    catch (Exception paramString1)
    {
      o.b("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", new Object[] { af.a(paramString1) });
    }
    return null;
  }
  
  public String toString()
  {
    return "V2MediaObjectInfoHandler";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.b
 * JD-Core Version:    0.7.0.1
 */