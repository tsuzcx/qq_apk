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
    if (!ConfigHandler.a(this.this$0, this.a.strPkgName, 10000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions dpc aio_eggs is false");
      }
      return;
    }
    File localFile = new File(this.this$0.c.getApplication().getFilesDir(), "eggs_config.zip");
    Object localObject = MsfSdkUtils.insertMtype("ConfigCheck", this.b);
    int i = HttpDownloadUtil.downloadData(this.this$0.c, (String)localObject, localFile);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleUpdateEggsActions download: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("eggs", 2, ((StringBuilder)localObject).toString());
    }
    if (i == 0)
    {
      AioAnimationConfigHelper.a().a(this.this$0.c, this.c, localFile.getAbsolutePath());
      return;
    }
    if (AioAnimationConfigHelper.a().b() == null) {
      AioAnimationConfigHelper.a().a(this.this$0.c.getApplication());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.7
 * JD-Core Version:    0.7.0.1
 */