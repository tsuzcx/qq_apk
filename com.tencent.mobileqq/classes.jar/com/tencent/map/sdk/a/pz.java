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
  public static String a;
  
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
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(str, 128);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      paramContext = localObject;
    }
    if (paramContext == null) {
      return "";
    }
    if (paramContext.metaData == null) {
      return "";
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
      Object localObject = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      paramContext = ((PackageInfo)localObject).versionName;
      int i = ((PackageInfo)localObject).versionCode;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(i);
      paramContext = ((StringBuilder)localObject).toString();
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
      return "";
    }
    paramContext = paramContext.getConnectionInfo();
    if (paramContext == null) {
      return "";
    }
    String str = paramContext.getMacAddress();
    paramContext = str;
    if (str == null) {
      paramContext = "";
    }
    return paramContext;
  }
  
  @SuppressLint({"HardwareIds"})
  public static String f(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (localTelephonyManager == null) {
      return "";
    }
    int i = localTelephonyManager.getPhoneType();
    Object localObject4 = null;
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      Object localObject1 = localObject4;
      if (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
        if (Build.VERSION.SDK_INT >= 29)
        {
          if (i == 1)
          {
            try
            {
              localObject1 = localTelephonyManager.getImei();
            }
            catch (Exception localException1)
            {
              Log.e("mapsdk", "need permission android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE", localException1);
              localObject2 = localObject4;
            }
          }
          else
          {
            localObject2 = localObject4;
            if (i == 2) {
              localObject2 = localTelephonyManager.getMeid();
            }
          }
        }
        else {
          localObject2 = localTelephonyManager.getDeviceId();
        }
      }
    }
    else
    {
      try
      {
        localObject2 = localTelephonyManager.getDeviceId();
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        localObject3 = localObject4;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    } else {
      paramContext = (Context)localObject3;
    }
    Object localObject3 = paramContext;
    if (TextUtils.isEmpty(paramContext)) {
      localObject3 = "";
    }
    return localObject3;
  }
  
  public static String g(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = null;
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      paramContext = localObject;
    }
    if (paramContext != null) {
      paramContext = paramContext.loadLabel(localPackageManager);
    } else {
      paramContext = "can't find app name";
    }
    try
    {
      paramContext = URLEncoder.encode(paramContext.toString(), "utf-8");
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String h(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.widthPixels);
      localStringBuilder.append("*");
      localStringBuilder.append(paramContext.heightPixels);
      paramContext = localStringBuilder.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.pz
 * JD-Core Version:    0.7.0.1
 */