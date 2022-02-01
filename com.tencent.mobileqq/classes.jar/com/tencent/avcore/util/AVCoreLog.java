package com.tencent.avcore.util;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AVCoreLog
{
  private static final String TAG = "AVCoreLog";
  protected static IAVLog sProxy;
  protected static long sSeq;
  
  public static void d(String paramString1, String paramString2)
  {
    IAVLog localIAVLog = sProxy;
    if (localIAVLog != null) {
      localIAVLog.d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    IAVLog localIAVLog = sProxy;
    if (localIAVLog != null) {
      localIAVLog.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    IAVLog localIAVLog = sProxy;
    if (localIAVLog != null) {
      localIAVLog.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static long genDebugSeq()
  {
    IAVLog localIAVLog = sProxy;
    if (localIAVLog != null) {
      return localIAVLog.genDebugSeq();
    }
    long l = sSeq;
    sSeq = 1L + l;
    return l;
  }
  
  public static String getVersion()
  {
    IAVLog localIAVLog = sProxy;
    if (localIAVLog != null) {
      return localIAVLog.getVersion();
    }
    return null;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    IAVLog localIAVLog = sProxy;
    if (localIAVLog != null) {
      localIAVLog.i(paramString1, paramString2);
    }
  }
  
  public static void init(IAVLog paramIAVLog)
  {
    sProxy = paramIAVLog;
  }
  
  public static boolean isColorLevel()
  {
    IAVLog localIAVLog = sProxy;
    return (localIAVLog != null) && (localIAVLog.isColorLevel());
  }
  
  public static boolean isDebugVersion()
  {
    IAVLog localIAVLog = sProxy;
    if (localIAVLog != null) {
      return localIAVLog.isDebugVersion();
    }
    return false;
  }
  
  public static boolean isDevelopLevel()
  {
    IAVLog localIAVLog = sProxy;
    return (localIAVLog != null) && (localIAVLog.isDevelopLevel());
  }
  
  public static boolean isGrayVersion()
  {
    IAVLog localIAVLog = sProxy;
    if (localIAVLog != null) {
      return localIAVLog.isGrayVersion();
    }
    return false;
  }
  
  public static boolean isInit()
  {
    return sProxy != null;
  }
  
  public static boolean isLogColorOrGary()
  {
    IAVLog localIAVLog = sProxy;
    boolean bool = true;
    if (localIAVLog != null)
    {
      if (localIAVLog.isColorLevel()) {
        return true;
      }
      if (sProxy.isDebugVersion()) {
        return bool;
      }
      if (sProxy.isGrayVersion()) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public static void print(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramBoolean) || (isDevelopLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("BundleValue[");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("]:\n");
      paramString = ((StringBuilder)localObject1).toString();
      if (paramBundle == null) {}
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        localObject1 = paramString;
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject4 = paramBundle.get(str);
          Object localObject3 = null;
          if ((localObject4 == null) || (!(localObject4 instanceof long[]))) {
            break label426;
          }
          long[] arrayOfLong = (long[])localObject4;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(arrayOfLong.length);
          localObject1 = ((StringBuilder)localObject1).toString();
          int i = 0;
          localObject2 = localObject1;
          if (i < arrayOfLong.length)
          {
            localObject2 = localObject1;
            if (i < 5)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append("[");
              ((StringBuilder)localObject2).append(arrayOfLong[i]);
              ((StringBuilder)localObject2).append("]");
              localObject1 = ((StringBuilder)localObject2).toString();
              i += 1;
              continue;
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(localObject4);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append("    [");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("]=[");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("], [");
          if (localObject4 == null) {
            paramString = localObject3;
          } else {
            paramString = localObject4.getClass().getSimpleName();
          }
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append("]\n");
          paramString = ((StringBuilder)localObject2).toString();
          continue;
          paramBundle = new StringBuilder();
          paramBundle.append(paramString);
          paramBundle.append("bundle为空");
          localObject1 = paramBundle.toString();
        }
        e("AVCoreLog", (String)localObject1);
        return;
      }
      catch (Exception paramString)
      {
        if (isDevelopLevel()) {
          e("AVCoreLog", "log", paramString);
        }
      }
      return;
      label426:
      Object localObject2 = null;
    }
  }
  
  public static <T1, T2> void print(String paramString, Map<T1, T2> paramMap, boolean paramBoolean)
  {
    if ((paramBoolean) || (isDevelopLevel()))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MapValue[");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("]:\n");
      paramString = ((StringBuilder)localObject1).toString();
      if (paramMap != null) {}
      try
      {
        Iterator localIterator = paramMap.keySet().iterator();
        for (;;)
        {
          localObject1 = paramString;
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject2 = localIterator.next();
          Object localObject3 = paramMap.get(localObject2);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(localObject3);
          String str = ((StringBuilder)localObject1).toString();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("    [");
          ((StringBuilder)localObject1).append(localObject2);
          ((StringBuilder)localObject1).append("]=[");
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append("], [");
          if (localObject3 == null) {
            paramString = null;
          } else {
            paramString = localObject3.getClass().getSimpleName();
          }
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("]\n");
          paramString = ((StringBuilder)localObject1).toString();
        }
        paramMap = new StringBuilder();
        paramMap.append(paramString);
        paramMap.append("bundle为空");
        localObject1 = paramMap.toString();
        e("AVCoreLog", (String)localObject1);
        return;
      }
      catch (Exception paramString)
      {
        if (isDevelopLevel()) {
          e("AVCoreLog", "log", paramString);
        }
      }
    }
  }
  
  public static void printAllUserLog(String paramString1, String paramString2)
  {
    IAVLog localIAVLog = sProxy;
    if (localIAVLog != null) {
      localIAVLog.printAllUserLog(paramString1, paramString2);
    }
  }
  
  @Deprecated
  public static void printColorLog(String paramString1, String paramString2)
  {
    IAVLog localIAVLog = sProxy;
    if (localIAVLog != null) {
      localIAVLog.printColorLog(paramString1, paramString2);
    }
  }
  
  @Deprecated
  public static void printDebugLog(String paramString1, String paramString2)
  {
    IAVLog localIAVLog = sProxy;
    if (localIAVLog != null) {
      localIAVLog.printDebugLog(paramString1, paramString2);
    }
  }
  
  public static void printErrorLog(String paramString1, String paramString2)
  {
    IAVLog localIAVLog = sProxy;
    if (localIAVLog != null) {
      localIAVLog.printErrorLog(paramString1, paramString2);
    }
  }
  
  @Deprecated
  public static void printInfoLog(String paramString1, String paramString2)
  {
    IAVLog localIAVLog = sProxy;
    if (localIAVLog != null) {
      localIAVLog.printInfoLog(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.util.AVCoreLog
 * JD-Core Version:    0.7.0.1
 */