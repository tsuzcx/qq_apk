package com.tencent.ark;

import java.util.HashMap;

public class Logger
{
  static ArkEnvironmentManager.ILog logCallback;
  private static final HashMap<String, Long> logTimestamp = new HashMap();
  
  static String combine(Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null) {
        localObject = localObject.toString();
      } else {
        localObject = "(null)";
      }
      localStringBuilder.append((String)localObject);
      i += 1;
    }
    localStringBuilder.append(getQueueKey());
    return localStringBuilder.toString();
  }
  
  static void doLogD(String paramString1, String paramString2)
  {
    ArkEnvironmentManager.ILog localILog = logCallback;
    if (localILog != null) {
      localILog.d(paramString1, paramString2);
    }
  }
  
  static String getQueueKey()
  {
    try
    {
      str = ArkDispatchQueue.getCurrentQueueKey();
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      String str;
      label7:
      StringBuilder localStringBuilder;
      break label7;
    }
    str = "(none)";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(" QueueKey:");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public static void logD(String paramString1, String paramString2)
  {
    ArkEnvironmentManager.ILog localILog = logCallback;
    if (localILog == null) {
      return;
    }
    localILog.d(paramString1, paramString2);
  }
  
  public static void logD(String paramString, Object... paramVarArgs)
  {
    ArkEnvironmentManager.ILog localILog = logCallback;
    if (localILog == null) {
      return;
    }
    localILog.d(paramString, combine(paramVarArgs));
  }
  
  public static void logE(String paramString1, String paramString2)
  {
    ArkEnvironmentManager.ILog localILog = logCallback;
    if (localILog == null) {
      return;
    }
    localILog.e(paramString1, paramString2);
  }
  
  public static void logE(String paramString, Object... paramVarArgs)
  {
    ArkEnvironmentManager.ILog localILog = logCallback;
    if (localILog == null) {
      return;
    }
    localILog.e(paramString, combine(paramVarArgs));
  }
  
  public static void logI(String paramString1, String paramString2)
  {
    ArkEnvironmentManager.ILog localILog = logCallback;
    if (localILog == null) {
      return;
    }
    localILog.i(paramString1, paramString2);
  }
  
  public static void logI(String paramString, Object... paramVarArgs)
  {
    ArkEnvironmentManager.ILog localILog = logCallback;
    if (localILog == null) {
      return;
    }
    localILog.i(paramString, combine(paramVarArgs));
  }
  
  public static void logW(String paramString1, String paramString2)
  {
    ArkEnvironmentManager.ILog localILog = logCallback;
    if (localILog == null) {
      return;
    }
    localILog.w(paramString1, paramString2);
  }
  
  public static void logW(String paramString, Object... paramVarArgs)
  {
    ArkEnvironmentManager.ILog localILog = logCallback;
    if (localILog == null) {
      return;
    }
    localILog.w(paramString, combine(paramVarArgs));
  }
  
  public static void logWithLimit(String paramString1, String paramString2, String paramString3)
  {
    logWithLimit(paramString1, paramString2, paramString3, 1000);
  }
  
  public static void logWithLimit(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Long localLong = (Long)logTimestamp.get(paramString1);
    if ((localLong == null) || (System.currentTimeMillis() - localLong.longValue() >= paramInt))
    {
      logTimestamp.put(paramString1, Long.valueOf(System.currentTimeMillis()));
      logI(paramString2, paramString3);
    }
  }
  
  public static void setLogCallback(ArkEnvironmentManager.ILog paramILog)
  {
    logCallback = paramILog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.Logger
 * JD-Core Version:    0.7.0.1
 */