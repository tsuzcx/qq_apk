package com.tencent.mobileqq.activity.weather;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;

public class WeatherManager
  implements Manager, BusinessObserver
{
  public static String a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private WeatherManager.WeatherUpdaterListener jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager$WeatherUpdaterListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public WeatherManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = BaseApplicationImpl.getContext();
    jdField_a_of_type_JavaLangString = paramQQAppInterface.getFilesDir().getAbsoluteFile() + File.separator + "WeatherResource";
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("weather_resources", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
  }
  
  public long a()
  {
    long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_weather_res_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "getConfigVersion version=" + l);
    }
    return l;
  }
  
  public void a()
  {
    Long localLong = Long.valueOf(BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getLong("pa_send_time", 0L));
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "updateWeatherInfo successTime:" + localLong + ",currentTime:" + System.currentTimeMillis());
    }
    if (Math.abs(System.currentTimeMillis() - localLong.longValue()) > 3600000L) {
      WeatherServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "updateResourceVersion version=" + paramLong);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_weather_res_version", paramLong).commit();
  }
  
  public void a(WeatherManager.WeatherUpdaterListener paramWeatherUpdaterListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager$WeatherUpdaterListener = paramWeatherUpdaterListener;
  }
  
  public boolean a(long paramLong, String paramString)
  {
    boolean bool = true;
    try
    {
      FileUtils.a(jdField_a_of_type_JavaLangString, false);
      FileUtils.a(paramString, jdField_a_of_type_JavaLangString, false);
      if (bool)
      {
        a(paramLong);
        return bool;
      }
    }
    catch (Exception paramString)
    {
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("weatherManager", 2, "pareseRulesFromZip : delete and uncompress Exception=>", paramString);
          }
          bool = false;
        }
      } while (!QLog.isColorLevel());
      QLog.d("weatherManager", 2, "pareseRulesFromZip : delete and uncompressZip failure, parse from Res");
    }
    return bool;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("weatherManager", 2, new Object[] { "WeatherManager onReceive type:" + paramInt, ",bundle:", paramBundle });
      }
    } while ((paramInt != 6666) && (paramInt != 8888));
    int i;
    SharedPreferences.Editor localEditor;
    if (paramBoolean)
    {
      String str1 = paramBundle.getString("KEY_TEMPER");
      String str2 = paramBundle.getString("area_name");
      String str3 = paramBundle.getString("o_wea_code");
      i = paramBundle.getInt("show_flag");
      if (QLog.isColorLevel()) {
        QLog.d("weatherManager", 2, "onReceive show_flag:" + i + ",temp:" + str1 + ",area_name" + str2 + ",o_wea_code" + str3);
      }
      localEditor = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).edit();
      if (i != 1) {
        break label310;
      }
      if ((str1 != null) && (!str1.equals("")) && (str2 != null) && (!str2.equals("")))
      {
        localEditor.putLong("pa_send_time", Long.valueOf(System.currentTimeMillis()).longValue());
        localEditor.putString("cur_temp", str1);
        localEditor.putString("cur_code", str3);
        localEditor.putString("cur_city", str2);
        localEditor.putBoolean("show_flag", true);
      }
    }
    for (;;)
    {
      localEditor.commit();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager$WeatherUpdaterListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager$WeatherUpdaterListener.a(paramInt, paramBoolean, paramBundle);
      return;
      label310:
      if (i == 0) {
        localEditor.putBoolean("show_flag", false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.WeatherManager
 * JD-Core Version:    0.7.0.1
 */