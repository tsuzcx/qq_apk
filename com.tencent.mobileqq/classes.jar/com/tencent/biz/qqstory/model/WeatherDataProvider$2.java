package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.GetWeatherRequest;
import com.tencent.biz.qqstory.network.response.GetWeatherResponse;
import com.tencent.biz.qqstory.support.logging.SLog;

class WeatherDataProvider$2
  implements CmdTaskManger.CommandCallback<GetWeatherRequest, GetWeatherResponse>
{
  WeatherDataProvider$2(WeatherDataProvider paramWeatherDataProvider) {}
  
  public void a(@NonNull GetWeatherRequest paramGetWeatherRequest, @Nullable GetWeatherResponse paramGetWeatherResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.b("WeatherDataProvider", "requestWeather Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramGetWeatherResponse != null))
    {
      SLog.a("WeatherDataProvider", "requestWeather onCmdRespond success, temperature : %s .", Integer.valueOf(paramGetWeatherResponse.a));
      this.a.c = new WeatherDataProvider.WeatherInfo(paramGetWeatherResponse.a, paramGetWeatherResponse.b);
      SLog.c("WeatherDataProvider", "update local weather data.");
      paramGetWeatherRequest = (StoryConfigManager)SuperManager.a(10);
      paramGetWeatherRequest.d("edit_video_weather_filter_data", Integer.valueOf(paramGetWeatherResponse.a));
      paramGetWeatherRequest.d("edit_video_weather_desc", paramGetWeatherResponse.b);
      WeatherDataProvider.a(this.a, System.currentTimeMillis() + 14400000L);
      paramGetWeatherRequest.d("edit_video_weather_expiry_time", Long.valueOf(WeatherDataProvider.a(this.a)));
      paramGetWeatherRequest = this.a;
      paramGetWeatherRequest.a(true, paramGetWeatherRequest.c);
    }
    else
    {
      SLog.d("WeatherDataProvider", "requestWeather onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramGetWeatherRequest });
      this.a.a(false, null);
    }
    this.a.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.WeatherDataProvider.2
 * JD-Core Version:    0.7.0.1
 */