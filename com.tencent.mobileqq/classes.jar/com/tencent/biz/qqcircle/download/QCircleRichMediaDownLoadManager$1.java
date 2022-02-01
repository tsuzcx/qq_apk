package com.tencent.biz.qqcircle.download;

import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.qphone.base.util.QLog;

class QCircleRichMediaDownLoadManager$1
  implements Runnable
{
  QCircleRichMediaDownLoadManager$1(QCircleRichMediaDownLoadManager paramQCircleRichMediaDownLoadManager, QCircleRichMediaDownLoadManager.DownLoadParams paramDownLoadParams) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QCircleRichMediaDownLoadManager.c());
    localStringBuilder.append(".nomedia");
    HostFileUtils.createFileIfNotExits(localStringBuilder.toString());
    if (HostFileUtils.fileExists(this.a.b()))
    {
      if (QCircleRichMediaDownLoadManager.DownLoadParams.a(this.a) != null) {
        QCircleRichMediaDownLoadManager.DownLoadParams.a(this.a).a(true);
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.a());
      localStringBuilder.append(",download file is existed ");
      QLog.d("QCircleRichMediaDownLoadManager", 1, localStringBuilder.toString());
      return;
    }
    if (HostFileUtils.fileExists(this.a.c()))
    {
      if (!QCircleRichMediaDownLoadManager.a(this.this$0, this.a)) {
        QCircleRichMediaDownLoadManager.b(this.this$0, this.a);
      }
    }
    else {
      QCircleRichMediaDownLoadManager.b(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.1
 * JD-Core Version:    0.7.0.1
 */