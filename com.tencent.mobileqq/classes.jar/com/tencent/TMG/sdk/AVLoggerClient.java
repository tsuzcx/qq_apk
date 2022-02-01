package com.tencent.TMG.sdk;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.TMG.logger.AVLoggerChooser;
import com.tencent.TMG.logger.AVSDKLogger;
import com.tencent.TMG.logger.Logger;

public class AVLoggerClient
  extends AVSDKLogger
{
  public static String BUGLYTAG = "avsdk2bug";
  
  public static void initLogSetting(Context paramContext, String paramString)
  {
    Logger localLogger = AVLoggerChooser.getLogger();
    boolean bool = true;
    if (localLogger != null)
    {
      localLogger.init(paramString);
      setIsEnablePrintLog(localLogger.isEnablePrintLog());
      if (localLogger.getWriteLogLevel() < 1) {
        bool = false;
      }
      setIsEnableWriteLog(bool);
      setLogDir(localLogger.getLogDir());
    }
    else
    {
      setIsEnablePrintLog(true);
      setIsEnableWriteLog(true);
      paramString = new StringBuilder();
      paramString.append(Environment.getExternalStorageDirectory());
      paramString.append("/tencent/imsdklogs/");
      paramString.append(paramContext.getPackageName().replace('.', '/'));
      setLogDir(paramString.toString());
    }
    setMaxFileSize(52428800);
    setLogListener(null);
  }
  
  public static boolean isLogUploadToApp()
  {
    return getLogListener() != null;
  }
  
  public static void log2bugly(String paramString, int paramInt)
  {
    Logger localLogger = AVLoggerChooser.getLogger();
    if (localLogger != null) {
      localLogger.reportKeyLog(BUGLYTAG, paramInt, paramString);
    }
  }
  
  public static void onLogReceived(String paramString, int paramInt)
  {
    LogListener localLogListener = getLogListener();
    if (localLogListener != null) {
      localLogListener.onLogReceived(paramString, paramInt);
    }
  }
  
  public static void setLogSetting(AVSDKLogSetting paramAVSDKLogSetting)
  {
    if (paramAVSDKLogSetting != null)
    {
      setIsEnablePrintLog(paramAVSDKLogSetting.isEnablePrintLog);
      setIsEnableWriteLog(paramAVSDKLogSetting.isEnableWriteLog);
      if (!TextUtils.isEmpty(paramAVSDKLogSetting.logDir)) {
        setLogDir(paramAVSDKLogSetting.logDir);
      }
      setMaxFileSize(paramAVSDKLogSetting.maxFileSize);
      setLogListener(paramAVSDKLogSetting.logListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVLoggerClient
 * JD-Core Version:    0.7.0.1
 */