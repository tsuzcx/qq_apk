package com.tencent.mobileqq.activity.weather.webpage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "webPageData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/activity/weather/webpage/WebPageData;", "getWebPageData", "()Landroidx/lifecycle/MutableLiveData;", "isNeedReqPermissions", "", "activity", "Lmqq/app/AppActivity;", "onArkLoadState", "", "state", "", "onArkMsgToClient", "params", "", "onArkMsgToWeb", "requestAdCode", "originAdCode", "requestAndCompareAdCode", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WeatherWebArkViewModel
  extends ViewModel
{
  public static final WeatherWebArkViewModel.Companion a;
  @NotNull
  private final MutableLiveData<WebPageData> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherWebArkViewModel$Companion = new WeatherWebArkViewModel.Companion(null);
  }
  
  public WeatherWebArkViewModel()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  }
  
  @NotNull
  public final MutableLiveData<WebPageData> a()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public final void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkViewModel", 2, "onArkLoadComplete  state: " + paramInt);
    }
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(new WebPageData(2, null, null, null, paramInt, 0, 46, null));
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "originAdCode");
    QLog.i("WeatherWebArkViewModel", 1, "requestAndCompareAdCode originAdCode: " + paramString);
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation((LbsManagerServiceOnLocationChangeListener)new WeatherWebArkViewModel.requestAndCompareAdCode.1(this, paramString, "qq_weather", false));
  }
  
  public final void a(@Nullable AppActivity paramAppActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "originAdCode");
    if ((paramAppActivity != null) && (a(paramAppActivity)))
    {
      paramAppActivity.requestPermissions(new WeatherWebArkViewModel.requestAdCode.1(this, paramString), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    a(paramString);
  }
  
  public final boolean a(@Nullable AppActivity paramAppActivity)
  {
    if (paramAppActivity == null)
    {
      QLog.i("WeatherWebArkViewModel", 1, "activity == null");
      return false;
    }
    if (Build.VERSION.SDK_INT < 23)
    {
      QLog.i("WeatherWebArkViewModel", 1, "isNeedReqPermissions lass than Build.VERSION_CODES.M");
      return false;
    }
    if (paramAppActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
    {
      QLog.i("WeatherWebArkViewModel", 1, "isNeedReqPermissions PERMISSION_GRANTED");
      return false;
    }
    paramAppActivity = paramAppActivity.getSharedPreferences("cmgame_sp", 0);
    Intrinsics.checkExpressionValueIsNotNull(paramAppActivity, "activity.getSharedPrefer…ME, Context.MODE_PRIVATE)");
    long l1 = paramAppActivity.getLong("sp_key_weather_web_ark_request_permission", 0L);
    long l2 = NetConnInfoCenter.getServerTime();
    if (Math.abs(l2 - l1) < 86400)
    {
      QLog.i("WeatherWebArkViewModel", 1, "isNeedReqPermissions  but has requested in 24 h");
      return false;
    }
    paramAppActivity.edit().putLong("sp_key_weather_web_ark_request_permission", l2).apply();
    QLog.i("WeatherWebArkViewModel", 1, "isNeedReqPermissions true");
    return true;
  }
  
  public final void b(@Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkViewModel", 2, "onArkMsgToWeb  params: " + paramString);
    }
    if (paramString != null) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.optInt("type") == 1)
      {
        i = localJSONObject.optJSONObject("data").optInt("height");
        this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(new WebPageData(0, "receive_ark_msg", paramString, null, 0, i, 24, null));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("WeatherWebArkViewModel", 1, "onArkMsgToClient params: " + paramString, localThrowable);
        int i = 0;
      }
    }
  }
  
  public final void c(@Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherWebArkViewModel", 2, "onArkMsgToClient  params: " + paramString);
    }
    if (paramString != null) {}
    try
    {
      Object localObject = new JSONObject(paramString);
      if (((JSONObject)localObject).optInt("type") == 1)
      {
        localObject = ((JSONObject)localObject).optJSONObject("data").optString("bg_url");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          MutableLiveData localMutableLiveData = this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
          Intrinsics.checkExpressionValueIsNotNull(localObject, "bgUrl");
          localMutableLiveData.postValue(new WebPageData(1, null, null, (String)localObject, 0, 0, 54, null));
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("WeatherWebArkViewModel", 1, "onArkMsgToClient params: " + paramString, localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherWebArkViewModel
 * JD-Core Version:    0.7.0.1
 */