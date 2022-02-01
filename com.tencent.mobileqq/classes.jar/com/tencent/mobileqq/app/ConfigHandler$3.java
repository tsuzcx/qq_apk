package com.tencent.mobileqq.app;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.weather.api.IWeatherRuntimeService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class ConfigHandler$3
  implements Runnable
{
  ConfigHandler$3(ConfigHandler paramConfigHandler, String paramString, IWeatherRuntimeService paramIWeatherRuntimeService, long paramLong) {}
  
  public void run()
  {
    File localFile = new File(this.this$0.a.getApplication().getFilesDir(), "WeatherResource.zip");
    Object localObject = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
    int i = HttpDownloadUtil.downloadData(this.this$0.a, (String)localObject, localFile);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleWeatherResources download: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",downloadpath");
      ((StringBuilder)localObject).append(localFile.getAbsolutePath());
      QLog.d("qq_weather", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool;
    if (i == 0) {
      bool = this.jdField_a_of_type_ComTencentMobileqqWeatherApiIWeatherRuntimeService.unzipResource(this.jdField_a_of_type_Long, localFile.getAbsolutePath());
    } else {
      bool = false;
    }
    this.this$0.notifyUI(9, bool, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.3
 * JD-Core Version:    0.7.0.1
 */