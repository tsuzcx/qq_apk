package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;

public class ArResourceDownload$DownloadTask
  extends AbsPreDownloadTask
{
  ArResourceDownload.DownloadInfo a;
  ArResourceDownload b;
  
  public ArResourceDownload$DownloadTask(QQAppInterface paramQQAppInterface, ArResourceDownload.DownloadInfo paramDownloadInfo, ArResourceDownload paramArResourceDownload)
  {
    super(paramQQAppInterface, paramDownloadInfo.c);
    this.a = paramDownloadInfo;
    this.b = paramArResourceDownload;
  }
  
  protected void realCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceDownload", 2, "DownloadTask realCancel");
    }
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceDownload", 2, "DownloadTask realStart");
    }
    ArResourceDownload.a(this.b, this.a);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DownloadTask] mInfo=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mDownloader=");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArResourceDownload.DownloadTask
 * JD-Core Version:    0.7.0.1
 */