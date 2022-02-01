package com.tencent.mobileqq.activity.weather.webpage;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.LifeCycleExtKt;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;", "invoke"}, k=3, mv={1, 1, 16})
final class WeatherArkNotify$viewModel$2
  extends Lambda
  implements Function0<WeatherWebArkViewModel>
{
  WeatherArkNotify$viewModel$2(LifeCycleFragment paramLifeCycleFragment)
  {
    super(0);
  }
  
  @NotNull
  public final WeatherWebArkViewModel invoke()
  {
    return (WeatherWebArkViewModel)LifeCycleExtKt.a((ViewModelStoreOwner)this.$fragment).get(WeatherWebArkViewModel.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherArkNotify.viewModel.2
 * JD-Core Version:    0.7.0.1
 */