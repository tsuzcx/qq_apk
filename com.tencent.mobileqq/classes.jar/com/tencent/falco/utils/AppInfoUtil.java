package com.tencent.falco.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public final class AppInfoUtil
{
  public static String getAppName(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.labelRes;
      paramContext = paramContext.getResources().getString(i);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "App";
  }
  
  public static String getDeviceId()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("35");
    ((StringBuilder)localObject).append(Build.BOARD.length() % 10);
    ((StringBuilder)localObject).append(Build.BRAND.length() % 10);
    ((StringBuilder)localObject).append(Build.CPU_ABI.length() % 10);
    ((StringBuilder)localObject).append(Build.DEVICE.length() % 10);
    ((StringBuilder)localObject).append(Build.DISPLAY.length() % 10);
    ((StringBuilder)localObject).append(Build.HOST.length() % 10);
    ((StringBuilder)localObject).append(Build.ID.length() % 10);
    ((StringBuilder)localObject).append(Build.MANUFACTURER.length() % 10);
    ((StringBuilder)localObject).append(Build.MODEL.length() % 10);
    ((StringBuilder)localObject).append(Build.PRODUCT.length() % 10);
    ((StringBuilder)localObject).append(Build.TAGS.length() % 10);
    ((StringBuilder)localObject).append(Build.TYPE.length() % 10);
    ((StringBuilder)localObject).append(Build.USER.length() % 10);
    String str2 = ((StringBuilder)localObject).toString();
    localObject = null;
    try
    {
      String str1 = Build.class.getField("SERIAL").get(null).toString();
      localObject = str1;
      str1 = new UUID(str2.hashCode(), str1.hashCode()).toString();
      return str1;
    }
    catch (Exception localException)
    {
      label244:
      break label244;
    }
    return new UUID(str2.hashCode(), ((String)localObject).hashCode()).toString();
  }
  
  public static PackageInfo getPackageInfo(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String getPackageName(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext != null)
      {
        paramContext = paramContext.packageName;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static List<String> getProcessListName(Context paramContext, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.processName.startsWith(paramString)) {
        localArrayList.add(localRunningAppProcessInfo.processName);
      }
    }
    return localArrayList;
  }
  
  public static String getProcessName(Context paramContext)
  {
    int i = Process.myPid();
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return null;
  }
  
  public static int getVersionCode(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext != null)
      {
        int i = paramContext.versionCode;
        return i;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return -1;
  }
  
  public static String getVersionName(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private static void gotoMiuiPermission(Context paramContext)
  {
    try
    {
      localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
      localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
      localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable localThrowable1)
    {
      Intent localIntent;
      label43:
      label86:
      break label43;
    }
    try
    {
      localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
      localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable localThrowable2)
    {
      break label86;
    }
    gotoNormalPermission(paramContext);
  }
  
  private static void gotoNormalPermission(Context paramContext)
  {
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.addFlags(268435456);
    localIntent.setData(Uri.fromParts("package", getPackageName(paramContext), null));
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void jumpAppSettings(Context paramContext)
  {
    String str = Build.BRAND;
    if ((!TextUtils.equals(str.toLowerCase(), "redmi")) && (!TextUtils.equals(str.toLowerCase(), "xiaomi")))
    {
      gotoNormalPermission(paramContext);
      return;
    }
    gotoMiuiPermission(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.utils.AppInfoUtil
 * JD-Core Version:    0.7.0.1
 */