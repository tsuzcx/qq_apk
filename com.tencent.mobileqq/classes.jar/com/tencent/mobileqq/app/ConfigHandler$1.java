package com.tencent.mobileqq.app;

import allq;
import bddq;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class ConfigHandler$1
  implements Runnable
{
  public ConfigHandler$1(allq paramallq, String paramString, long paramLong) {}
  
  public void run()
  {
    File localFile = new File(this.this$0.app.getApplication().getFilesDir(), "qq_safe_jump_whitelist.zip");
    String str = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
    int i = HttpDownloadUtil.a(this.this$0.app, str, localFile);
    if (QLog.isColorLevel()) {
      QLog.d("JumpWhiteList", 2, "handleJumpWhiteList download: " + i);
    }
    if (i == 0)
    {
      bddq.a().a(this.this$0.app, this.jdField_a_of_type_Long, localFile.getAbsolutePath());
      return;
    }
    bddq.a().a(this.this$0.app.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.1
 * JD-Core Version:    0.7.0.1
 */