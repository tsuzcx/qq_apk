package com.tencent.biz.videostory.entrancewidget;

import com.tencent.biz.videostory.config.processor.VSEntranceWidgetBean;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;

class VSEntranceWidgetHelper$2
  implements Downloader.DownloadListener
{
  VSEntranceWidgetHelper$2(VSEntranceWidgetHelper paramVSEntranceWidgetHelper, VSEntranceWidgetBean paramVSEntranceWidgetBean, String paramString) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult) {}
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    VSEntranceWidgetHelper.a(this.c, this.a, VSEntranceWidgetDownLoadHelper.a().e(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.entrancewidget.VSEntranceWidgetHelper.2
 * JD-Core Version:    0.7.0.1
 */