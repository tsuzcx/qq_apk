package com.tencent.mobileqq.activity.qqsettingme;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeWeatherBean;
import com.tencent.mobileqq.weather.api.listener.WeatherUpdateListener;
import com.tencent.qphone.base.util.QLog;

class QQSettingMeWeatherProcessor$QQSettingMeWeatherListener
  implements WeatherUpdateListener
{
  private QQSettingMeWeatherProcessor$QQSettingMeWeatherListener(QQSettingMeWeatherProcessor paramQQSettingMeWeatherProcessor) {}
  
  public void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      QQSettingMeWeatherBean localQQSettingMeWeatherBean = new QQSettingMeWeatherBean();
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
      localQQSettingMeWeatherBean.e = paramBoolean;
      if (paramInt == 1)
      {
        localQQSettingMeWeatherBean.a = paramBundle.getString("KEY_TEMPER");
        localQQSettingMeWeatherBean.d = paramBundle.getString("o_wea_code");
        localQQSettingMeWeatherBean.b = paramBundle.getString("area_info");
        localQQSettingMeWeatherBean.c = paramBundle.getInt("adcode");
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, new Object[] { "onWeatherUpdateResult temp:", localQQSettingMeWeatherBean.a, " o_wea_code:", localQQSettingMeWeatherBean.d, " area_name:", localQQSettingMeWeatherBean.b, "adcode:", Integer.valueOf(localQQSettingMeWeatherBean.c) });
        }
        this.a.a.setValue(localQQSettingMeWeatherBean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeWeatherProcessor.QQSettingMeWeatherListener
 * JD-Core Version:    0.7.0.1
 */