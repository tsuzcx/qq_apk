package com.tencent.mobileqq.activity.weather.config;

import com.tencent.mobileqq.config.QConfigManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/config/WeatherConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "getConfig", "Lcom/tencent/mobileqq/activity/weather/config/WeatherConfigBean;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WeatherConfigProcessor$Companion
{
  @JvmStatic
  @NotNull
  public final WeatherConfigBean a()
  {
    Object localObject = QConfigManager.a().a(702);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QConfigManager.getSingle…n().loadConObj(CONFIG_ID)");
    return (WeatherConfigBean)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.config.WeatherConfigProcessor.Companion
 * JD-Core Version:    0.7.0.1
 */