package com.tencent.mobileqq.app;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.JumpFilterHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class ConfigHandler$1
  implements Runnable
{
  ConfigHandler$1(ConfigHandler paramConfigHandler, String paramString, long paramLong) {}
  
  public void run()
  {
    File localFile = new File(this.this$0.c.getApplication().getFilesDir(), "qq_safe_jump_whitelist.zip");
    Object localObject = MsfSdkUtils.insertMtype("ConfigCheck", this.a);
    int i = HttpDownloadUtil.downloadData(this.this$0.c, (String)localObject, localFile);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleJumpWhiteList download: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("JumpWhiteList", 2, ((StringBuilder)localObject).toString());
    }
    if (i == 0)
    {
      JumpFilterHelper.b().a(this.this$0.c, this.b, localFile.getAbsolutePath());
      return;
    }
    JumpFilterHelper.b().a(this.this$0.c.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.1
 * JD-Core Version:    0.7.0.1
 */