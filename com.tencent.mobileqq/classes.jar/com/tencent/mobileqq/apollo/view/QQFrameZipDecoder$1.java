package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class QQFrameZipDecoder$1
  extends DownloadListener
{
  QQFrameZipDecoder$1(QQFrameZipDecoder paramQQFrameZipDecoder, String paramString1, String paramString2, String paramString3) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject;
    if (3 == paramDownloadTask.e())
    {
      this.d.a(true, this.a, this.b, this.c);
    }
    else
    {
      localObject = this.d;
      ((QQFrameZipDecoder)localObject).c = 2;
      ((QQFrameZipDecoder)localObject).a(false, this.a, this.b, this.c);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadZip onDone task.getStatus()->");
      ((StringBuilder)localObject).append(paramDownloadTask.e());
      QLog.d("[cmshow]SimpleFrameZipDecoder", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.QQFrameZipDecoder.1
 * JD-Core Version:    0.7.0.1
 */