package com.tencent.aladdin.config.utils;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.mobileqq.pb.MessageMicro;
import org.json.JSONObject;

public class Log
{
  public static void d(String paramString1, String paramString2)
  {
    AladdinLogger localAladdinLogger = Aladdin.getLogger();
    if (localAladdinLogger != null)
    {
      localAladdinLogger.d(paramString1, paramString2);
      return;
    }
    android.util.Log.d(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AladdinLogger localAladdinLogger = Aladdin.getLogger();
    if (localAladdinLogger != null)
    {
      localAladdinLogger.e(paramString1, paramString2);
      return;
    }
    android.util.Log.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AladdinLogger localAladdinLogger = Aladdin.getLogger();
    if (localAladdinLogger != null)
    {
      localAladdinLogger.e(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AladdinLogger localAladdinLogger = Aladdin.getLogger();
    if (localAladdinLogger != null)
    {
      localAladdinLogger.i(paramString1, paramString2);
      return;
    }
    android.util.Log.i(paramString1, paramString2);
  }
  
  public static boolean isDebugVersion()
  {
    AladdinLogger localAladdinLogger = Aladdin.getLogger();
    if (localAladdinLogger != null) {
      return localAladdinLogger.isDebugVersion();
    }
    return false;
  }
  
  public static <T extends MessageMicro> String pbToString(T paramT)
  {
    return ProtobufUtils.getDebugPBMessage(paramT.toByteArray(), paramT.getClass()).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.utils.Log
 * JD-Core Version:    0.7.0.1
 */