package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.support.logging.SLog;

class WeatherDataProvider$1
  implements LbsManager.LbsUpdateListener
{
  WeatherDataProvider$1(WeatherDataProvider paramWeatherDataProvider) {}
  
  public void a(boolean paramBoolean, BasicLocation paramBasicLocation)
  {
    SLog.b("WeatherDataProvider", "WeatherLbsListener: onLbsUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramBasicLocation != null))
    {
      this.a.a(paramBasicLocation.b, paramBasicLocation.a);
      return;
    }
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.WeatherDataProvider.1
 * JD-Core Version:    0.7.0.1
 */