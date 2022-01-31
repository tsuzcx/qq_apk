package com.tencent.gdtad.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.securitysdk.utils.MD5;

public class GdtDeviceUtil
{
  private static String a = "GdtDeviceUtil";
  private static String b;
  private static String c;
  
  public static final int a(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {}
    for (;;)
    {
      return 0;
      try
      {
        paramContext = paramContext.getSubscriberId();
        if (TextUtils.isEmpty(paramContext)) {
          continue;
        }
        if ((paramContext.startsWith("46000")) || (paramContext.startsWith("46002")) || (paramContext.startsWith("46007")) || (paramContext.startsWith("46008")))
        {
          i = 1;
          return i;
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          int i;
          GdtLog.d(a, "getCarrier error", paramContext);
          paramContext = null;
          continue;
          if ((paramContext.startsWith("46001")) || (paramContext.startsWith("46006")) || (paramContext.startsWith("46009"))) {
            i = 2;
          } else if ((paramContext.startsWith("46003")) || (paramContext.startsWith("46005")) || (paramContext.startsWith("46011"))) {
            i = 3;
          } else {
            i = 0;
          }
        }
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    if (paramContext == null) {}
    for (;;)
    {
      return b;
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if ((localTelephonyManager == null) || (!a(paramContext, "android.permission.READ_PHONE_STATE"))) {
        continue;
      }
      try
      {
        paramContext = localTelephonyManager.getDeviceId();
        if (TextUtils.isEmpty(paramContext)) {
          continue;
        }
        paramContext = paramContext.toLowerCase();
        if (TextUtils.isEmpty(paramContext)) {
          continue;
        }
        paramContext = MD5.a(paramContext);
        if (TextUtils.isEmpty(paramContext)) {
          continue;
        }
        paramContext = paramContext.toLowerCase();
        if (TextUtils.isEmpty(paramContext)) {
          continue;
        }
        b = paramContext;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          GdtLog.d(a, "getDeviceId error", paramContext);
          paramContext = null;
        }
      }
    }
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    PackageManager localPackageManager;
    do
    {
      return false;
      localPackageManager = paramContext.getPackageManager();
    } while ((localPackageManager == null) || (localPackageManager.checkPermission(paramString, paramContext.getPackageName()) != 0));
    return true;
  }
  
  public static String b(Context paramContext)
  {
    if (!TextUtils.isEmpty(c)) {
      return c;
    }
    if (paramContext == null) {}
    for (;;)
    {
      return c;
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext != null) {}
      try
      {
        paramContext = paramContext.getConnectionInfo();
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.getMacAddress();
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          GdtLog.d(a, "getMacAddress error", paramContext);
          paramContext = null;
        }
      }
      if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.equals(paramContext, "02:00:00:00:00:00")))
      {
        paramContext = paramContext.replaceAll(":", "");
        if (!TextUtils.isEmpty(paramContext))
        {
          paramContext = paramContext.toUpperCase();
          if (!TextUtils.isEmpty(paramContext))
          {
            paramContext = MD5.a(paramContext);
            if (!TextUtils.isEmpty(paramContext))
            {
              paramContext = paramContext.toLowerCase();
              if (!TextUtils.isEmpty(paramContext)) {
                c = paramContext;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceUtil
 * JD-Core Version:    0.7.0.1
 */