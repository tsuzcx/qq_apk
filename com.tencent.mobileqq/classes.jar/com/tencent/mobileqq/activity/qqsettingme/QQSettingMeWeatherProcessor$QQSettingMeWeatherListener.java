package com.tencent.mobileqq.activity.qqsettingme;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeWeatherBean;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.weather.api.listener.WeatherUpdateListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class QQSettingMeWeatherProcessor$QQSettingMeWeatherListener
  implements WeatherUpdateListener
{
  private QQSettingMeWeatherProcessor$QQSettingMeWeatherListener(QQSettingMeWeatherProcessor paramQQSettingMeWeatherProcessor) {}
  
  public void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = new QQSettingMeWeatherBean();
      paramInt = paramBundle.getInt("show_flag");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onWeatherUpdateResult show_flag:");
        localStringBuilder.append(paramInt);
        QLog.d("QQSettingRedesign", 2, localStringBuilder.toString());
      }
      if (paramInt != 0) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((QQSettingMeWeatherBean)localObject).jdField_a_of_type_Boolean = paramBoolean;
      if (paramInt == 1)
      {
        ((QQSettingMeWeatherBean)localObject).jdField_a_of_type_JavaLangString = paramBundle.getString("KEY_TEMPER");
        ((QQSettingMeWeatherBean)localObject).c = paramBundle.getString("o_wea_code");
        ((QQSettingMeWeatherBean)localObject).b = paramBundle.getString("area_info");
        ((QQSettingMeWeatherBean)localObject).jdField_a_of_type_Int = paramBundle.getInt("adcode");
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, new Object[] { "onWeatherUpdateResult temp:", ((QQSettingMeWeatherBean)localObject).jdField_a_of_type_JavaLangString, " o_wea_code:", ((QQSettingMeWeatherBean)localObject).c, " area_name:", ((QQSettingMeWeatherBean)localObject).b, "adcode:", Integer.valueOf(((QQSettingMeWeatherBean)localObject).jdField_a_of_type_Int) });
        }
        this.a.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(localObject);
      }
    }
    else
    {
      int i = paramBundle.getInt("uint32_result");
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onWeatherUpdateResult resultCode:");
        paramBundle.append(i);
        QLog.d("QQSettingRedesign", 2, paramBundle.toString());
      }
      if ((paramInt == 6666) && (i == 191005))
      {
        if (Build.VERSION.SDK_INT < 23)
        {
          QQSettingMeWeatherProcessor.a(this.a);
          return;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
        {
          QQSettingMeWeatherProcessor.a(this.a);
          return;
        }
        paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("apollo_sp");
        ((StringBuilder)localObject).append(this.a.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
        paramBundle = paramBundle.getSharedPreferences(((StringBuilder)localObject).toString(), 0);
        long l = paramBundle.getLong("sp_key_request_permission", 0L);
        if (NetConnInfoCenter.getServerTime() - l < 86400L)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQSettingRedesign", 2, "User requestPermissions but has requested in 24 h");
          }
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.requestPermissions(new QQSettingMeWeatherProcessor.QQSettingMeWeatherListener.1(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        paramBundle.edit().putLong("sp_key_request_permission", NetConnInfoCenter.getServerTime()).commit();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeWeatherProcessor.QQSettingMeWeatherListener
 * JD-Core Version:    0.7.0.1
 */