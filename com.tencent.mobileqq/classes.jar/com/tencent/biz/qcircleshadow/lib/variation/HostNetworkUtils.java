package com.tencent.biz.qcircleshadow.lib.variation;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.MobileQQ;

public class HostNetworkUtils
{
  public static int getConnRetryTimes(int paramInt)
  {
    return NetworkUtil.getConnRetryTimes(paramInt);
  }
  
  public static boolean is4G()
  {
    return AppNetConnInfo.getMobileInfo() == 3;
  }
  
  public static boolean is5G()
  {
    return AppNetConnInfo.getMobileInfo() == 4;
  }
  
  public static boolean isNetworkAvailable()
  {
    return NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ);
  }
  
  public static boolean isWifi()
  {
    return NetworkUtil.isWifiConnected(MobileQQ.sMobileQQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils
 * JD-Core Version:    0.7.0.1
 */