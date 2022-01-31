package com.tencent.mobileqq.app;

import aeqc;
import allq;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConfigHandler$7
  implements Runnable
{
  public ConfigHandler$7(allq paramallq, GetResourceRespInfo paramGetResourceRespInfo, String paramString, long paramLong) {}
  
  public void run()
  {
    if (!allq.a(this.this$0, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.strPkgName, 10000L)) {
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions dpc aio_eggs is false");
      }
    }
    do
    {
      return;
      File localFile = new File(this.this$0.app.getApplication().getFilesDir(), "eggs_config.zip");
      String str = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
      int i = HttpDownloadUtil.a(this.this$0.app, str, localFile);
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions download: " + i);
      }
      if (i == 0)
      {
        aeqc.a().a(this.this$0.app, this.jdField_a_of_type_Long, localFile.getAbsolutePath());
        return;
      }
    } while (aeqc.a().a() != null);
    aeqc.a().a(this.this$0.app.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.7
 * JD-Core Version:    0.7.0.1
 */