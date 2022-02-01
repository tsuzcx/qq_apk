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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HCPerfManager.getSoPath());
    ((StringBuilder)localObject).append("_tmp");
    localObject = new File(((StringBuilder)localObject).toString());
    int i = HttpDownloadUtil.downloadData(MobileQQ.sMobileQQ.waitAppRuntime(null), HardCoderManager.getSoUrl(), (File)localObject);
    if (i == 0)
    {
      if ((((File)localObject).exists()) && (HCPerfManager.getSoMd5().equalsIgnoreCase(MD5.a((File)localObject))))
      {
        ((File)localObject).renameTo(new File(HCPerfManager.getSoPath()));
        HardCoderManager.access$202(this.this$0, 6);
      }
      else
      {
        QLog.d("HardCoder.QQManager", 1, "check md5 fail");
        ((File)localObject).delete();
        HardCoderManager.access$202(this.this$0, 5);
      }
    }
    else {
      HardCoderManager.access$202(this.this$0, 5);
    }
    localObject = new File(HCPerfManager.SO_PATH_OLD);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downloadResult = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", state = ");
    ((StringBuilder)localObject).append(HardCoderManager.access$200(this.this$0));
    QLog.d("HardCoder.QQManager", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HardCoderManager.3
 * JD-Core Version:    0.7.0.1
 */