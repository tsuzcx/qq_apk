package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rr.a;
import java.util.Locale;

final class s$b
  implements s.a
{
  private s$b(s params) {}
  
  public a a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (af.c(paramString2)) {
      str = s.a(this.a);
    }
    try
    {
      long l = s.a(this.a, paramString1);
      paramString1 = String.format(Locale.US, "%d|%s", new Object[] { Long.valueOf(l), str });
      try
      {
        o.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "hy: attach media obj: %s", new Object[] { paramString1 });
        paramString1 = s.a(this.a, paramString1, s.b(this.a));
      }
      catch (Exception paramString1)
      {
        o.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", paramString1, "attachMediaObject, enc exp = ", new Object[0]);
        paramString1 = null;
      }
      if (af.c(paramString1)) {
        return null;
      }
      paramString2 = new StringBuilder();
      paramString2.append("blob_");
      paramString2.append(paramString1);
      paramString1 = paramString2.toString();
      paramString2 = new StringBuilder();
      paramString2.append(s.c(this.a));
      paramString2.append(paramString1);
      paramString2 = paramString2.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(s.d(this.a));
      localStringBuilder.append(paramString1);
      if (af.c(str))
      {
        paramString1 = "";
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append('.');
        paramString1.append(str);
        paramString1 = paramString1.toString();
      }
      localStringBuilder.append(paramString1);
      paramString1 = localStringBuilder.toString();
      o.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", new Object[] { paramString1, paramString2 });
      return a.a(paramString1, paramString2, str);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.s.b
 * JD-Core Version:    0.7.0.1
 */