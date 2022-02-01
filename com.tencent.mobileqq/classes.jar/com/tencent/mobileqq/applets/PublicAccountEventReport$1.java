package com.tencent.mobileqq.applets;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;

final class PublicAccountEventReport$1
  implements Runnable
{
  PublicAccountEventReport$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeatherMessageExpose(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.1
 * JD-Core Version:    0.7.0.1
 */