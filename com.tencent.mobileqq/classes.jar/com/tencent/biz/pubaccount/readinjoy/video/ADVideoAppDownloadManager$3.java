package com.tencent.biz.pubaccount.readinjoy.video;

import aatc;
import bfkr;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import noy;
import qyj;

class ADVideoAppDownloadManager$3
  implements Runnable
{
  ADVideoAppDownloadManager$3(ADVideoAppDownloadManager paramADVideoAppDownloadManager, qyj paramqyj) {}
  
  public void run()
  {
    if (noy.a(ADVideoAppDownloadManager.a(this.this$0), this.a.d))
    {
      QLog.d("ADVideoAppDownloadManager", 1, "already installed." + this.a.d);
      this.this$0.a(this.a, 1, 100);
    }
    do
    {
      int i;
      do
      {
        return;
        if (ADVideoAppDownloadManager.a(this.this$0, ADVideoAppDownloadManager.a(this.this$0), this.a))
        {
          QLog.d("ADVideoAppDownloadManager", 1, "already finishDownload." + this.a.d);
          this.this$0.a(this.a, 5, 100);
          DownloadInfo localDownloadInfo = bfkr.a().c(this.a.a);
          bfkr.a().a(localDownloadInfo);
          return;
        }
        i = ADVideoAppDownloadManager.a(this.this$0, ADVideoAppDownloadManager.a(this.this$0), this.a);
        if (i < 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ADVideoAppDownloadManager", 2, "isPkgDownloading.isPkgDownloading." + this.a.d + " " + i);
      return;
      if (aatc.a())
      {
        this.this$0.a(this.a, 0);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ADVideoAppDownloadManager", 2, "initDownloadApp DOWNLOAD_NONE.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */