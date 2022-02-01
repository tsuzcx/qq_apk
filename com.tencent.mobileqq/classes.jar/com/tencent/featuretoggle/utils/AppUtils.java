package com.tencent.featuretoggle.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Process;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class AppUtils
{
  private static ApplicationInfo jdField_a_of_type_AndroidContentPmApplicationInfo;
  private static volatile String jdField_a_of_type_JavaLangString = "";
  
  public static Context a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {
      return paramContext;
    }
    return localContext;
  }
  
  private static ApplicationInfo a(Context paramContext)
  {
    if (jdField_a_of_type_AndroidContentPmApplicationInfo == null) {
      try
      {
        jdField_a_of_type_AndroidContentPmApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        if (!LogUtils.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
    }
    return jdField_a_of_type_AndroidContentPmApplicationInfo;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getApplicationContext().getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      if (!LogUtils.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext).metaData;
    if (paramContext != null) {
      return String.valueOf(paramContext.get(paramString));
    }
    return null;
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_JavaLangString = e(paramContext);
  }
  
  public static boolean a(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getPackageName() != null)) {
      return paramContext.getPackageName().equals(d(paramContext));
    }
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.checkCallingOrSelfPermission(paramString);
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramContext)
    {
      if (!LogUtils.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = a(paramContext).metaData;
    if (paramContext != null) {
      return paramContext.getBoolean(paramString, paramBoolean);
    }
    return paramBoolean;
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageName();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (!LogUtils.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String c(Context paramContext)
  {
    if (!Utils.a(jdField_a_of_type_JavaLangString)) {
      return jdField_a_of_type_JavaLangString;
    }
    a(paramContext);
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      int i = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i)
        {
          paramContext = localRunningAppProcessInfo.processName;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      if (!LogUtils.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  @SuppressLint({"MissingPermission"})
  private static String e(Context paramContext)
  {
    if (paramContext != null)
    {
      if (!a(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
        return "";
      }
      try
      {
        Object localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localObject != null)
        {
          if (!((NetworkInfo)localObject).isConnected()) {
            return "";
          }
          if (((NetworkInfo)localObject).getType() == 0)
          {
            InetAddress localInetAddress;
            do
            {
              paramContext = NetworkInterface.getNetworkInterfaces();
              while (!((Enumeration)localObject).hasMoreElements())
              {
                if (!paramContext.hasMoreElements()) {
                  break;
                }
                localObject = ((NetworkInterface)paramContext.nextElement()).getInetAddresses();
              }
              localInetAddress = (InetAddress)((Enumeration)localObject).nextElement();
            } while ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)) || ("null".equals(localInetAddress.getHostAddress())) || (localInetAddress.getHostAddress() == null));
            return localInetAddress.getHostAddress().trim();
          }
          if ((((NetworkInfo)localObject).getType() == 1) && (a(paramContext, "android.permission.ACCESS_WIFI_STATE")))
          {
            paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
            if (paramContext != null)
            {
              int i = paramContext.getConnectionInfo().getIpAddress();
              paramContext = new StringBuilder();
              paramContext.append(i & 0xFF);
              paramContext.append(".");
              paramContext.append(i >> 8 & 0xFF);
              paramContext.append(".");
              paramContext.append(i >> 16 & 0xFF);
              paramContext.append(".");
              paramContext.append(i >> 24 & 0xFF);
              paramContext = paramContext.toString();
              return paramContext;
            }
          }
        }
        else
        {
          return "";
        }
      }
      catch (Throwable paramContext)
      {
        LogUtils.a(paramContext);
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.AppUtils
 * JD-Core Version:    0.7.0.1
 */