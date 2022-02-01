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
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadCanceled(this.jdField_a_of_type_JavaLangString);
    }
    VSEntranceWidgetDownLoadHelper.DownLoadStatus.a(this.jdField_a_of_type_ComTencentBizVideostoryEntrancewidgetVSEntranceWidgetDownLoadHelper$DownLoadStatus, 3);
    QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "onDownloadCanceled" });
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask.a == 0)
    {
      boolean bool;
      if (new File(VSEntranceWidgetDownLoadHelper.jdField_a_of_type_JavaLangString).exists())
      {
        bool = FileUtils.unzip(new File(this.jdField_a_of_type_JavaLangString), new File(VSEntranceWidgetDownLoadHelper.jdField_a_of_type_JavaLangString + "/" + this.b));
        if (!bool) {
          break label158;
        }
        if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
          this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadSucceed(this.jdField_a_of_type_JavaLangString, new DownloadResult(this.c));
        }
        new File(this.jdField_a_of_type_JavaLangString).delete();
        VSEntranceWidgetDownLoadHelper.DownLoadStatus.a(this.jdField_a_of_type_ComTencentBizVideostoryEntrancewidgetVSEntranceWidgetDownLoadHelper$DownLoadStatus, 0);
      }
      for (;;)
      {
        QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByIdsuccess:" + bool);
        return;
        label158:
        VSEntranceWidgetDownLoadHelper.DownLoadStatus.a(this.jdField_a_of_type_ComTencentBizVideostoryEntrancewidgetVSEntranceWidgetDownLoadHelper$DownLoadStatus, 2);
      }
    }
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadFailed(this.jdField_a_of_type_JavaLangString, new DownloadResult(this.c));
    }
    VSEntranceWidgetDownLoadHelper.DownLoadStatus.a(this.jdField_a_of_type_ComTencentBizVideostoryEntrancewidgetVSEntranceWidgetDownLoadHelper$DownLoadStatus, 2);
    QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByIdonDownloadFailed:" });
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener.onDownloadProgress(this.jdField_a_of_type_JavaLangString, 0L, 0.0F);
    }
    VSEntranceWidgetDownLoadHelper.DownLoadStatus.a(this.jdField_a_of_type_ComTencentBizVideostoryEntrancewidgetVSEntranceWidgetDownLoadHelper$DownLoadStatus, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.entrancewidget.VSEntranceWidgetDownLoadHelper.1
 * JD-Core Version:    0.7.0.1
 */