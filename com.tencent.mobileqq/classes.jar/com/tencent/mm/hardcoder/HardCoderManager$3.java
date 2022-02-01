package com.tencent.mm.hardcoder;

import acjl;
import acjp;
import bhzn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class HardCoderManager$3
  implements Runnable
{
  public HardCoderManager$3(acjp paramacjp, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QLog.d("HardCoder.QQManager", 1, "start download");
    File localFile = new File(acjl.b + "_tmp");
    int i = HttpDownloadUtil.downloadData(this.a, "https://qd.myapp.com/myapp/qqteam/qq_tools/libhc4.jpg", localFile);
    if (i == 0) {
      if ((localFile.exists()) && ("5c08438266c3084212bb9307aa7c2aaa".equalsIgnoreCase(bhzn.a(localFile))))
      {
        localFile.renameTo(new File(acjl.b));
        acjp.a(this.this$0, 6);
      }
    }
    for (;;)
    {
      localFile = new File(acjl.a);
      if (localFile.exists()) {
        localFile.delete();
      }
      QLog.d("HardCoder.QQManager", 1, "downloadResult = " + i + ", state = " + acjp.a(this.this$0));
      return;
      QLog.d("HardCoder.QQManager", 1, "check md5 fail");
      localFile.delete();
      acjp.a(this.this$0, 5);
      continue;
      acjp.a(this.this$0, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HardCoderManager.3
 * JD-Core Version:    0.7.0.1
 */