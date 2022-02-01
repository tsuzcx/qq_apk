package com.tencent.hippy.qq.preload;

import com.tencent.hippy.qq.api.MainTabPreloadInterpolator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherHippyApi;

public class WeatherInterpolator
  implements MainTabPreloadInterpolator
{
  public boolean hasNewMessage()
  {
    return ((IWeatherHippyApi)QRoute.api(IWeatherHippyApi.class)).hasNewMessage();
  }
  
  public boolean isCanPreload()
  {
    return ((IWeatherHippyApi)QRoute.api(IWeatherHippyApi.class)).canPreloadHippy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.preload.WeatherInterpolator
 * JD-Core Version:    0.7.0.1
 */