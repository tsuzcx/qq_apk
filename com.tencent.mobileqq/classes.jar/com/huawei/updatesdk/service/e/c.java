package com.huawei.updatesdk.service.e;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  private static Integer a = null;
  private static boolean b = false;
  private static boolean c = false;
  private static Field d = null;
  
  public static PackageInfo a(String paramString, Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("PackageUtils", "not found: " + paramString);
    }
    return null;
  }
  
  public static c.a a(Context paramContext)
  {
    c.a locala = c.a.a;
    if (paramContext == null) {}
    for (;;)
    {
      return locala;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo("com.huawei.appmarket", 0);
        if (paramContext != null)
        {
          Log.i("PackageUtils", "appmarket info," + "versioncode = " + paramContext.versionCode + "versionName = " + paramContext.versionName);
          if (paramContext.versionCode < 70203000) {
            return c.a.c;
          }
          paramContext = c.a.b;
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.b("PackageUtils", "isInstallByPackage Exception:" + paramContext.toString());
      }
    }
    return locala;
  }
  
  public static Integer a()
  {
    if (b) {
      return a;
    }
    try
    {
      Class localClass = Class.forName("android.content.pm.PackageParser");
      a = Integer.valueOf(localClass.getDeclaredField("PARSE_IS_REMOVABLE_PREINSTALLED_APK").getInt(localClass));
      b = true;
      return a;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.a("PackageUtils", "isDelApp error NoSuchFieldException:" + localNoSuchFieldException.toString());
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.a("PackageUtils", "isDelApp error ClassNotFoundException:" + localClassNotFoundException.toString());
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.a("PackageUtils", "isDelApp error IllegalAccessException:" + localIllegalAccessException.toString());
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.a("PackageUtils", "isDelApp error IllegalArgumentException:" + localIllegalArgumentException.toString());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.a("PackageUtils", localException.toString());
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
        if (paramContext != null) {
          return true;
        }
      }
      catch (Exception paramContext)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.b("PackageUtils", "isAppInstalled NameNotFoundException:" + paramContext.toString());
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (Pattern.compile("(\\.)+[\\\\/]+").matcher(paramString).find())
    {
      com.huawei.updatesdk.a.a.b.a.a.a.a("PackageUtils", "remov APK fail. the apk path is not valid");
      return false;
    }
    return new File(paramString).delete();
  }
  
  public static int b(String paramString)
  {
    int j = 0;
    Object localObject = com.huawei.updatesdk.a.b.a.a.a().b();
    try
    {
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(paramString, 128);
      int i = j;
      if (localObject != null)
      {
        i = j;
        if (((PackageInfo)localObject).applicationInfo != null)
        {
          i = j;
          if (((PackageInfo)localObject).applicationInfo.metaData != null)
          {
            i = j;
            if (((PackageInfo)localObject).applicationInfo.metaData.containsKey("com.huawei.maple.flag")) {
              i = 1;
            }
          }
        }
      }
      return i;
    }
    catch (Exception localException)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("PackageUtils", "getMapleStatus not found: " + paramString);
    }
    return 0;
  }
  
  public static Field b()
  {
    if (c) {
      return d;
    }
    try
    {
      d = ApplicationInfo.class.getField("hwFlags");
      c = true;
      return d;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.a("PackageUtils", "can not find hwFlags");
      }
    }
  }
  
  public static boolean b(Context paramContext)
  {
    return d(paramContext) > 90000000;
  }
  
  public static boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      bool1 = bool2;
      if (new ContextWrapper(com.huawei.updatesdk.a.b.a.a.a().b()).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean c(Context paramContext)
  {
    return d(paramContext) > 100200000;
  }
  
  private static int d(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo("com.huawei.appmarket", 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.b("PackageUtils", "isInstallByPackage Exception:" + paramContext.toString());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.e.c
 * JD-Core Version:    0.7.0.1
 */