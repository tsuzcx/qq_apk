package com.tencent.biz.pubaccount.readinjoy.view.proteus.utils;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ProteusCDNUtils$1
  implements Runnable
{
  ProteusCDNUtils$1(String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    File localFile = new File(this.a);
    if (localFile.exists())
    {
      FileUtils.e(this.a);
      QLog.i("ProteusCDNUtils", 1, "[downloadByCDN], bid = " + this.b + ", delete old compressFile, path = " + this.a);
    }
    boolean bool = HttpDownloadUtil.download(null, this.c, localFile);
    QLog.i("ProteusCDNUtils", 1, "[downloadByCDN], bid = " + this.b + ", isDownloadSucc = " + bool);
    if (bool)
    {
      ProteusCDNUtils.a(this.b);
      return;
    }
    ProteusCDNUtils.b("0X800AC00", this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.ProteusCDNUtils.1
 * JD-Core Version:    0.7.0.1
 */