package com.tencent.featuretoggle.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;

public class DeviceUtils
{
  public static String a()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (!LogUtils.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  @SuppressLint({"MissingPermission"})
  public static String a(Context paramContext)
  {
    if (paramContext != null)
    {
      if (!AppUtils.b(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {
        return "unknown";
      }
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo == null) {
          return null;
        }
        if (localNetworkInfo.getType() == 1)
        {
          paramContext = "WIFI";
        }
        else if (localNetworkInfo.getType() == 0)
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null)
          {
            int i = paramContext.getNetworkType();
            switch (i)
            {
            default: 
              paramContext = new StringBuilder();
              paramContext.append("MOBILE(");
              paramContext.append(i);
              paramContext.append(")");
              paramContext = paramContext.toString();
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        if (!LogUtils.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
    }
    else
    {
      return "unknown";
    }
    for (;;)
    {
      return paramContext;
      break;
      paramContext = "HSPA+";
      continue;
      paramContext = "eHRPD";
      continue;
      paramContext = "LTE";
      continue;
      paramContext = "EVDO_B";
      continue;
      paramContext = "iDen";
      continue;
      paramContext = "HSPA";
      continue;
      paramContext = "HSUPA";
      continue;
      paramContext = "HSDPA";
      continue;
      paramContext = "1xRTT";
      continue;
      paramContext = "EVDO_A";
      continue;
      paramContext = "EVDO_0";
      continue;
      paramContext = "CDMA";
      continue;
      paramContext = "UMTS";
      continue;
      paramContext = "EDGE";
      continue;
      paramContext = "GPRS";
    }
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Android ");
    localStringBuilder.append(a());
    localStringBuilder.append(",level ");
    localStringBuilder.append(c());
    return localStringBuilder.toString();
  }
  
  public static int c()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      return i;
    }
    catch (Throwable localThrowable)
    {
      if (!LogUtils.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.DeviceUtils
 * JD-Core Version:    0.7.0.1
 */