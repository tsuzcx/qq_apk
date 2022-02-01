package com.tencent.mobileqq.activity.weather.config;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/config/WeatherConfigBean$Companion;", "", "()V", "PRELOAD_AD_KEY", "", "TAG", "parse", "Lcom/tencent/mobileqq/activity/weather/config/WeatherConfigBean;", "content", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WeatherConfigBean$Companion
{
  @JvmStatic
  @NotNull
  public final WeatherConfigBean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    if (QLog.isColorLevel()) {
      QLog.d("WeatherConfigBean", 2, "parse from:" + paramString + ' ');
    }
    try
    {
      if (new JSONObject(paramString).optInt("ConfigEnableWeatherPreloadAd", 1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        WeatherConfigBean localWeatherConfigBean = new WeatherConfigBean(bool);
        return localWeatherConfigBean;
      }
      return new WeatherConfigBean(false, 1, null);
    }
    catch (JSONException localJSONException)
    {
      QLog.e("WeatherConfigBean", 1, "error parse weather manage content:" + paramString, (Throwable)localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.config.WeatherConfigBean.Companion
 * JD-Core Version:    0.7.0.1
 */