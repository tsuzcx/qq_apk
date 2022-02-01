package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt;

class PublicAccountDetailActivityImpl$30
  implements Runnable
{
  PublicAccountDetailActivityImpl$30(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void run()
  {
    WeatherWebPageHelperKt.b(this.this$0, this.this$0.app, 4, this.this$0.weatherShareUrl);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.30
 * JD-Core Version:    0.7.0.1
 */