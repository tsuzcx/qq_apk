package com.tencent.map.sdk.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;

public final class dc
{
  private static String a = "";
  private static String b = "";
  
  public static int a(Context paramContext, String paramString)
  {
    int j = -407;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramString, 128);
      if (paramContext == null) {
        return -407;
      }
      if (paramContext.metaData == null) {
        return -408;
      }
      int i = paramContext.metaData.getInt("halley_appid", 0);
      j = i;
      if (i <= 0) {
        return -408;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return j;
  }
  
  public static dc.a a(int paramInt, Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getServiceInfo(new ComponentName(paramString1, paramString2), 128);
      if (paramContext != null)
      {
        paramContext = new dc.a(paramInt, paramString1, paramContext.enabled, paramContext.exported, paramContext.processName, paramContext.metaData);
        return paramContext;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static String a()
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    String str = ac.a().getSharedPreferences(a(false), 0).getString("deviceid", "");
    b = str;
    return str;
  }
  
  public static String a(int paramInt)
  {
    String str = "";
    if (paramInt == 2) {
      str = "2g";
    }
    do
    {
      return str;
      if (paramInt == 3) {
        return "3g";
      }
      if (paramInt == 4) {
        return "4g";
      }
    } while (paramInt != 1);
    return "wifi";
  }
  
  public static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    String str3 = paramContext.getPackageName();
    String str2 = dg.a(Process.myPid());
    String str1;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.startsWith(str3)) {}
    }
    else
    {
      str1 = dg.a(paramContext, Process.myPid());
    }
    a = str1;
    return str1;
  }
  
  private static String a(boolean paramBoolean)
  {
    Object localObject2 = new StringBuilder("HalleyServicePreferences_").append(ac.c());
    if (ac.b()) {}
    for (Object localObject1 = "_test";; localObject1 = "")
    {
      localObject2 = (String)localObject1;
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = (String)localObject2 + "_" + ac.g();
      }
      return localObject1;
    }
  }
  
  public static void a(String paramString)
  {
    ac.a().getSharedPreferences(a(false), 0).edit().putString("deviceid", paramString).commit();
    b = paramString;
  }
  
  public static void a(String paramString, int paramInt)
  {
    ac.a().getSharedPreferences(a(false), 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(String paramString, long paramLong)
  {
    ac.a().getSharedPreferences(a(false), 0).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    ac.a().getSharedPreferences(a(true), 0).edit().putString(paramString1, paramString2).commit();
  }
  
  public static int b(String paramString)
  {
    return ac.a().getSharedPreferences(a(false), 0).getInt(paramString, 0);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return ac.a().getSharedPreferences(a(true), 0).getString(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.dc
 * JD-Core Version:    0.7.0.1
 */