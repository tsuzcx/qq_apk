package com.tencent.beacon.core.b;

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
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.i;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class d
{
  private static d a;
  
  public static d a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new d();
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static String a()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Android ");
    ((StringBuffer)localObject).append(i());
    ((StringBuffer)localObject).append(",level ");
    ((StringBuffer)localObject).append(c());
    localObject = ((StringBuffer)localObject).toString();
    b.b("[core] os version: %s", new Object[] { localObject });
    return localObject;
  }
  
  private static StringBuilder a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    return localStringBuilder;
  }
  
  public static String b()
  {
    Object localObject = "";
    try
    {
      String str = Build.MODEL;
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        b.d("[core] getDeviceName error", new Object[0]);
        b.a(localThrowable);
      }
    }
    b.b("[core] model name: %s", new Object[] { localObject });
    return localObject;
  }
  
  public static String b(Context paramContext)
  {
    String str = "";
    if (paramContext == null)
    {
      b.d("[core] getImei but context is null!", new Object[0]);
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
        b.d("[core] getImei error!", new Object[0]);
        continue;
        paramContext = "";
        continue;
      }
      b.a("[core] IMEI:" + paramContext, new Object[0]);
      return paramContext;
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
    }
  }
  
  public static String c()
  {
    Object localObject = "";
    try
    {
      String str = Build.VERSION.SDK;
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        b.d("[core] getApiLevel error", new Object[0]);
        b.a(localThrowable);
      }
    }
    b.b("[core] apiLevel: %s", new Object[] { localObject });
    return localObject;
  }
  
  public static String c(Context paramContext)
  {
    String str = "";
    if (paramContext == null)
    {
      b.d("[core] getImsi but context == null!", new Object[0]);
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
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
        if (paramContext != null) {
          continue;
        }
        paramContext = "";
      }
      catch (Throwable paramContext)
      {
        paramContext = (Context)localObject;
        b.d("[core] getImsi error!", new Object[0]);
        continue;
        paramContext = "";
        continue;
      }
      b.b("[core] IMSI:" + paramContext, new Object[0]);
      return paramContext;
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
    }
  }
  
  public static String d()
  {
    String str = i.b("/sys/class/net/eth0/address");
    if ((str.trim().equals("")) || (str.length() < 17)) {}
    for (str = "";; str = str.toLowerCase().substring(0, 17))
    {
      b.b("[core] Ethernet Mac Address:" + str, new Object[0]);
      return str;
    }
  }
  
  public static String d(Context paramContext)
  {
    String str2 = "";
    if (paramContext == null)
    {
      b.d("[core] getAndroidId but context is null!", new Object[0]);
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
      b.a("[core] Android ID:" + paramContext, new Object[0]);
      return paramContext;
      label74:
      b.d("[core] getAndroidId error!", new Object[0]);
      b.a(localThrowable1);
    }
  }
  
  public static String e()
  {
    Object localObject = "";
    try
    {
      String str = Build.BRAND;
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        b.d("getBrand error!", new Object[0]);
        b.a(localThrowable);
      }
    }
    b.b("[core] Brand:" + (String)localObject, new Object[0]);
    return localObject;
  }
  
  public static String e(Context paramContext)
  {
    Object localObject2 = "";
    if (paramContext == null)
    {
      b.d("[core] getMacAddress but context is null!", new Object[0]);
      return "";
    }
    localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (Integer.valueOf(Build.VERSION.SDK).intValue() >= 23) {
          continue;
        }
        localObject1 = localObject2;
        paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        if (paramContext != null) {
          continue;
        }
        paramContext = "";
      }
      catch (Throwable localThrowable)
      {
        int i;
        NetworkInterface localNetworkInterface;
        byte[] arrayOfByte;
        paramContext = (Context)localObject1;
        b.a(localThrowable);
        continue;
      }
      b.b("[core] Mac Address:" + paramContext, new Object[0]);
      return paramContext;
      localObject1 = paramContext;
      paramContext = paramContext.toLowerCase();
      continue;
      i = 0;
      localObject1 = localObject2;
      paramContext = (Context)localObject1;
      if (i < 2)
      {
        paramContext = i.b(new String[] { "/sys/class/net/wlan0/address", "/sys/devices/virtual/net/wlan0/address" }[i]).toString().trim();
        if (paramContext != null)
        {
          localObject1 = paramContext;
          if (paramContext.length() > 0)
          {
            localObject1 = paramContext;
            paramContext = paramContext.toLowerCase();
          }
        }
      }
      else
      {
        localObject1 = paramContext;
        if (!"".equals(paramContext)) {
          continue;
        }
        localObject1 = paramContext;
        localObject2 = NetworkInterface.getNetworkInterfaces();
        localObject1 = paramContext;
        if (!((Enumeration)localObject2).hasMoreElements()) {
          continue;
        }
        localObject1 = paramContext;
        localNetworkInterface = (NetworkInterface)((Enumeration)localObject2).nextElement();
        localObject1 = paramContext;
        arrayOfByte = localNetworkInterface.getHardwareAddress();
        localObject1 = paramContext;
        if ((!"wlan0".equals(localNetworkInterface.getName())) || (arrayOfByte == null)) {
          continue;
        }
        localObject1 = paramContext;
        if (arrayOfByte.length == 0) {
          continue;
        }
        localObject1 = paramContext;
        paramContext = a(arrayOfByte).toString();
        continue;
      }
      i += 1;
      localObject1 = paramContext;
    }
  }
  
  public static String f()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = new StatFs(Environment.getDataDirectory().getPath());
      long l1 = ((StatFs)localObject2).getBlockSize();
      long l2 = ((StatFs)localObject2).getBlockCount();
      localObject2 = l2 * l1 / 1024L / 1024L;
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        b.d("getDisplayMetrics error!", new Object[0]);
        b.a(localThrowable);
      }
    }
    b.b("[core] Rom Size:" + localObject1, new Object[0]);
    return localObject1;
  }
  
  public static String f(Context paramContext)
  {
    if (paramContext == null)
    {
      b.d("[core] getMacAddress but context is null!", new Object[0]);
      return "";
    }
    StringBuilder localStringBuilder;
    try
    {
      paramContext = NetworkInterface.getNetworkInterfaces();
      localStringBuilder = new StringBuilder();
      while (paramContext.hasMoreElements())
      {
        NetworkInterface localNetworkInterface = (NetworkInterface)paramContext.nextElement();
        byte[] arrayOfByte = localNetworkInterface.getHardwareAddress();
        if ((arrayOfByte != null) && (arrayOfByte.length != 0))
        {
          localStringBuilder.append(localNetworkInterface.getName()).append(":").append(a(arrayOfByte)).append(",");
          continue;
          b.b("[core] Mac Address:" + paramContext, new Object[0]);
        }
      }
    }
    catch (Throwable paramContext)
    {
      b.a(paramContext);
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      paramContext = localStringBuilder.toString();
    }
  }
  
  public static String g(Context paramContext)
  {
    if (paramContext == null)
    {
      b.d("[core] getMacAddress but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getBSSID();
      b.b("[core] Wifi BSSID:" + paramContext, new Object[0]);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        b.a(paramContext);
        b.d("getMacAddress error!", new Object[0]);
        paramContext = "";
      }
    }
  }
  
  public static boolean g()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static String h()
  {
    Object localObject = new StringBuilder();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/type")));
      String str = localBufferedReader.readLine();
      localBufferedReader.close();
      ((StringBuilder)localObject).append(str);
      label48:
      ((StringBuilder)localObject).append(",");
      try
      {
        localBufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/name")));
        str = localBufferedReader.readLine();
        localBufferedReader.close();
        ((StringBuilder)localObject).append(str);
        label96:
        ((StringBuilder)localObject).append(",");
        try
        {
          localBufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/cid")));
          str = localBufferedReader.readLine();
          localBufferedReader.close();
          ((StringBuilder)localObject).append(str);
          label144:
          localObject = ((StringBuilder)localObject).toString();
          b.b("[core]Nand Info:" + (String)localObject, new Object[0]);
          return localObject;
        }
        catch (Exception localException1)
        {
          break label144;
        }
      }
      catch (Exception localException2)
      {
        break label96;
      }
    }
    catch (Exception localException3)
    {
      break label48;
    }
  }
  
  public static String h(Context paramContext)
  {
    if (paramContext == null)
    {
      b.d("[core] getWifiSSID but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext.getBSSID() != null)
      {
        paramContext = paramContext.getSSID();
        b.b("[core] Wifi SSID:" + paramContext, new Object[0]);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        b.a(paramContext);
        b.d("getWifiSSID error!", new Object[0]);
        paramContext = "";
      }
    }
  }
  
  private static String i()
  {
    Object localObject = "";
    try
    {
      String str = Build.VERSION.RELEASE;
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        b.d("[core] getVersion error", new Object[0]);
        b.a(localThrowable);
      }
    }
    b.b("[core] version: %s", new Object[] { localObject });
    return localObject;
  }
  
  public static String i(Context paramContext)
  {
    String str = "unknown";
    if (a != null) {
      str = j(paramContext);
    }
    b.b("[core] NetWork Types:" + str, new Object[0]);
    return str;
  }
  
  public static String j(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo == null) {
          return "unknown";
        }
        if (localNetworkInfo.getType() != 1) {
          continue;
        }
        paramContext = "wifi";
      }
      catch (Exception paramContext)
      {
        NetworkInfo localNetworkInfo;
        b.a(paramContext);
        paramContext = "unknown";
        continue;
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
        continue;
      }
      b.b("[core] NetWork Type:" + paramContext, new Object[0]);
      return paramContext;
      if (localNetworkInfo.getType() != 0) {
        continue;
      }
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        continue;
      }
      switch (paramContext.getNetworkType())
      {
      case 15: 
        paramContext = "HSPA+";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.b.d
 * JD-Core Version:    0.7.0.1
 */