package com.tencent.mobileqq.activity.weather.webpage;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherPreloadWebPageConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherPreloadWebPageConfigProcessor$Config;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/activity/weather/webpage/WeatherPreloadWebPageConfigProcessor$Config;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "Config", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WeatherPreloadWebPageConfigProcessor
  extends IQConfigProcessor<WeatherPreloadWebPageConfigProcessor.Config>
{
  public static final WeatherPreloadWebPageConfigProcessor.Companion a = new WeatherPreloadWebPageConfigProcessor.Companion(null);
  
  @NotNull
  public WeatherPreloadWebPageConfigProcessor.Config a(int paramInt)
  {
    return new WeatherPreloadWebPageConfigProcessor.Config();
  }
  
  @Nullable
  public WeatherPreloadWebPageConfigProcessor.Config a(@Nullable QConfItem[] paramArrayOfQConfItem)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("WeatherPreloadWebPageConfigProcessor", 2, "onParsed");
    }
    WeatherPreloadWebPageConfigProcessor.Config localConfig = new WeatherPreloadWebPageConfigProcessor.Config();
    if (paramArrayOfQConfItem != null)
    {
      if (paramArrayOfQConfItem.length != 0) {
        break label68;
      }
      i = 1;
      if (i != 0) {
        break label73;
      }
    }
    label68:
    label73:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfQConfItem, "confFiles[0].content");
        localConfig.a(paramArrayOfQConfItem);
      }
      return localConfig;
      i = 0;
      break;
    }
  }
  
  public void a(@Nullable WeatherPreloadWebPageConfigProcessor.Config paramConfig) {}
  
  @NotNull
  public Class<WeatherPreloadWebPageConfigProcessor.Config> clazz()
  {
    return WeatherPreloadWebPageConfigProcessor.Config.class;
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
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 638;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherPreloadWebPageConfigProcessor
 * JD-Core Version:    0.7.0.1
 */