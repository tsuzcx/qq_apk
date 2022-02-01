package com.tencent.mobileqq.activity.weather.webpage;

import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class WeatherWebPageHelperKt$hasFollowWeather$1$1
  implements Runnable
{
  WeatherWebPageHelperKt$hasFollowWeather$1$1(WeatherWebPageHelperKt.hasFollowWeather.1 param1) {}
  
  public final void run()
  {
    if ((AccountDetail)this.this$0.jdField_a_of_type_KotlinJvmInternalRef$ObjectRef.element == null)
    {
      QLog.i("WeatherWebPageHelper", 1, "accountDetail == null");
      this.this$0.jdField_a_of_type_KotlinJvmFunctionsFunction1.invoke(Integer.valueOf(3));
      return;
    }
    if (((AccountDetail)this.this$0.jdField_a_of_type_KotlinJvmInternalRef$ObjectRef.element).followType == 1)
    {
      this.this$0.jdField_a_of_type_KotlinJvmFunctionsFunction1.invoke(Integer.valueOf(1));
      return;
    }
    this.this$0.jdField_a_of_type_KotlinJvmFunctionsFunction1.invoke(Integer.valueOf(2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt.hasFollowWeather.1.1
 * JD-Core Version:    0.7.0.1
 */