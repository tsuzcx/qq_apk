package com.tencent.biz.qqcircle.publish.uploader;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

class QcircleUploadSoDownloader$1
  implements Runnable
{
  QcircleUploadSoDownloader$1(QcircleUploadSoDownloader paramQcircleUploadSoDownloader) {}
  
  public void run()
  {
    boolean bool = QcircleUploadSoDownloader.a(this.this$0, QcircleUploadSoDownloader.b().getAbsolutePath());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("check so md5 result: ");
    localStringBuilder.append(bool);
    QLog.d("[upload2]QcircleUploadSoDownloader", 1, localStringBuilder.toString());
    if (bool)
    {
      QcircleUploadSoDownloader.a(true);
      return;
    }
    try
    {
      if (QcircleUploadSoDownloader.b().exists()) {
        QcircleUploadSoDownloader.b().delete();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    QcircleUploadSoDownloader.a(this.this$0, false);
    QcircleUploadSoDownloader.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.uploader.QcircleUploadSoDownloader.1
 * JD-Core Version:    0.7.0.1
 */