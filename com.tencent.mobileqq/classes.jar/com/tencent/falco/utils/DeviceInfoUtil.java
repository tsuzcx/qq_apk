package com.tencent.falco.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class DeviceInfoUtil
{
  static String deviceId = "";
  static String imei = "";
  
  public static long getAvailableInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    return localStatFs.getAvailableBlocksLong() * localStatFs.getBlockSizeLong();
  }
  
  public static String getDeviceID(Context paramContext)
  {
    Object localObject1;
    StringBuilder localStringBuilder;
    String str;
    if (StringUtil.isEmpty(deviceId))
    {
      Object localObject2 = (TelephonyManager)paramContext.getSystemService("phone");
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(((TelephonyManager)localObject2).getDeviceId());
        localObject1 = ((StringBuilder)localObject1).toString();
        try
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(((TelephonyManager)localObject2).getSimSerialNumber());
          localObject2 = localStringBuilder.toString();
        }
        catch (Exception localException1) {}
        localException2.printStackTrace();
      }
      catch (Exception localException2)
      {
        localObject1 = "";
      }
      str = "";
    }
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
      paramContext = localStringBuilder.toString();
    }
    catch (Exception paramContext)
    {
      label154:
      long l1;
      long l2;
      break label154;
    }
    paramContext = (Context)localObject1;
    l1 = paramContext.hashCode();
    l2 = ((String)localObject1).hashCode();
    deviceId = new UUID(l1, str.hashCode() | l2 << 32).toString().replaceAll("-", "");
    return deviceId;
  }
  
  public static String getDeviceModel()
  {
    return Build.MODEL;
  }
  
  public static String getDeviceName()
  {
    return Build.BRAND;
  }
  
  public static long getFreeMem()
  {
    long[] arrayOfLong = getMemInfo();
    return arrayOfLong[1] + arrayOfLong[2] + arrayOfLong[3];
  }
  
  public static String getIMEI(Context paramContext)
  {
    if (TextUtils.isEmpty(imei))
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      try
      {
        imei = paramContext.getDeviceId();
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      if (TextUtils.isEmpty(imei)) {
        imei = "";
      }
    }
    return imei;
  }
  
  public static int getMaxCpuFreq()
  {
    String str = "";
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(new String(arrayOfByte));
        str = localStringBuilder.toString();
      }
      localInputStream.close();
      int i = Integer.parseInt(str.trim());
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public static long[] getMemInfo()
  {
    arrayOfLong1 = new long[4];
    try
    {
      Object localObject = Class.forName("android.os.Process");
      int i = 0;
      localObject = ((Class)localObject).getMethod("readProcLines", new Class[] { String.class, [Ljava.lang.String.class, [J.class });
      String[] arrayOfString = new String[4];
      arrayOfString[0] = "MemTotal:";
      arrayOfString[1] = "MemFree:";
      arrayOfString[2] = "Buffers:";
      arrayOfString[3] = "Cached:";
      long[] arrayOfLong2 = new long[arrayOfString.length];
      arrayOfLong2[0] = 30L;
      arrayOfLong2[1] = -30L;
      String str = new String("/proc/meminfo");
      if (localObject != null)
      {
        ((Method)localObject).invoke(null, new Object[] { str, arrayOfString, arrayOfLong2 });
        while (i < arrayOfLong2.length)
        {
          arrayOfLong2[i] /= 1024L;
          i += 1;
        }
      }
      return arrayOfLong1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static long getTotalMem()
  {
    return getMemInfo()[0];
  }
  
  public List<String> getIMEIList(Context paramContext)
  {
    HashSet localHashSet = new HashSet();
    try
    {
      String str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localHashSet.add(((String)localObject).toUpperCase());
    }
    try
    {
      localObject = DeviceInfoUtil.CTelephoneInfo.getInstance(paramContext);
      ((DeviceInfoUtil.CTelephoneInfo)localObject).setCTelephoneInfo();
      paramContext = ((DeviceInfoUtil.CTelephoneInfo)localObject).getImeiSIM1();
      localObject = ((DeviceInfoUtil.CTelephoneInfo)localObject).getImeiSIM2();
      if (!TextUtils.isEmpty(paramContext)) {
        localHashSet.add(paramContext.toUpperCase());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashSet.add(((String)localObject).toUpperCase());
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    paramContext = new ArrayList();
    Object localObject = localHashSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramContext.add((String)((Iterator)localObject).next());
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.utils.DeviceInfoUtil
 * JD-Core Version:    0.7.0.1
 */