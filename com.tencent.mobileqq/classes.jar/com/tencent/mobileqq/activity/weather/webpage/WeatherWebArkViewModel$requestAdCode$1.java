package com.tencent.mobileqq.activity.weather.webpage;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.QQPermissionCallback;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel$requestAdCode$1", "Lmqq/app/QQPermissionCallback;", "deny", "", "i", "", "strings", "", "", "ints", "", "(I[Ljava/lang/String;[I)V", "grant", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WeatherWebArkViewModel$requestAdCode$1
  implements QQPermissionCallback
{
  WeatherWebArkViewModel$requestAdCode$1(String paramString) {}
  
  public void deny(int paramInt, @NotNull String[] paramArrayOfString, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "strings");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "ints");
    QLog.i("WeatherWebArkViewModel", 1, "requestAdCode deny");
    if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherWebArkViewModel.a().postValue(new WebPageData(3, null, null, null, 0, 0, 62, null));
    }
  }
  
  public void grant(int paramInt, @NotNull String[] paramArrayOfString, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "strings");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "ints");
    QLog.i("WeatherWebArkViewModel", 1, "requestAdCode grant");
    this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherWebArkViewModel.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherWebArkViewModel.requestAdCode.1
 * JD-Core Version:    0.7.0.1
 */