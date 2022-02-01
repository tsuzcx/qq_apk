package com.tencent.mobileqq.apollo.game.process.download;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class CmGameRscDownloader$4
  extends DownloadListener
{
  CmGameRscDownloader$4(CmGameRscDownloader paramCmGameRscDownloader) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onDone], status:");
    localStringBuilder.append(paramDownloadTask.e());
    QLog.i("cmgame_process.CmGameRscDownloader", 2, localStringBuilder.toString());
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask != null)
    {
      if (CmGameRscDownloader.a(this.a) == null) {
        return;
      }
      if (paramDownloadTask.e() != 3)
      {
        CmGameRscDownloader.a(this.a, 2);
        if (CmGameRscDownloader.c(this.a) != null) {
          CmGameRscDownloader.c(this.a).d(-1005, CmGameRscDownloader.a(this.a).i);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("downLoad game res fail retCode: ");
        localStringBuilder.append(paramDownloadTask.e());
        QLog.e("cmgame_process.CmGameRscDownloader", 1, localStringBuilder.toString());
        return;
      }
      CmGameRscDownloader.b(this.a);
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    int i = (int)paramDownloadTask.l;
    if (CmGameRscDownloader.c(this.a) != null) {
      CmGameRscDownloader.c(this.a).a(i, CmGameRscDownloader.a(this.a).g, CmGameRscDownloader.a(this.a).i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.download.CmGameRscDownloader.4
 * JD-Core Version:    0.7.0.1
 */