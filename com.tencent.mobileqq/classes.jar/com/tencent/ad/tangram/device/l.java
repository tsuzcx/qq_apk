package com.tencent.ad.tangram.device;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.e;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class l
{
  private static final String TAG = "AdMacAddress";
  private static String macAddress;
  
  public static String get(Context paramContext, boolean paramBoolean)
  {
    Object localObject = null;
    if (!TextUtils.isEmpty(macAddress))
    {
      paramContext = localObject;
      if (isValidMacAddress(macAddress)) {
        paramContext = macAddress;
      }
      return paramContext;
    }
    if (Build.VERSION.SDK_INT < 23) {
      paramContext = getByWifiInfo(paramContext, paramBoolean);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContext)) {
        macAddress = paramContext;
      }
      paramContext = localObject;
      if (!isValidMacAddress(macAddress)) {
        break;
      }
      return macAddress;
      if ((Build.VERSION.SDK_INT >= 23) && (Build.VERSION.SDK_INT <= 28)) {
        paramContext = getByInterface(paramContext, paramBoolean);
      } else {
        paramContext = null;
      }
    }
  }
  
  private static String getByInterface(Context paramContext, boolean paramBoolean)
  {
    if ((paramBoolean) && (!e.checkPermission(paramContext, "android.permission.INTERNET"))) {
      return null;
    }
    try
    {
      paramContext = getWlanName();
      Object localObject = NetworkInterface.getNetworkInterfaces();
      while (((Enumeration)localObject).hasMoreElements()) {
        if (localObject != null)
        {
          NetworkInterface localNetworkInterface = (NetworkInterface)((Enumeration)localObject).nextElement();
          if ((localNetworkInterface != null) && (localNetworkInterface.getName().equalsIgnoreCase(paramContext)))
          {
            paramContext = localNetworkInterface.getHardwareAddress();
            if (paramContext == null) {
              return null;
            }
            localObject = new StringBuilder();
            int j = paramContext.length;
            int i = 0;
            while (i < j)
            {
              ((StringBuilder)localObject).append(String.format("%02X:", new Object[] { Byte.valueOf(paramContext[i]) }));
              i += 1;
            }
            if (((StringBuilder)localObject).length() > 0) {
              ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
            }
            paramContext = ((StringBuilder)localObject).toString();
            return paramContext;
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      AdLog.i("AdMacAddress", "getByInterface", paramContext);
    }
    return null;
  }
  
  private static String getByWifiInfo(Context paramContext, boolean paramBoolean)
  {
    if ((paramBoolean) && (!e.checkPermission(paramContext, "android.permission.ACCESS_WIFI_STATE"))) {}
    do
    {
      for (;;)
      {
        return null;
        if (paramContext != null)
        {
          paramContext = paramContext.getApplicationContext();
          if (paramContext != null)
          {
            paramContext = paramContext.getSystemService("wifi");
            if ((paramContext instanceof WifiManager))
            {
              paramContext = (WifiManager)WifiManager.class.cast(paramContext);
              if (paramContext == null) {}
            }
          }
        }
        try
        {
          paramContext = paramContext.getConnectionInfo();
          if (paramContext != null) {
            paramContext = paramContext.getMacAddress();
          }
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            AdLog.e("AdMacAddress", "getByWifiInfo error", paramContext);
            paramContext = null;
          }
        }
      }
    } while (TextUtils.isEmpty(paramContext));
    return paramContext;
  }
  
  public static String getMacAddressCache(Context paramContext)
  {
    if (isValidMacAddress(macAddress)) {
      return macAddress;
    }
    return null;
  }
  
  private static String getWlanName()
  {
    try
    {
      String str = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { "wifi.interface", "wlan0" });
      return str;
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("AdMacAddress", "getWlanName", localThrowable);
    }
    return "wlan0";
  }
  
  private static boolean isValidMacAddress(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramString, "00:00:00:00:00:00")) && (!TextUtils.equals(paramString, "02:00:00:00:00:00"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.l
 * JD-Core Version:    0.7.0.1
 */