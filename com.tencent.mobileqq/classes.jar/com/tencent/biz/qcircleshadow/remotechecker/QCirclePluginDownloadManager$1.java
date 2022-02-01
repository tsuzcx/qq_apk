package com.tencent.biz.qcircleshadow.remotechecker;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import java.util.Vector;

class QCirclePluginDownloadManager$1
  implements Downloader.DownloadListener
{
  QCirclePluginDownloadManager$1(QCirclePluginDownloadManager paramQCirclePluginDownloadManager, QCirclePluginDownloadManager.DownloadEnty paramDownloadEnty) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QCirclePluginDownloadManager.a(this.b, false);
    if (QCirclePluginDownloadManager.a(this.b).size() > 0)
    {
      QCirclePluginDownloadManager.DownloadEnty localDownloadEnty = (QCirclePluginDownloadManager.DownloadEnty)QCirclePluginDownloadManager.a(this.b).get(0);
      QCirclePluginDownloadManager.a(this.b).remove(0);
      QCirclePluginDownloadManager.a(this.b, localDownloadEnty);
    }
    if (this.a.e != null) {
      this.a.e.onDownloadCanceled(paramString);
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QCirclePluginDownloadManager.a(this.b, false);
    if (QCirclePluginDownloadManager.a(this.b).size() > 0)
    {
      QCirclePluginDownloadManager.DownloadEnty localDownloadEnty = (QCirclePluginDownloadManager.DownloadEnty)QCirclePluginDownloadManager.a(this.b).get(0);
      QCirclePluginDownloadManager.a(this.b).remove(0);
      QCirclePluginDownloadManager.a(this.b, localDownloadEnty);
    }
    if (this.a.e != null) {
      this.a.e.onDownloadFailed(paramString, paramDownloadResult);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    if (this.a.e != null) {
      this.a.e.onDownloadProgress(paramString, paramLong, paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QCirclePluginDownloadManager.a(this.b, false);
    if (QCirclePluginDownloadManager.a(this.b).size() > 0)
    {
      QCirclePluginDownloadManager.DownloadEnty localDownloadEnty = (QCirclePluginDownloadManager.DownloadEnty)QCirclePluginDownloadManager.a(this.b).get(0);
      QCirclePluginDownloadManager.a(this.b).remove(0);
      QCirclePluginDownloadManager.a(this.b, localDownloadEnty);
    }
    if (this.a.e != null) {
      this.a.e.onDownloadSucceed(paramString, paramDownloadResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remotechecker.QCirclePluginDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */