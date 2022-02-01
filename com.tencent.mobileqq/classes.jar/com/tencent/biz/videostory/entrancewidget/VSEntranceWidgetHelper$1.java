package com.tencent.biz.videostory.entrancewidget;

import com.tencent.biz.videostory.config.processor.VSEntranceStyleBean;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;

class VSEntranceWidgetHelper$1
  implements Downloader.DownloadListener
{
  VSEntranceWidgetHelper$1(VSEntranceWidgetHelper paramVSEntranceWidgetHelper, VSEntranceStyleBean paramVSEntranceStyleBean, String paramString) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult) {}
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    VSEntranceWidgetHelper.a(this.jdField_a_of_type_ComTencentBizVideostoryEntrancewidgetVSEntranceWidgetHelper, this.jdField_a_of_type_ComTencentBizVideostoryConfigProcessorVSEntranceStyleBean, VSEntranceWidgetDownLoadHelper.a().b(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.entrancewidget.VSEntranceWidgetHelper.1
 * JD-Core Version:    0.7.0.1
 */