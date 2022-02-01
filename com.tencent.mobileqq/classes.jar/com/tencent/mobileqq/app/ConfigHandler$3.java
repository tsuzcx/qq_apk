package com.tencent.mobileqq.app;

import com.tencent.mobileqq.activity.weather.WeatherManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class ConfigHandler$3
  implements Runnable
{
  ConfigHandler$3(ConfigHandler paramConfigHandler, String paramString, WeatherManager paramWeatherManager, long paramLong) {}
  
  public void run()
  {
    boolean bool = false;
    File localFile = new File(this.this$0.a.getApplication().getFilesDir(), "WeatherResource.zip");
    String str = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
    int i = HttpDownloadUtil.downloadData(this.this$0.a, str, localFile);
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "handleWeatherResources download: " + i + ",downloadpath" + localFile.getAbsolutePath());
    }
    if (i == 0) {
      bool = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager.a(this.jdField_a_of_type_Long, localFile.getAbsolutePath());
    }
    this.this$0.notifyUI(9, bool, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.3
 * JD-Core Version:    0.7.0.1
 */