package com.tencent.mobileqq.applets;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import mqq.app.AppRuntime;

final class PublicAccountEventReport$5
  implements Runnable
{
  PublicAccountEventReport$5(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, QQAppInterface paramQQAppInterface, String paramString5, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    String str = this.b;
    boolean bool;
    if ((this.c == 0) && (this.d <= 0)) {
      bool = false;
    } else {
      bool = true;
    }
    PublicAccountEventReport.a((String)localObject1, 137, str, bool, this.e, this.f);
    localObject1 = this.g;
    str = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject1, "dc00898", "", str, "0X8009EB3", "0X8009EB3", 2, 0, (String)localObject2, localStringBuilder.toString(), this.h, "");
    if (!TextUtils.isEmpty(this.b))
    {
      localObject1 = this.g;
      str = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject1, "dc05007", "", str, "0X8009EB3", "0X8009EB3", 2, 0, (String)localObject2, localStringBuilder.toString(), this.h, this.b);
    }
    if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.a)) {
      ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeatherMessageExpose(this.g, this.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.5
 * JD-Core Version:    0.7.0.1
 */