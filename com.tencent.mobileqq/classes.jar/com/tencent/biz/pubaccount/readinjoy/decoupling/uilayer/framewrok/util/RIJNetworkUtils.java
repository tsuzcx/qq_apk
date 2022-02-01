package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class RIJNetworkUtils
{
  private static String jdField_a_of_type_JavaLangString = "";
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private static String b = "";
  
  public static String a(Context paramContext)
  {
    b(paramContext);
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String b(Context paramContext)
  {
    b(paramContext);
    return b;
  }
  
  private static void b(Context paramContext)
  {
    if ((!jdField_a_of_type_Boolean) && (paramContext != null))
    {
      paramContext = paramContext.getApplicationContext();
      jdField_a_of_type_Boolean = true;
      AppNetConnInfo.registerNetChangeReceiver(paramContext, new RIJNetworkUtils.1(paramContext));
      c(paramContext);
    }
  }
  
  public static String c(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext != null)
        {
          paramContext = paramContext.getConnectionInfo().getBSSID();
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return "";
      }
      paramContext = "";
    }
  }
  
  private static void c(Context paramContext)
  {
    WifiInfo localWifiInfo;
    if (paramContext != null)
    {
      localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo != null)
      {
        if (!TextUtils.isEmpty(localWifiInfo.getBSSID())) {
          break label55;
        }
        paramContext = "";
        jdField_a_of_type_JavaLangString = paramContext;
        if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
          break label63;
        }
      }
    }
    label55:
    label63:
    for (paramContext = "";; paramContext = localWifiInfo.getSSID())
    {
      b = paramContext;
      return;
      paramContext = localWifiInfo.getBSSID();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJNetworkUtils
 * JD-Core Version:    0.7.0.1
 */