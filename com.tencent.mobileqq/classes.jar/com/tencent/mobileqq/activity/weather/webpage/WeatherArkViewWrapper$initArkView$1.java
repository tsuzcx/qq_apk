package com.tencent.mobileqq.activity.weather.webpage;

import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/activity/weather/webpage/WeatherArkViewWrapper$initArkView$1", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "onLoadFailed", "", "state", "", "errCode", "msg", "", "canRetry", "", "onLoadState", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WeatherArkViewWrapper$initArkView$1
  implements ArkViewImplement.LoadCallback
{
  public void onLoadFailed(int paramInt1, int paramInt2, @Nullable String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    QLog.i("WeatherWebArkWrapper", 1, "initArkView onLoadState : state -> " + paramInt);
    if (paramInt == 1) {
      this.a.setArkLoaded(true);
    }
    WeatherPreloadHelperKt.a(4, "state = " + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      WeatherArkViewWrapper.a(this.a);
      return;
    case -1: 
      WeatherArkViewWrapper.b(this.a);
      return;
    }
    WeatherArkViewWrapper.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherArkViewWrapper.initArkView.1
 * JD-Core Version:    0.7.0.1
 */