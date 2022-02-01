package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class PackageManagerCompat
{
  private static final String TAG = "PackageUtils";
  private static final String VERSION = "4.0.20.301";
  
  public static Bundle getMetaDataFromApp(Context paramContext, String paramString)
  {
    paramString = paramContext.getPackageManager();
    if (paramString == null) {
      return null;
    }
    try
    {
      paramContext = paramString.getApplicationInfo(paramContext.getPackageName(), 128);
    }
    catch (RuntimeException paramContext) {}catch (PackageManager.NameNotFoundException paramContext) {}
    Logger.w("PackageUtils", "NameNotFoundException:", paramContext);
    paramContext = null;
    if (paramContext == null) {
      return null;
    }
    return paramContext.metaData;
  }
  
  public static String getVersionName(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null) {
      return "";
    }
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 16384).versionName;
      return paramContext;
    }
    catch (RuntimeException paramContext) {}catch (PackageManager.NameNotFoundException paramContext) {}
    Logger.w("PackageUtils", paramContext.getClass().getName());
    return "";
  }
  
  public String getPackageName(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null) {
      return "";
    }
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 16384).packageName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException|RuntimeException paramContext)
    {
      label29:
      break label29;
    }
    Logger.w("PackageUtils", "Failed to get Package managers Package Info");
    return "";
  }
  
  public String getVersion(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null) {
      return "";
    }
    try
    {
      int i = localPackageManager.getPackageInfo(paramContext.getPackageName(), 16384).versionCode;
      return String.valueOf(i);
    }
    catch (PackageManager.NameNotFoundException|RuntimeException paramContext)
    {
      label32:
      break label32;
    }
    Logger.w("PackageUtils", "Failed to get Package managers Package Info");
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.PackageManagerCompat
 * JD-Core Version:    0.7.0.1
 */