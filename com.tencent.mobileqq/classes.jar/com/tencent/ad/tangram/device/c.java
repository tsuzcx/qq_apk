package com.tencent.ad.tangram.device;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class c
{
  private static final String TAG = "AdMacAddress";
  private static String macAddress;
  
  public static String get(Context paramContext)
  {
    if (!TextUtils.isEmpty(macAddress)) {
      return macAddress;
    }
    if (Build.VERSION.SDK_INT < 23) {
      paramContext = getByWifiInfo(paramContext);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContext)) {
        macAddress = paramContext;
      }
      return macAddress;
      if ((Build.VERSION.SDK_INT >= 23) && (Build.VERSION.SDK_INT <= 28)) {
        paramContext = getByInterface();
      } else {
        paramContext = null;
      }
    }
  }
  
  public static String getByInterface()
  {
    try
    {
      Object localObject1 = NetworkInterface.getNetworkInterfaces();
      while (((Enumeration)localObject1).hasMoreElements()) {
        if (localObject1 != null)
        {
          Object localObject2 = (NetworkInterface)((Enumeration)localObject1).nextElement();
          if ((localObject2 != null) && (((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0")))
          {
            localObject1 = ((NetworkInterface)localObject2).getHardwareAddress();
            if (localObject1 == null) {
              return null;
            }
            localObject2 = new StringBuilder();
            int j = localObject1.length;
            int i = 0;
            while (i < j)
            {
              ((StringBuilder)localObject2).append(String.format("%02X:", new Object[] { Byte.valueOf(localObject1[i]) }));
              i += 1;
            }
            if (((StringBuilder)localObject2).length() > 0) {
              ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
            }
            localObject1 = ((StringBuilder)localObject2).toString();
            return localObject1;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("AdMacAddress", "getByInterface", localThrowable);
    }
    return null;
  }
  
  public static String getByWifiInfo(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      Object localObject = null;
      do
      {
        for (;;)
        {
          return localObject;
          paramContext = paramContext.getApplicationContext();
          if (paramContext == null) {
            break;
          }
          paramContext = paramContext.getSystemService("wifi");
          if (!(paramContext instanceof WifiManager)) {
            break;
          }
          paramContext = (WifiManager)WifiManager.class.cast(paramContext);
          if (paramContext == null) {
            break;
          }
          try
          {
            paramContext = paramContext.getConnectionInfo();
            if (paramContext == null) {
              break;
            }
            paramContext = paramContext.getMacAddress();
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
        localObject = paramContext;
      } while (!TextUtils.isEmpty(paramContext));
    }
  }
  
  public static String getMacAddressCache(Context paramContext)
  {
    return macAddress;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.device.c
 * JD-Core Version:    0.7.0.1
 */