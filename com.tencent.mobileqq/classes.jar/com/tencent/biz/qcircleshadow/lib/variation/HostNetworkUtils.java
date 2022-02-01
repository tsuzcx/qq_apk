package com.tencent.biz.qcircleshadow.lib.variation;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.MobileQQ;

public class HostNetworkUtils
{
  public static int getConnRetryTimes(int paramInt)
  {
    return NetworkUtil.a(paramInt);
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
    return NetworkUtil.g(MobileQQ.sMobileQQ);
  }
  
  public static boolean isWifi()
  {
    return NetworkUtil.h(MobileQQ.sMobileQQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils
 * JD-Core Version:    0.7.0.1
 */