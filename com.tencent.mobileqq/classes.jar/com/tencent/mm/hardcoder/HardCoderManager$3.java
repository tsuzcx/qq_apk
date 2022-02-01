package com.tencent.mm.hardcoder;

import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

class HardCoderManager$3
  implements Runnable
{
  HardCoderManager$3(HardCoderManager paramHardCoderManager) {}
  
  public void run()
  {
    QLog.d("HardCoder.QQManager", 1, "start download");
    File localFile = new File(HCPerfManager.b + "_tmp");
    int i = HttpDownloadUtil.downloadData(MobileQQ.sMobileQQ.waitAppRuntime(null), "https://qd.myapp.com/myapp/qqteam/qq_tools/libhc4.jpg", localFile);
    if (i == 0) {
      if ((localFile.exists()) && ("5c08438266c3084212bb9307aa7c2aaa".equalsIgnoreCase(MD5.a(localFile))))
      {
        localFile.renameTo(new File(HCPerfManager.b));
        HardCoderManager.a(this.this$0, 6);
      }
    }
    for (;;)
    {
      localFile = new File(HCPerfManager.a);
      if (localFile.exists()) {
        localFile.delete();
      }
      QLog.d("HardCoder.QQManager", 1, "downloadResult = " + i + ", state = " + HardCoderManager.a(this.this$0));
      return;
      QLog.d("HardCoder.QQManager", 1, "check md5 fail");
      localFile.delete();
      HardCoderManager.a(this.this$0, 5);
      continue;
      HardCoderManager.a(this.this$0, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HardCoderManager.3
 * JD-Core Version:    0.7.0.1
 */