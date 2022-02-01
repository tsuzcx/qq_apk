package com.tencent.falco.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class DeviceInfoUtil
{
  static String deviceId = "";
  static String imei = "";
  
  /* Error */
  public static String getDeviceID(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 13	com/tencent/falco/utils/DeviceInfoUtil:deviceId	Ljava/lang/String;
    //   3: invokestatic 29	com/tencent/falco/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   6: ifeq +143 -> 149
    //   9: aload_0
    //   10: ldc 31
    //   12: invokevirtual 37	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast 39	android/telephony/TelephonyManager
    //   18: astore 4
    //   20: ldc 11
    //   22: astore_1
    //   23: ldc 11
    //   25: astore_2
    //   26: new 41	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   33: ldc 11
    //   35: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload 4
    //   40: invokevirtual 50	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   43: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore_3
    //   50: aload_3
    //   51: astore_1
    //   52: new 41	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   59: ldc 11
    //   61: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload 4
    //   66: invokevirtual 56	android/telephony/TelephonyManager:getSimSerialNumber	()Ljava/lang/String;
    //   69: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore 4
    //   77: aload 4
    //   79: astore_2
    //   80: aload_3
    //   81: astore_1
    //   82: new 41	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   89: ldc 11
    //   91: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_0
    //   95: invokevirtual 60	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   98: ldc 62
    //   100: invokestatic 68	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   103: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore_0
    //   110: new 70	java/util/UUID
    //   113: dup
    //   114: aload_0
    //   115: invokevirtual 76	java/lang/String:hashCode	()I
    //   118: i2l
    //   119: aload_1
    //   120: invokevirtual 76	java/lang/String:hashCode	()I
    //   123: i2l
    //   124: bipush 32
    //   126: lshl
    //   127: aload_2
    //   128: invokevirtual 76	java/lang/String:hashCode	()I
    //   131: i2l
    //   132: lor
    //   133: invokespecial 79	java/util/UUID:<init>	(JJ)V
    //   136: invokevirtual 80	java/util/UUID:toString	()Ljava/lang/String;
    //   139: ldc 82
    //   141: ldc 11
    //   143: invokevirtual 86	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   146: putstatic 13	com/tencent/falco/utils/DeviceInfoUtil:deviceId	Ljava/lang/String;
    //   149: getstatic 13	com/tencent/falco/utils/DeviceInfoUtil:deviceId	Ljava/lang/String;
    //   152: areturn
    //   153: astore_3
    //   154: aload_3
    //   155: invokevirtual 89	java/lang/Exception:printStackTrace	()V
    //   158: goto -76 -> 82
    //   161: astore_0
    //   162: aload_1
    //   163: astore_0
    //   164: goto -54 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramContext	Context
    //   22	141	1	localObject1	Object
    //   25	103	2	localObject2	Object
    //   49	32	3	str	String
    //   153	2	3	localException	Exception
    //   18	60	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   26	50	153	java/lang/Exception
    //   52	77	153	java/lang/Exception
    //   82	110	161	java/lang/Exception
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
    long l1 = arrayOfLong[1];
    long l2 = arrayOfLong[2];
    return arrayOfLong[3] + (l1 + l2);
  }
  
  public static String getIMEI(Context paramContext)
  {
    if (TextUtils.isEmpty(imei)) {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    }
    try
    {
      imei = paramContext.getDeviceId();
      if (TextUtils.isEmpty(imei)) {
        imei = "";
      }
      return imei;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static long[] getMemInfo()
  {
    int i = 0;
    arrayOfLong1 = new long[4];
    try
    {
      Method localMethod = Class.forName("android.os.Process").getMethod("readProcLines", new Class[] { String.class, [Ljava.lang.String.class, [J.class });
      String[] arrayOfString = new String[4];
      arrayOfString[0] = "MemTotal:";
      arrayOfString[1] = "MemFree:";
      arrayOfString[2] = "Buffers:";
      arrayOfString[3] = "Cached:";
      long[] arrayOfLong2 = new long[arrayOfString.length];
      arrayOfLong2[0] = 30L;
      arrayOfLong2[1] = -30L;
      String str = new String("/proc/meminfo");
      if (localMethod != null)
      {
        localMethod.invoke(null, new Object[] { str, arrayOfString, arrayOfLong2 });
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
      Object localObject = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
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
        for (;;)
        {
          String str;
          paramContext.printStackTrace();
        }
      }
      paramContext = new ArrayList();
      localObject = localHashSet.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramContext.add((String)((Iterator)localObject).next());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        str = "";
      }
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.DeviceInfoUtil
 * JD-Core Version:    0.7.0.1
 */