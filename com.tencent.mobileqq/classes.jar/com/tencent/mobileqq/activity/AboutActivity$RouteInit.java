package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.qroute.route.IRouteRegister;
import com.tencent.mobileqq.qroute.route.RouteInitializer;

public class AboutActivity$RouteInit
  implements RouteInitializer
{
  public void init(IRouteRegister paramIRouteRegister)
  {
    paramIRouteRegister.register("/setting/about", AboutActivity.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity.RouteInit
 * JD-Core Version:    0.7.0.1
 */