package com.tencent.mobileqq.app;

import com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigHelper;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import protocol.KQQConfig.GetResourceRespInfo;

class ConfigHandler$7
  implements Runnable
{
  ConfigHandler$7(ConfigHandler paramConfigHandler, GetResourceRespInfo paramGetResourceRespInfo, String paramString, long paramLong) {}
  
  public void run()
  {
    if (!ConfigHandler.a(this.this$0, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.strPkgName, 10000L)) {
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions dpc aio_eggs is false");
      }
    }
    do
    {
      return;
      File localFile = new File(this.this$0.a.getApplication().getFilesDir(), "eggs_config.zip");
      String str = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
      int i = HttpDownloadUtil.downloadData(this.this$0.a, str, localFile);
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions download: " + i);
      }
      if (i == 0)
      {
        AioAnimationConfigHelper.a().a(this.this$0.a, this.jdField_a_of_type_Long, localFile.getAbsolutePath());
        return;
      }
    } while (AioAnimationConfigHelper.a().a() != null);
    AioAnimationConfigHelper.a().a(this.this$0.a.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.7
 * JD-Core Version:    0.7.0.1
 */