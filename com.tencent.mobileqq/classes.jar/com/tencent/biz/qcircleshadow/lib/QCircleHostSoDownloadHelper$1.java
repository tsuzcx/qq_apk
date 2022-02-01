package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.qcircle.tempapi.api.IQCirclrModuleDownloadListener;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;

final class QCircleHostSoDownloadHelper$1
  implements ModuleDownloadListener
{
  QCircleHostSoDownloadHelper$1(IQCirclrModuleDownloadListener paramIQCirclrModuleDownloadListener) {}
  
  public void onDownloadCanceled(String paramString)
  {
    this.val$listener.onDownloadCanceled(paramString);
  }
  
  public void onDownloadFailed(String paramString)
  {
    this.val$listener.onDownloadFailed(paramString);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat)
  {
    this.val$listener.onDownloadProgress(paramString, paramFloat);
  }
  
  public void onDownloadSucceed(String paramString)
  {
    this.val$listener.onDownloadSucceed(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostSoDownloadHelper.1
 * JD-Core Version:    0.7.0.1
 */