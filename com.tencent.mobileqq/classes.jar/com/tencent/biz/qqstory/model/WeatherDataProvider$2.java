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
      SLog.a("WeatherDataProvider", "requestWeather onCmdRespond success, temperature : %s .", Integer.valueOf(paramGetWeatherResponse.b));
      this.a.jdField_a_of_type_JavaLangObject = new WeatherDataProvider.WeatherInfo(paramGetWeatherResponse.b, paramGetWeatherResponse.a);
      SLog.c("WeatherDataProvider", "update local weather data.");
      paramGetWeatherRequest = (StoryConfigManager)SuperManager.a(10);
      paramGetWeatherRequest.b("edit_video_weather_filter_data", Integer.valueOf(paramGetWeatherResponse.b));
      paramGetWeatherRequest.b("edit_video_weather_desc", paramGetWeatherResponse.a);
      WeatherDataProvider.a(this.a, System.currentTimeMillis() + 14400000L);
      paramGetWeatherRequest.b("edit_video_weather_expiry_time", Long.valueOf(WeatherDataProvider.a(this.a)));
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      SLog.d("WeatherDataProvider", "requestWeather onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramGetWeatherRequest });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.WeatherDataProvider.2
 * JD-Core Version:    0.7.0.1
 */