package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;

public class NetworkUtils
{
  private static String a = "";
  private static String b = "";
  private static volatile boolean c = false;
  
  public static boolean a(Context paramContext)
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static boolean b(Context paramContext)
  {
    return AppNetConnInfo.isNetSupport();
  }
  
  public static String c(Context paramContext)
  {
    g(paramContext);
    return a;
  }
  
  public static String d(Context paramContext)
  {
    g(paramContext);
    return b;
  }
  
  public static String e(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext != null)
        {
          paramContext = NetworkMonitor.getConnectionInfo(paramContext);
          if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.getSSID())))
          {
            paramContext = paramContext.getSSID().replace("\"", "");
            return paramContext;
          }
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  private static void g(Context paramContext)
  {
    if ((!c) && (paramContext != null))
    {
      paramContext = paramContext.getApplicationContext();
      c = true;
      AppNetConnInfo.registerNetChangeReceiver(paramContext, new NetworkUtils.1(paramContext));
      h(paramContext);
    }
  }
  
  private static void h(Context paramContext)
  {
    if (paramContext != null)
    {
      WifiInfo localWifiInfo = NetworkMonitor.getConnectionInfo((WifiManager)paramContext.getSystemService("wifi"));
      if (localWifiInfo != null)
      {
        boolean bool = TextUtils.isEmpty(localWifiInfo.getBSSID());
        String str = "";
        if (bool) {
          paramContext = "";
        } else {
          paramContext = localWifiInfo.getBSSID();
        }
        a = paramContext;
        if (TextUtils.isEmpty(a)) {
          paramContext = str;
        } else {
          paramContext = localWifiInfo.getSSID();
        }
        b = paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.NetworkUtils
 * JD-Core Version:    0.7.0.1
 */