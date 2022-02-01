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
    File localFile = new File(this.this$0.a.getApplication().getFilesDir(), "qq_safe_jump_whitelist.zip");
    String str = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
    int i = HttpDownloadUtil.downloadData(this.this$0.a, str, localFile);
    if (QLog.isColorLevel()) {
      QLog.d("JumpWhiteList", 2, "handleJumpWhiteList download: " + i);
    }
    if (i == 0)
    {
      JumpFilterHelper.a().a(this.this$0.a, this.jdField_a_of_type_Long, localFile.getAbsolutePath());
      return;
    }
    JumpFilterHelper.a().a(this.this$0.a.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.1
 * JD-Core Version:    0.7.0.1
 */