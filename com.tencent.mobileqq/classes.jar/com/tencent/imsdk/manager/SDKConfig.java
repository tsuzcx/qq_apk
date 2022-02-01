package com.tencent.imsdk.manager;

import com.tencent.imsdk.common.SystemUtil;

public class SDKConfig
{
  public SDKConfig.DeviceInfo deviceInfo = new SDKConfig.DeviceInfo();
  public SDKConfig.LogSetting logSetting = new SDKConfig.LogSetting();
  public SDKConfig.NetworkInfo networkInfo = new SDKConfig.NetworkInfo();
  public long sdkAppId = 0L;
  public String sdkInitPath = "";
  public long sdkInstanceType = 0L;
  public boolean testEnvironment = false;
  public String uiPlatform = "";
  
  public static float getAppCpuUsage()
  {
    return SystemUtil.getAppCpuUsage();
  }
  
  public static float getAppMemoryUsage()
  {
    return SystemUtil.getAppMemory();
  }
  
  public static float getSysCpuUsage()
  {
    return SystemUtil.getSysCpuUsage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.manager.SDKConfig
 * JD-Core Version:    0.7.0.1
 */