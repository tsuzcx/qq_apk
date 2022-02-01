package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;

class PublicAccountDetailActivityImpl$30
  implements Runnable
{
  PublicAccountDetailActivityImpl$30(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void run()
  {
    IWeatherCommApi localIWeatherCommApi = (IWeatherCommApi)QRoute.api(IWeatherCommApi.class);
    PublicAccountDetailActivityImpl localPublicAccountDetailActivityImpl = this.this$0;
    localIWeatherCommApi.startWeatherWebPageActivity(localPublicAccountDetailActivityImpl, localPublicAccountDetailActivityImpl.app, 4, this.this$0.weatherShareUrl);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.30
 * JD-Core Version:    0.7.0.1
 */