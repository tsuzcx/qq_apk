package com.tencent.mm.hardcoder;

import abrz;
import absd;
import bfhh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class HardCoderManager$3
  implements Runnable
{
  public HardCoderManager$3(absd paramabsd, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QLog.d("HardCoder.QQManager", 1, "start download");
    File localFile = new File(abrz.b + "_tmp");
    int i = HttpDownloadUtil.a(this.a, "http://sqdd.myapp.com/myapp/qqteam/qq_tools/libhc4.jpg", localFile);
    if (i == 0) {
      if ((localFile.exists()) && ("5c08438266c3084212bb9307aa7c2aaa".equalsIgnoreCase(bfhh.a(localFile))))
      {
        localFile.renameTo(new File(abrz.b));
        absd.a(this.this$0, 6);
      }
    }
    for (;;)
    {
      localFile = new File(abrz.a);
      if (localFile.exists()) {
        localFile.delete();
      }
      QLog.d("HardCoder.QQManager", 1, "downloadResult = " + i + ", state = " + absd.a(this.this$0));
      return;
      QLog.d("HardCoder.QQManager", 1, "check md5 fail");
      localFile.delete();
      absd.a(this.this$0, 5);
      continue;
      absd.a(this.this$0, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HardCoderManager.3
 * JD-Core Version:    0.7.0.1
 */