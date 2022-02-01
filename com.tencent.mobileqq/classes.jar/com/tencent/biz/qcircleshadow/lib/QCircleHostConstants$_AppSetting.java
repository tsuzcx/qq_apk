package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;

public class QCircleHostConstants$_AppSetting
{
  public static String buildNum()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).buildNum();
  }
  
  public static boolean enableTalkBack()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).enableTalkBack();
  }
  
  public static int getHostVersion()
  {
    String[] arrayOfString = getSubVersion().split("\\.");
    if ((arrayOfString != null) && (arrayOfString.length >= 3))
    {
      StringBuilder localStringBuilder = new StringBuilder(arrayOfString[0]);
      if (arrayOfString[1].length() == 1)
      {
        localStringBuilder.append("0");
        localStringBuilder.append(arrayOfString[1]);
      }
      else
      {
        localStringBuilder.append(arrayOfString[1]);
      }
      if (arrayOfString[2].length() == 1)
      {
        localStringBuilder.append("0");
        localStringBuilder.append(arrayOfString[2]);
      }
      else
      {
        localStringBuilder.append(arrayOfString[2]);
      }
      return Integer.parseInt(localStringBuilder.toString());
    }
    return 2147483647;
  }
  
  public static String getSubVersion()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getSubVersion();
  }
  
  public static String getVersion()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getVersion();
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
  
  public static String reportVersionName()
  {
    return ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getReportVersionName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting
 * JD-Core Version:    0.7.0.1
 */