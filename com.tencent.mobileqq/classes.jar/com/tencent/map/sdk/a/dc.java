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
      if (i <= 0) {
        return -408;
      }
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return -407;
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
      return null;
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
    if (paramInt == 2) {
      return "2g";
    }
    if (paramInt == 3) {
      return "3g";
    }
    if (paramInt == 4) {
      return "4g";
    }
    if (paramInt == 1) {
      return "wifi";
    }
    return "";
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
    Object localObject2 = new StringBuilder("HalleyServicePreferences_");
    ((StringBuilder)localObject2).append(ac.c());
    if (ac.b()) {
      localObject1 = "_test";
    } else {
      localObject1 = "";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject1 = localObject2;
    if (paramBoolean)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(ac.g());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.dc
 * JD-Core Version:    0.7.0.1
 */