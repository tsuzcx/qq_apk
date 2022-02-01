package com.tencent.mobileqq.applets;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;

final class PublicAccountEventReport$2
  implements Runnable
{
  PublicAccountEventReport$2(IWeatherCommApi paramIWeatherCommApi, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = ServiceAccountFolderManager.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqWeatherApiIWeatherCommApi.isWeatherPA(str)) {
      ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeatherMessageExpose(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.2
 * JD-Core Version:    0.7.0.1
 */