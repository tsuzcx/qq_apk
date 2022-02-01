package com.tencent.map.sdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import java.net.URLEncoder;

public final class pz
{
  public static String a = null;
  
  public static float a(Context paramContext)
  {
    if (paramContext == null) {
      return 1.0F;
    }
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return "";
    }
    String str = paramContext.getPackageName();
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
      if (paramContext == null) {
        return "";
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
      if (paramContext.metaData == null) {
        return "";
      }
    }
    return paramContext.metaData.getString(paramString);
  }
  
  public static int b(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int c(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static String d(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      String str = paramContext.versionName;
      int i = paramContext.versionCode;
      paramContext = str + i;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  @SuppressLint({"HardwareIds"})
  public static String e(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (paramContext == null) {
      paramContext = "";
    }
    String str;
    do
    {
      return paramContext;
      paramContext = paramContext.getConnectionInfo();
      if (paramContext == null) {
        return "";
      }
      str = paramContext.getMacAddress();
      paramContext = str;
    } while (str != null);
    return "";
  }
  
  @SuppressLint({"HardwareIds"})
  public static String f(Context paramContext)
  {
    if (paramContext == null)
    {
      paramContext = "";
      return paramContext;
    }
    Object localObject1 = (TelephonyManager)paramContext.getSystemService("phone");
    if (localObject1 == null) {
      return "";
    }
    int i = ((TelephonyManager)localObject1).getPhoneType();
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
        break label146;
      }
      if (Build.VERSION.SDK_INT >= 29) {
        if (i != 1) {}
      }
    }
    for (;;)
    {
      String str;
      try
      {
        localObject1 = ((TelephonyManager)localObject1).getImei();
        Object localObject3 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject3 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
        }
        paramContext = (Context)localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break;
        }
        return "";
      }
      catch (Exception localException1)
      {
        Log.e("mapsdk", "need permission android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE", localException1);
        str = null;
        continue;
      }
      if (i == 2)
      {
        str = str.getMeid();
        continue;
        str = str.getDeviceId();
        continue;
        try
        {
          str = str.getDeviceId();
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
      else
      {
        label146:
        Object localObject2 = null;
      }
    }
  }
  
  public static String g(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = null;
    for (;;)
    {
      try
      {
        paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
        if (paramContext != null) {
          paramContext = paramContext.loadLabel(localPackageManager);
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        try
        {
          paramContext = URLEncoder.encode(paramContext.toString(), "utf-8");
          return paramContext;
        }
        catch (Exception paramContext)
        {
          return "";
        }
        paramContext = paramContext;
        paramContext.printStackTrace();
        paramContext = localObject;
        continue;
      }
      paramContext = "can't find app name";
    }
  }
  
  public static String h(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      paramContext = paramContext.widthPixels + "*" + paramContext.heightPixels;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.pz
 * JD-Core Version:    0.7.0.1
 */