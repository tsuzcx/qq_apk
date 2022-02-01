package com.tencent.TMG.logger;

import android.util.Log;
import com.tencent.TMG.sdk.LogListener;
import java.io.File;

public class AVSDKLogger
{
  public static final int DEFAULT_MAX_LOG_FILE_SIZE = 52428800;
  private static final String LOGTAG = "AVSDKLogger";
  private static boolean s_IsEnablePrintLog;
  private static boolean s_IsEnableWriteLog;
  private static String s_LogDir;
  private static LogListener s_LogListener;
  private static int s_MaxFileSize;
  
  public static String getLogDir()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getLogDir: ");
    localStringBuilder.append(s_LogDir);
    Log.d("AVSDKLogger", localStringBuilder.toString());
    return s_LogDir;
  }
  
  public static native int getLogLevel();
  
  public static LogListener getLogListener()
  {
    return s_LogListener;
  }
  
  public static int getMaxFileSize()
  {
    return s_MaxFileSize;
  }
  
  public static boolean isEnablePrintLog()
  {
    return s_IsEnablePrintLog;
  }
  
  public static boolean isEnableWriteLog()
  {
    return s_IsEnableWriteLog;
  }
  
  public static void setIsEnablePrintLog(boolean paramBoolean)
  {
    s_IsEnablePrintLog = paramBoolean;
  }
  
  public static void setIsEnableWriteLog(boolean paramBoolean)
  {
    s_IsEnableWriteLog = paramBoolean;
  }
  
  public static void setLogDir(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      Log.e("AVSDKLogger", "log dir not exist");
      localFile.mkdirs();
    }
    else
    {
      Log.i("AVSDKLogger", "log dir exist");
    }
    s_LogDir = paramString;
    paramString = new StringBuilder();
    paramString.append("setLogDir: ");
    paramString.append(s_LogDir);
    Log.d("AVSDKLogger", paramString.toString());
  }
  
  public static native int setLogLevel(int paramInt);
  
  public static void setLogListener(LogListener paramLogListener)
  {
    s_LogListener = paramLogListener;
  }
  
  public static void setMaxFileSize(int paramInt)
  {
    s_MaxFileSize = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.logger.AVSDKLogger
 * JD-Core Version:    0.7.0.1
 */