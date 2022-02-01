package com.tencent.avcore.util;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AVCoreLog
{
  private static final String TAG = "AVCoreLog";
  protected static IAVLog sProxy = null;
  protected static long sSeq = 0L;
  
  public static void d(String paramString1, String paramString2)
  {
    if (sProxy != null) {
      sProxy.d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (sProxy != null) {
      sProxy.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sProxy != null) {
      sProxy.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static long genDebugSeq()
  {
    if (sProxy != null) {
      return sProxy.genDebugSeq();
    }
    long l = sSeq;
    sSeq = 1L + l;
    return l;
  }
  
  public static String getVersion()
  {
    String str = null;
    if (sProxy != null) {
      str = sProxy.getVersion();
    }
    return str;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (sProxy != null) {
      sProxy.i(paramString1, paramString2);
    }
  }
  
  public static void init(IAVLog paramIAVLog)
  {
    sProxy = paramIAVLog;
  }
  
  public static boolean isColorLevel()
  {
    return (sProxy != null) && (sProxy.isColorLevel());
  }
  
  public static boolean isDebugVersion()
  {
    boolean bool = false;
    if (sProxy != null) {
      bool = sProxy.isDebugVersion();
    }
    return bool;
  }
  
  public static boolean isDevelopLevel()
  {
    return (sProxy != null) && (sProxy.isDevelopLevel());
  }
  
  public static boolean isGrayVersion()
  {
    boolean bool = false;
    if (sProxy != null) {
      bool = sProxy.isGrayVersion();
    }
    return bool;
  }
  
  public static boolean isInit()
  {
    return sProxy != null;
  }
  
  public static boolean isLogColorOrGary()
  {
    if (sProxy != null)
    {
      if (sProxy.isColorLevel()) {}
      while ((sProxy.isDebugVersion()) || (sProxy.isGrayVersion())) {
        return true;
      }
    }
    return false;
  }
  
  public static void print(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if ((paramBoolean) || (isDevelopLevel()))
    {
      paramString = "BundleValue[" + paramString + "]:\n";
      if (paramBundle != null) {}
      try
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        if (!localIterator.hasNext()) {
          break label342;
        }
        str = (String)localIterator.next();
        localObject3 = paramBundle.get(str);
        if ((localObject3 == null) || (!(localObject3 instanceof long[]))) {
          break label333;
        }
        localObject2 = (long[])localObject3;
        localObject1 = "" + localObject2.length;
        int i = 0;
        while ((i < localObject2.length) && (i < 5))
        {
          localObject1 = (String)localObject1 + "[" + localObject2[i] + "]";
          i += 1;
        }
      }
      catch (Exception paramString)
      {
        String str;
        Object localObject3;
        Object localObject2;
        Object localObject1;
        while (isDevelopLevel())
        {
          e("AVCoreLog", "log", paramString);
          return;
          localObject1 = null;
          continue;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "" + localObject3;
      }
      localObject1 = new StringBuilder().append(paramString).append("    [").append(str).append("]=[").append((String)localObject2).append("], [");
      if (localObject3 == null) {}
      for (paramString = null;; paramString = localObject3.getClass().getSimpleName())
      {
        paramString = paramString + "]\n";
        break;
      }
      for (;;)
      {
        e("AVCoreLog", paramString);
        return;
        paramString = paramString + "bundle为空";
      }
    }
    label333:
    label342:
    return;
  }
  
  public static <T1, T2> void print(String paramString, Map<T1, T2> paramMap, boolean paramBoolean)
  {
    if ((paramBoolean) || (isDevelopLevel()))
    {
      paramString = "MapValue[" + paramString + "]:\n";
      if (paramMap == null) {}
    }
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      Object localObject1 = paramString;
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        localObject1 = paramMap.get(localObject2);
        String str = "" + localObject1;
        localObject2 = new StringBuilder().append(paramString).append("    [").append(localObject2).append("]=[").append(str).append("], [");
        if (localObject1 == null) {}
        for (paramString = null;; paramString = localObject1.getClass().getSimpleName())
        {
          paramString = paramString + "]\n";
          break;
        }
        localObject1 = paramString + "bundle为空";
      }
      e("AVCoreLog", (String)localObject1);
      return;
    }
    catch (Exception paramString)
    {
      while (!isDevelopLevel()) {}
      e("AVCoreLog", "log", paramString);
    }
  }
  
  public static void printAllUserLog(String paramString1, String paramString2)
  {
    if (sProxy != null) {
      sProxy.printAllUserLog(paramString1, paramString2);
    }
  }
  
  @Deprecated
  public static void printColorLog(String paramString1, String paramString2)
  {
    if (sProxy != null) {
      sProxy.printColorLog(paramString1, paramString2);
    }
  }
  
  @Deprecated
  public static void printDebugLog(String paramString1, String paramString2)
  {
    if (sProxy != null) {
      sProxy.printDebugLog(paramString1, paramString2);
    }
  }
  
  public static void printErrorLog(String paramString1, String paramString2)
  {
    if (sProxy != null) {
      sProxy.printErrorLog(paramString1, paramString2);
    }
  }
  
  @Deprecated
  public static void printInfoLog(String paramString1, String paramString2)
  {
    if (sProxy != null) {
      sProxy.printInfoLog(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.util.AVCoreLog
 * JD-Core Version:    0.7.0.1
 */