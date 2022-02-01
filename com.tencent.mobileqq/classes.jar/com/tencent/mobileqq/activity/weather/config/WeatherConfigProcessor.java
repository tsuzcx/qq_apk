package com.tencent.mobileqq.activity.weather.config;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/config/WeatherConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/activity/weather/config/WeatherConfigBean;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "isNeedUpgradeReset", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/activity/weather/config/WeatherConfigBean;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WeatherConfigProcessor
  extends IQConfigProcessor<WeatherConfigBean>
{
  public static final WeatherConfigProcessor.Companion a = new WeatherConfigProcessor.Companion(null);
  
  @NotNull
  public WeatherConfigBean a(int paramInt)
  {
    return new WeatherConfigBean(false, 1, null);
  }
  
  @Nullable
  public WeatherConfigBean a(@Nullable QConfItem[] paramArrayOfQConfItem)
  {
    if (paramArrayOfQConfItem != null)
    {
      paramArrayOfQConfItem = (QConfItem)ArraysKt.firstOrNull(paramArrayOfQConfItem);
      if (paramArrayOfQConfItem != null)
      {
        paramArrayOfQConfItem = paramArrayOfQConfItem.a;
        if (paramArrayOfQConfItem != null) {
          return WeatherConfigBean.a.a(paramArrayOfQConfItem);
        }
      }
    }
    return null;
  }
  
  public void a(@Nullable WeatherConfigBean paramWeatherConfigBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherConfigProcessor", 2, "onUpdate newConf:" + paramWeatherConfigBean);
    }
  }
  
  @NotNull
  public Class<WeatherConfigBean> clazz()
  {
    return WeatherConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.w("WeatherConfigProcessor", 2, "onReqFailed, failCode:" + paramInt);
  }
  
  public int type()
  {
    return 702;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.config.WeatherConfigProcessor
 * JD-Core Version:    0.7.0.1
 */