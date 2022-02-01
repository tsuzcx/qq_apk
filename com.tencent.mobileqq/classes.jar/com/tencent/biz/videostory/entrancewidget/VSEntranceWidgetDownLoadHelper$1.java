package com.tencent.biz.videostory.entrancewidget;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;

class VSEntranceWidgetDownLoadHelper$1
  extends DownloadListener
{
  VSEntranceWidgetDownLoadHelper$1(VSEntranceWidgetDownLoadHelper paramVSEntranceWidgetDownLoadHelper, Downloader.DownloadListener paramDownloadListener, String paramString1, VSEntranceWidgetDownLoadHelper.DownLoadStatus paramDownLoadStatus, String paramString2, String paramString3) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    paramDownloadTask = this.a;
    if (paramDownloadTask != null) {
      paramDownloadTask.onDownloadCanceled(this.b);
    }
    VSEntranceWidgetDownLoadHelper.DownLoadStatus.a(this.c, 3);
    QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "onDownloadCanceled" });
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask.c == 0)
    {
      if (new File(VSEntranceWidgetDownLoadHelper.a).exists())
      {
        paramDownloadTask = new File(this.b);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(VSEntranceWidgetDownLoadHelper.a);
        localStringBuilder.append("/");
        localStringBuilder.append(this.d);
        boolean bool = FileUtils.unzip(paramDownloadTask, new File(localStringBuilder.toString()));
        if (bool)
        {
          paramDownloadTask = this.a;
          if (paramDownloadTask != null) {
            paramDownloadTask.onDownloadSucceed(this.b, new DownloadResult(this.e));
          }
          new File(this.b).delete();
          VSEntranceWidgetDownLoadHelper.DownLoadStatus.a(this.c, 0);
        }
        else
        {
          VSEntranceWidgetDownLoadHelper.DownLoadStatus.a(this.c, 2);
        }
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("downLoadByIdsuccess:");
        paramDownloadTask.append(bool);
        QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, paramDownloadTask.toString());
      }
    }
    else
    {
      paramDownloadTask = this.a;
      if (paramDownloadTask != null) {
        paramDownloadTask.onDownloadFailed(this.b, new DownloadResult(this.e));
      }
      VSEntranceWidgetDownLoadHelper.DownLoadStatus.a(this.c, 2);
      QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByIdonDownloadFailed:" });
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    paramDownloadTask = this.a;
    if (paramDownloadTask != null) {
      paramDownloadTask.onDownloadProgress(this.b, 0L, 0.0F);
    }
    VSEntranceWidgetDownLoadHelper.DownLoadStatus.a(this.c, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.entrancewidget.VSEntranceWidgetDownLoadHelper.1
 * JD-Core Version:    0.7.0.1
 */