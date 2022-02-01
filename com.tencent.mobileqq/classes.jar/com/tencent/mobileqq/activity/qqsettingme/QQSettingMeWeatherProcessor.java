package com.tencent.mobileqq.activity.qqsettingme;

import android.content.SharedPreferences;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeWeatherBean;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import com.tencent.mobileqq.weather.api.IWeatherRuntimeService;
import com.tencent.mobileqq.weather.api.listener.WeatherUpdateListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QQSettingMeWeatherProcessor
  extends QQSettingMeBaseProcessor
{
  public MutableLiveData<QQSettingMeWeatherBean> a;
  private IWeatherRuntimeService jdField_a_of_type_ComTencentMobileqqWeatherApiIWeatherRuntimeService;
  private WeatherUpdateListener jdField_a_of_type_ComTencentMobileqqWeatherApiListenerWeatherUpdateListener;
  public MutableLiveData<Boolean> b;
  private boolean b;
  
  public QQSettingMeWeatherProcessor()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  }
  
  private void j()
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new QQSettingMeWeatherProcessor.3(this, 0, true, true, 60000L, true, false, "QQSettingRedesign"));
  }
  
  public String a()
  {
    return "d_weather";
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeWeatherProcessor.1(this, paramQQSettingMe));
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeWeatherProcessor.2(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqWeatherApiIWeatherRuntimeService = ((IWeatherRuntimeService)((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getRuntimeService(IWeatherRuntimeService.class));
    this.jdField_a_of_type_ComTencentMobileqqWeatherApiListenerWeatherUpdateListener = new QQSettingMeWeatherProcessor.QQSettingMeWeatherListener(this, null);
    this.jdField_a_of_type_ComTencentMobileqqWeatherApiIWeatherRuntimeService.setWeatherUpdateListener(this.jdField_a_of_type_ComTencentMobileqqWeatherApiListenerWeatherUpdateListener);
  }
  
  public void b()
  {
    super.b();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWeatherApiIWeatherRuntimeService = ((IWeatherRuntimeService)((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getRuntimeService(IWeatherRuntimeService.class));
      this.jdField_a_of_type_ComTencentMobileqqWeatherApiListenerWeatherUpdateListener = new QQSettingMeWeatherProcessor.QQSettingMeWeatherListener(this, null);
      this.jdField_a_of_type_ComTencentMobileqqWeatherApiIWeatherRuntimeService.setWeatherUpdateListener(this.jdField_a_of_type_ComTencentMobileqqWeatherApiListenerWeatherUpdateListener);
      this.jdField_b_of_type_Boolean = true;
    }
    try
    {
      if (((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSystemService("window")).getDefaultDisplay().getWidth() < 480)
      {
        this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.setValue(Boolean.valueOf(true));
        return;
      }
      g();
      this.jdField_a_of_type_ComTencentMobileqqWeatherApiIWeatherRuntimeService.updateWeatherInfo(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQSettingRedesign", 1, localThrowable, new Object[0]);
    }
    ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeather((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "drawer_weather_expose");
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A42B", "0X800A42B", 0, 0, "", "", "", "");
    int i = VipInfoHandler.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), false);
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800B178", "0X800B178", 0, 0, String.valueOf(i), "", "", "");
  }
  
  public void d()
  {
    IWeatherRuntimeService localIWeatherRuntimeService = this.jdField_a_of_type_ComTencentMobileqqWeatherApiIWeatherRuntimeService;
    if (localIWeatherRuntimeService != null)
    {
      localIWeatherRuntimeService.setWeatherUpdateListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWeatherApiIWeatherRuntimeService = null;
    }
  }
  
  public void g()
  {
    QQSettingMeWeatherBean localQQSettingMeWeatherBean = new QQSettingMeWeatherBean();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
    localQQSettingMeWeatherBean.jdField_a_of_type_JavaLangString = localSharedPreferences.getString("drawer_cur_temp", null);
    localQQSettingMeWeatherBean.b = localSharedPreferences.getString("drawer_cur_city", null);
    localQQSettingMeWeatherBean.jdField_a_of_type_Int = localSharedPreferences.getInt("drawer_cur_adcode", 0);
    localQQSettingMeWeatherBean.c = localSharedPreferences.getString("drawer_cur_code", null);
    localQQSettingMeWeatherBean.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("drawer_show_flag", false);
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(localQQSettingMeWeatherBean);
  }
  
  public void onClick(View paramView)
  {
    int i = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getInt("cur_adcode", 0);
    ((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).startNewWeatherWebPageActivity(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, false, "", true, String.valueOf(i));
    paramView = new StringBuilder();
    paramView.append("startNewWeatherWeb adCode = ");
    paramView.append(i);
    QLog.i("QQSettingRedesign", 1, paramView.toString());
    ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeather((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, "drawer_weather_click");
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A42C", "0X800A42C", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8005BE4", "0X8005BE4", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeWeatherProcessor
 * JD-Core Version:    0.7.0.1
 */