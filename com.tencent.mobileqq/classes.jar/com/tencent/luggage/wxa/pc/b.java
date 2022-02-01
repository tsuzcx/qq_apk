package com.tencent.luggage.wxa.pc;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.luggage.wxa.qz.o;

public class b
{
  public static PackageInfo a(Context paramContext, String paramString)
  {
    if (paramString == null)
    {
      o.b("Luggage.AndroidPackageUtil", "getPackageInfo fail, packageName is null");
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      o.c("Luggage.AndroidPackageUtil", paramContext.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pc.b
 * JD-Core Version:    0.7.0.1
 */