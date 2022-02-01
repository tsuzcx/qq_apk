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
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import com.tencent.mobileqq.weather.api.IWeatherRuntimeService;
import com.tencent.mobileqq.weather.api.listener.WeatherUpdateListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQSettingMeWeatherProcessor
  extends QQSettingMeBaseProcessor
{
  private static final String[] i = { "android.permission.ACCESS_FINE_LOCATION" };
  public MutableLiveData<QQSettingMeWeatherBean> a = new MutableLiveData();
  public MutableLiveData<Boolean> b = new MutableLiveData();
  private IWeatherRuntimeService j;
  private WeatherUpdateListener k;
  private boolean l;
  private QQPermission m;
  
  private void a()
  {
    if (this.m == null)
    {
      BusinessConfig localBusinessConfig = new BusinessConfig("biz_src_weather", "drawer_weather");
      this.m = QQPermissionFactory.a(this.d, localBusinessConfig);
    }
    this.m.a(i, 2, new QQSettingMeWeatherProcessor.3(this));
  }
  
  private void l()
  {
    if (!p()) {
      return;
    }
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new QQSettingMeWeatherProcessor.4(this, "qq_weather", false));
  }
  
  private long m()
  {
    return MobileQQ.getContext().getSharedPreferences("public_account_weather", 0).getLong("drawer_last_success_time", 0L);
  }
  
  private QQSettingMeWeatherBean n()
  {
    QQSettingMeWeatherBean localQQSettingMeWeatherBean = new QQSettingMeWeatherBean();
    localQQSettingMeWeatherBean.a = "- -";
    localQQSettingMeWeatherBean.b = "查看天气";
    localQQSettingMeWeatherBean.c = 0;
    localQQSettingMeWeatherBean.e = true;
    localQQSettingMeWeatherBean.f = true;
    this.a.setValue(localQQSettingMeWeatherBean);
    return localQQSettingMeWeatherBean;
  }
  
  private QQSettingMeWeatherBean o()
  {
    QQSettingMeWeatherBean localQQSettingMeWeatherBean = new QQSettingMeWeatherBean();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
    localQQSettingMeWeatherBean.a = localSharedPreferences.getString("drawer_cur_temp", "- -");
    localQQSettingMeWeatherBean.b = localSharedPreferences.getString("drawer_cur_city", "查看天气");
    localQQSettingMeWeatherBean.c = localSharedPreferences.getInt("drawer_cur_adcode", 0);
    localQQSettingMeWeatherBean.d = localSharedPreferences.getString("drawer_cur_code", null);
    localQQSettingMeWeatherBean.e = localSharedPreferences.getBoolean("drawer_show_flag", true);
    localQQSettingMeWeatherBean.f = false;
    return localQQSettingMeWeatherBean;
  }
  
  private boolean p()
  {
    return this.d.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.b.observe(this.e, new QQSettingMeWeatherProcessor.1(this, paramQQSettingMe));
    this.a.observe(this.e, new QQSettingMeWeatherProcessor.2(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.c = paramAppRuntime;
    this.j = ((IWeatherRuntimeService)((QQAppInterface)this.c).getRuntimeService(IWeatherRuntimeService.class));
    this.k = new QQSettingMeWeatherProcessor.QQSettingMeWeatherListener(this, null);
    this.j.setWeatherUpdateListener(this.k);
  }
  
  public String b()
  {
    return "d_weather";
  }
  
  public void d()
  {
    super.d();
    if (!this.l)
    {
      this.j = ((IWeatherRuntimeService)((QQAppInterface)this.c).getRuntimeService(IWeatherRuntimeService.class));
      this.k = new QQSettingMeWeatherProcessor.QQSettingMeWeatherListener(this, null);
      this.j.setWeatherUpdateListener(this.k);
      l();
      this.l = true;
    }
    try
    {
      if (((WindowManager)this.d.getSystemService("window")).getDefaultDisplay().getWidth() < 480)
      {
        this.b.setValue(Boolean.valueOf(true));
        return;
      }
      i();
      if (System.currentTimeMillis() - m() > 3600000L) {
        l();
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQSettingRedesign", 1, localThrowable, new Object[0]);
    }
    ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeather((QQAppInterface)this.c, "drawer_weather_expose");
    ReportController.b(this.c, "dc00898", "", "", "0X800A42B", "0X800A42B", 0, 0, "", "", "", "");
    int n = VipInfoHandler.a((QQAppInterface)this.c, this.c.getCurrentUin(), false);
    ReportController.b(this.c, "dc00898", "", "", "0X800B178", "0X800B178", 0, 0, String.valueOf(n), "", "", "");
  }
  
  public void f()
  {
    IWeatherRuntimeService localIWeatherRuntimeService = this.j;
    if (localIWeatherRuntimeService != null)
    {
      localIWeatherRuntimeService.setWeatherUpdateListener(null);
      this.j = null;
    }
  }
  
  public void i()
  {
    QQSettingMeWeatherBean localQQSettingMeWeatherBean;
    if (p()) {
      localQQSettingMeWeatherBean = o();
    } else {
      localQQSettingMeWeatherBean = n();
    }
    this.a.setValue(localQQSettingMeWeatherBean);
  }
  
  public void onClick(View paramView)
  {
    if (!p())
    {
      a();
      return;
    }
    int n = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getInt("cur_adcode", 0);
    ((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).startNewWeatherWebPageActivity(this.d, (QQAppInterface)this.c, false, "", true, String.valueOf(n));
    paramView = new StringBuilder();
    paramView.append("startNewWeatherWeb adCode = ");
    paramView.append(n);
    QLog.i("QQSettingRedesign", 1, paramView.toString());
    ((IWeatherReportApi)QRoute.api(IWeatherReportApi.class)).reportWeather((QQAppInterface)this.c, "drawer_weather_click");
    ReportController.b(this.c, "dc00898", "", "", "0X800A42C", "0X800A42C", 0, 0, "", "", "", "");
    ReportController.b(this.c, "CliOper", "", "", "0X8005BE4", "0X8005BE4", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeWeatherProcessor
 * JD-Core Version:    0.7.0.1
 */