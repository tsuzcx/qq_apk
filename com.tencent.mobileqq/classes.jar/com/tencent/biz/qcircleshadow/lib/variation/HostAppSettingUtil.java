package com.tencent.biz.qcircleshadow.lib.variation;

import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.QUA;

public class HostAppSettingUtil
{
  public static String buildNum()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).buildNum();
  }
  
  public static boolean enableTalkBack()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).enableTalkBack();
  }
  
  public static String getReportVersionName()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getReportVersionName();
  }
  
  public static String getSubVersion()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getSubVersion();
  }
  
  public static String getVersion()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getVersion();
  }
  
  public static String getVersionForPic()
  {
    return QUA.getVersionForPic();
  }
  
  public static boolean isDebugVersion()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion();
  }
  
  public static boolean isGrayVersion()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isGrayVersion();
  }
  
  public static boolean isPublicVersion()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isPublicVersion();
  }
  
  public static boolean isUITest()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isUITest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil
 * JD-Core Version:    0.7.0.1
 */