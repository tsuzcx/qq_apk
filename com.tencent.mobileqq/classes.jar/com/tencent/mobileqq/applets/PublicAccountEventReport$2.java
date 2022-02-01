package com.tencent.mobileqq.applets;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.weather.WeatherDCReportHelper;
import com.tencent.mobileqq.app.QQAppInterface;

final class PublicAccountEventReport$2
  implements Runnable
{
  PublicAccountEventReport$2(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (PAWeatherItemBuilder.a(ServiceAccountFolderManager.a().a())) {
      WeatherDCReportHelper.a().a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.2
 * JD-Core Version:    0.7.0.1
 */