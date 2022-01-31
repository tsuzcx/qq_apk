package com.tencent.beacon.a.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public final class e
{
  private static e a;
  
  public static e a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new e();
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Android ");
    localStringBuffer.append(h());
    localStringBuffer.append(",level ");
    localStringBuffer.append(c());
    return localStringBuffer.toString();
  }
  
  public static String b()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.d("[core] getDeviceName error", new Object[0]);
      com.tencent.beacon.a.g.a.a(localThrowable);
    }
    return "";
  }
  
  public static String b(Context paramContext)
  {
    String str = "";
    if (paramContext == null)
    {
      com.tencent.beacon.a.g.a.d("[core] getImei but context is null!", new Object[0]);
      return "";
    }
    localObject = str;
    for (;;)
    {
      try
      {
        if (!a.f(paramContext)) {
          continue;
        }
        localObject = str;
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        if (paramContext != null) {
          continue;
        }
        paramContext = "";
      }
      catch (Throwable paramContext)
      {
        paramContext = (Context)localObject;
        com.tencent.beacon.a.g.a.d("[core] getImei error!", new Object[0]);
        continue;
        paramContext = "";
        continue;
      }
      com.tencent.beacon.a.g.a.a("[core] IMEI:" + paramContext, new Object[0]);
      return paramContext;
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
    }
  }
  
  public static String c()
  {
    try
    {
      String str = Build.VERSION.SDK;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.d("[core] getApiLevel error", new Object[0]);
      com.tencent.beacon.a.g.a.a(localThrowable);
    }
    return "";
  }
  
  public static String c(Context paramContext)
  {
    String str = "";
    if (paramContext == null)
    {
      com.tencent.beacon.a.g.a.d("[core] getImsi but context == null!", new Object[0]);
      return "";
    }
    Object localObject = str;
    try
    {
      if (a.f(paramContext))
      {
        localObject = str;
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
        if (paramContext == null)
        {
          paramContext = "";
        }
        else
        {
          localObject = paramContext;
          paramContext = paramContext.toLowerCase();
        }
      }
    }
    catch (Throwable paramContext)
    {
      paramContext = (Context)localObject;
      com.tencent.beacon.a.g.a.d("[core] getImsi error!", new Object[0]);
    }
    paramContext = "";
    return paramContext;
  }
  
  public static String d()
  {
    String str = com.tencent.beacon.a.a.f("/sys/class/net/eth0/address");
    if ((str.trim().equals("")) || (str.length() < 17)) {
      return "";
    }
    return str.toLowerCase().substring(0, 17);
  }
  
  public static String d(Context paramContext)
  {
    String str2 = "";
    if (paramContext == null)
    {
      com.tencent.beacon.a.g.a.d("[core] getAndroidId but context is null!", new Object[0]);
      return "";
    }
    for (;;)
    {
      try
      {
        paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
        if (paramContext != null) {
          continue;
        }
        paramContext = "";
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          String str1 = paramContext.toLowerCase();
          paramContext = str1;
        }
        catch (Throwable localThrowable2)
        {
          break label74;
        }
        localThrowable1 = localThrowable1;
        paramContext = str2;
      }
      com.tencent.beacon.a.g.a.a("[core] Android ID:" + paramContext, new Object[0]);
      return paramContext;
      label74:
      com.tencent.beacon.a.g.a.d("[core] getAndroidId error!", new Object[0]);
      com.tencent.beacon.a.g.a.a(localThrowable1);
    }
  }
  
  public static String e()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.d("getBrand error!", new Object[0]);
      com.tencent.beacon.a.g.a.a(localThrowable);
    }
    return "";
  }
  
  public static String e(Context paramContext)
  {
    String str = "";
    Object localObject;
    if (paramContext == null)
    {
      com.tencent.beacon.a.g.a.d("[core] getMacAddress but context is null!", new Object[0]);
      localObject = "";
    }
    do
    {
      return localObject;
      localObject = str;
      try
      {
        if (Integer.valueOf(Build.VERSION.SDK).intValue() < 23)
        {
          localObject = str;
          paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
          if (paramContext == null) {
            return "";
          }
          localObject = paramContext;
          return paramContext.toLowerCase();
        }
        i = 0;
        paramContext = "";
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          int i;
          localObject = com.tencent.beacon.a.a.f(new String[] { "/sys/class/net/wlan0/address", "/sys/devices/virtual/net/wlan0/address" }[i]).toString().trim();
          paramContext = (Context)localObject;
          if (paramContext != null)
          {
            localObject = paramContext;
            if (paramContext.length() > 0)
            {
              localObject = paramContext;
              paramContext = paramContext.toLowerCase();
              return paramContext;
            }
          }
          i += 1;
        }
        catch (Throwable localThrowable2)
        {
          break label141;
        }
        localThrowable1 = localThrowable1;
        paramContext = (Context)localObject;
      }
      localObject = paramContext;
    } while (i >= 2);
    label141:
    com.tencent.beacon.a.g.a.a(localThrowable1);
    return paramContext;
  }
  
  public static String f()
  {
    try
    {
      Object localObject = new StatFs(Environment.getDataDirectory().getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getBlockCount();
      localObject = l2 * l1 / 1024L / 1024L;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.d("getDisplayMetrics error!", new Object[0]);
      com.tencent.beacon.a.g.a.a(localThrowable);
    }
    return null;
  }
  
  public static String f(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.a.g.a.d("[core] getMacAddress but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getBSSID();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        com.tencent.beacon.a.g.a.a(paramContext);
        com.tencent.beacon.a.g.a.d("getMacAddress error!", new Object[0]);
        paramContext = "";
      }
    }
  }
  
  public static String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/type")));
      String str = localBufferedReader.readLine();
      localBufferedReader.close();
      localStringBuilder.append(str);
      label47:
      localStringBuilder.append(",");
      try
      {
        localBufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/name")));
        str = localBufferedReader.readLine();
        localBufferedReader.close();
        localStringBuilder.append(str);
        label93:
        localStringBuilder.append(",");
        try
        {
          localBufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/cid")));
          str = localBufferedReader.readLine();
          localBufferedReader.close();
          localStringBuilder.append(str);
          label139:
          return localStringBuilder.toString();
        }
        catch (Exception localException1)
        {
          break label139;
        }
      }
      catch (Exception localException2)
      {
        break label93;
      }
    }
    catch (Exception localException3)
    {
      break label47;
    }
  }
  
  public static String g(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.a.g.a.d("[core] getWifiSSID but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext.getBSSID() != null)
      {
        paramContext = paramContext.getSSID();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        com.tencent.beacon.a.g.a.a(paramContext);
        com.tencent.beacon.a.g.a.d("getWifiSSID error!", new Object[0]);
        paramContext = "";
      }
    }
  }
  
  private static String h()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.d("[core] getVersion error", new Object[0]);
      com.tencent.beacon.a.g.a.a(localThrowable);
    }
    return "";
  }
  
  public static String h(Context paramContext)
  {
    String str = "unknown";
    if (a != null) {
      str = i(paramContext);
    }
    return str;
  }
  
  public static String i(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return "unknown";
      }
      if (localNetworkInfo.getType() == 1)
      {
        paramContext = "wifi";
      }
      else if (localNetworkInfo.getType() == 0)
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null) {
          switch (paramContext.getNetworkType())
          {
          case 15: 
            paramContext = "HSPA+";
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      com.tencent.beacon.a.g.a.a(paramContext);
      paramContext = "unknown";
    }
    for (;;)
    {
      return paramContext;
      paramContext = "unknown";
      continue;
      paramContext = "GPRS";
      continue;
      paramContext = "EDGE";
      continue;
      paramContext = "UMTS";
      continue;
      paramContext = "HSDPA";
      continue;
      paramContext = "HSUPA";
      continue;
      paramContext = "HSPA";
      continue;
      paramContext = "CDMA";
      continue;
      paramContext = "EVDO_0";
      continue;
      paramContext = "EVDO_A";
      continue;
      paramContext = "1xRTT";
      continue;
      paramContext = "iDen";
      continue;
      paramContext = "EVDO_B";
      continue;
      paramContext = "LTE";
      continue;
      paramContext = "eHRPD";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.c.e
 * JD-Core Version:    0.7.0.1
 */