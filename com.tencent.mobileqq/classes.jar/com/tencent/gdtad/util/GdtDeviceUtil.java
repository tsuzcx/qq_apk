package com.tencent.gdtad.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.net.GdtNetUtil;
import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import com.tencent.gdtad.qqproxy.GdtVersionUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.securitysdk.utils.MD5;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo.Location;

public class GdtDeviceUtil
{
  private static String a = "GdtDeviceUtil";
  private static String b;
  private static String c;
  
  public static final int a(Context paramContext)
  {
    paramContext = c(paramContext);
    if (TextUtils.isEmpty(paramContext)) {}
    do
    {
      return 0;
      if ((paramContext.startsWith("46000")) || (paramContext.startsWith("46002")) || (paramContext.startsWith("46007")) || (paramContext.startsWith("46008"))) {
        return 1;
      }
      if ((paramContext.startsWith("46001")) || (paramContext.startsWith("46006")) || (paramContext.startsWith("46009"))) {
        return 2;
      }
    } while ((!paramContext.startsWith("46003")) && (!paramContext.startsWith("46005")) && (!paramContext.startsWith("46011")));
    return 3;
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
  
  public static qq_ad_get.QQAdGet.DeviceInfo a(Context paramContext)
  {
    if (paramContext == null)
    {
      GdtLog.d(a, "getDeviceInfo error");
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      qq_ad_get.QQAdGet.DeviceInfo localDeviceInfo = new qq_ad_get.QQAdGet.DeviceInfo();
      Object localObject = a(paramContext);
      String str = b(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localDeviceInfo.muid.set((String)localObject);
        localDeviceInfo.muid_type.set(1);
        label58:
        localDeviceInfo.conn.set(GdtNetUtil.a(paramContext));
      }
      try
      {
        int i = Integer.parseInt(c(paramContext));
        localDeviceInfo.carrier_code.set(i);
        localDeviceInfo.os_ver.set(Build.VERSION.RELEASE);
        localDeviceInfo.qq_ver.set(GdtVersionUtil.a());
        localDeviceInfo.os_type.set(2);
        localObject = GdtLocationUtil.INSTANCE.getLocation();
        paramContext = localDeviceInfo;
        if (localObject == null) {
          continue;
        }
        paramContext = localDeviceInfo;
        if (localObject.length != 2) {
          continue;
        }
        paramContext = new qq_ad_get.QQAdGet.DeviceInfo.Location();
        paramContext.latitude.set(localObject[0]);
        paramContext.longitude.set(localObject[1]);
        localDeviceInfo.location.set(paramContext);
        return localDeviceInfo;
        if (!TextUtils.isEmpty(str))
        {
          localDeviceInfo.muid.set(str);
          localDeviceInfo.muid_type.set(3);
          break label58;
        }
        localDeviceInfo.muid_type.set(0);
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          GdtLog.d(a, "initDeviceInfo", paramContext);
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
  
  public static final String c(Context paramContext)
  {
    if (paramContext == null)
    {
      GdtLog.d(a, "getCarrierCode error");
      return null;
    }
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      GdtLog.d(a, "getCarrierCode", paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceUtil
 * JD-Core Version:    0.7.0.1
 */