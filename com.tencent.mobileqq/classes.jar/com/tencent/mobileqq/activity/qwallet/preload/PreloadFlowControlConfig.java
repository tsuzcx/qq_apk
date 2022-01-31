package com.tencent.mobileqq.activity.qwallet.preload;

import ajeu;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.Serializable;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class PreloadFlowControlConfig
  implements Serializable
{
  public static final String CONFIG_NAME = "flow_config";
  private static final long serialVersionUID = 1L;
  private String mConfigPath;
  public int mDownloadStatus = -1;
  public long mNextCanReqTime;
  public long mNextRetryReqTime;
  public int mRetryDownloadTimes;
  public int mRetryReqTimes;
  public long mValidDownloadTime;
  
  public PreloadFlowControlConfig(String paramString)
  {
    this.mConfigPath = paramString;
  }
  
  public static String getConfigPath(String paramString, AppRuntime paramAppRuntime)
  {
    return PreloadManager.a(paramAppRuntime) + paramString + "flow_config";
  }
  
  public static PreloadFlowControlConfig getFlowControlConfig(String paramString, AppRuntime paramAppRuntime)
  {
    String str = getConfigPath(paramString, paramAppRuntime);
    try
    {
      paramString = (PreloadFlowControlConfig)ajeu.a(str);
      paramAppRuntime = paramString;
      if (paramString == null) {
        paramAppRuntime = new PreloadFlowControlConfig(str);
      }
      return paramAppRuntime;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  public void saveConfig()
  {
    ThreadManager.getFileThreadHandler().post(new PreloadFlowControlConfig.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadFlowControlConfig
 * JD-Core Version:    0.7.0.1
 */