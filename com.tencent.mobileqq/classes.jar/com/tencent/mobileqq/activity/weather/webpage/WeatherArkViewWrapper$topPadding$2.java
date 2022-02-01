package com.tencent.mobileqq.activity.weather.webpage;

import android.content.res.Resources;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class WeatherArkViewWrapper$topPadding$2
  extends Lambda
  implements Function0<Integer>
{
  WeatherArkViewWrapper$topPadding$2(WeatherArkViewWrapper paramWeatherArkViewWrapper)
  {
    super(0);
  }
  
  public final int invoke()
  {
    int j = (int)this.this$0.getResources().getDimension(2131299011);
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = j + ImmersiveUtils.getStatusBarHeight(this.this$0.getContext());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherArkViewWrapper.topPadding.2
 * JD-Core Version:    0.7.0.1
 */