package com.tencent.mm.hardcoder;

import bcdt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import zrn;
import zrr;

public class HardCoderManager$3
  implements Runnable
{
  public HardCoderManager$3(zrr paramzrr, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QLog.d("HardCoder.QQManager", 1, "start download");
    File localFile = new File(zrn.b + "_tmp");
    int i = HttpDownloadUtil.a(this.a, "http://sqdd.myapp.com/myapp/qqteam/qq_tools/libhc4.jpg", localFile);
    if (i == 0) {
      if ((localFile.exists()) && ("5c08438266c3084212bb9307aa7c2aaa".equalsIgnoreCase(bcdt.a(localFile))))
      {
        localFile.renameTo(new File(zrn.b));
        zrr.a(this.this$0, 6);
      }
    }
    for (;;)
    {
      localFile = new File(zrn.a);
      if (localFile.exists()) {
        localFile.delete();
      }
      QLog.d("HardCoder.QQManager", 1, "downloadResult = " + i + ", state = " + zrr.a(this.this$0));
      return;
      QLog.d("HardCoder.QQManager", 1, "check md5 fail");
      localFile.delete();
      zrr.a(this.this$0, 5);
      continue;
      zrr.a(this.this$0, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HardCoderManager.3
 * JD-Core Version:    0.7.0.1
 */