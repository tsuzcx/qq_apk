package com.tencent.mm.plugin.appbrand.appcache;

import android.content.res.AssetManager;
import com.tencent.luggage.wxa.ez.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import java.io.InputStream;

public final class u
{
  public static final int a = 504;
  public static final String[] b = a.c;
  static final u.a c = u.a.c;
  private static Boolean d = null;
  
  public static InputStream a(String paramString)
  {
    paramString = k.b(paramString);
    int i = u.1.a[c.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("wxa_library");
        localStringBuilder.append(paramString);
        return b(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("wxa_library/develop");
      localStringBuilder.append(paramString);
      return b(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wxa_library/custom");
    localStringBuilder.append(paramString);
    return b(localStringBuilder.toString());
  }
  
  private static InputStream b(String paramString)
  {
    Object localObject = r.e();
    try
    {
      localObject = ((AssetManager)localObject).open(paramString, 3);
      return localObject;
    }
    catch (Exception localException)
    {
      o.f("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, localException });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.u
 * JD-Core Version:    0.7.0.1
 */