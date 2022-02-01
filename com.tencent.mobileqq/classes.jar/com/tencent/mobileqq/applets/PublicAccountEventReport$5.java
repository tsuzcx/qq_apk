package com.tencent.mobileqq.applets;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import mqq.app.AppRuntime;

final class PublicAccountEventReport$5
  implements Runnable
{
  PublicAccountEventReport$5(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, QQAppInterface paramQQAppInterface, String paramString5) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    String str = this.jdField_b_of_type_JavaLangString;
    boolean bool;
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int <= 0)) {
      bool = false;
    } else {
      bool = true;
    }
    PublicAccountEventReport.a((String)localObject1, 137, str, bool, this.c, this.d);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    str = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject1, "dc00898", "", str, "0X8009EB3", "0X8009EB3", 2, 0, (String)localObject2, localStringBuilder.toString(), this.e, "");
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject1, "dc05007", "", str, "0X8009EB3", "0X8009EB3", 2, 0, (String)localObject2, localStringBuilder.toString(), this.e, this.jdField_b_of_type_JavaLangString);
    }
    if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.jdField_a_of_type_JavaLangString)) {
      ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeatherMessageExpose(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.5
 * JD-Core Version:    0.7.0.1
 */