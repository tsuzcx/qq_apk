package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.mobileqq.weather.api.IWeatherCommApi;

class PublicAccountDetailActivityImpl$31
  implements Runnable
{
  PublicAccountDetailActivityImpl$31(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl, IWeatherCommApi paramIWeatherCommApi) {}
  
  public void run()
  {
    IWeatherCommApi localIWeatherCommApi = this.a;
    PublicAccountDetailActivityImpl localPublicAccountDetailActivityImpl = this.this$0;
    localIWeatherCommApi.startWeatherWebPageActivity(localPublicAccountDetailActivityImpl, localPublicAccountDetailActivityImpl.app, 4, this.this$0.weatherShareUrl);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.31
 * JD-Core Version:    0.7.0.1
 */