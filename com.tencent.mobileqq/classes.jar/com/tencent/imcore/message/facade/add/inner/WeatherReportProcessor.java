package com.tencent.imcore.message.facade.add.inner;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;

class WeatherReportProcessor
  implements IAddMultiMessagesInnerProcessor
{
  public void a(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(paramMessageRecord.frienduin)) {
      ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).onWeatherPushMessageArrive(paramBaseQQAppInterface, paramMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.inner.WeatherReportProcessor
 * JD-Core Version:    0.7.0.1
 */