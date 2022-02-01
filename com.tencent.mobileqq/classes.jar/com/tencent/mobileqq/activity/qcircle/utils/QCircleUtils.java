package com.tencent.mobileqq.activity.qcircle.utils;

import com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService;
import com.tencent.mobileqq.qcircle.api.IQCirclePreLoaderService;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QCircleUtils
{
  public static IQCircleService a()
  {
    return (IQCircleService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQCircleService.class, "");
  }
  
  public static IQCircleRedPointService b()
  {
    return (IQCircleRedPointService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQCircleRedPointService.class, "");
  }
  
  public static IQCirclePreLoaderService c()
  {
    return (IQCirclePreLoaderService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQCirclePreLoaderService.class, "");
  }
  
  public static IQCircleEeveeManangerService d()
  {
    return (IQCircleEeveeManangerService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQCircleEeveeManangerService.class, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils
 * JD-Core Version:    0.7.0.1
 */