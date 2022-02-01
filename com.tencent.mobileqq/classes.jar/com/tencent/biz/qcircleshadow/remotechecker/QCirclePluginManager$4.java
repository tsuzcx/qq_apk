package com.tencent.biz.qcircleshadow.remotechecker;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import java.io.File;

class QCirclePluginManager$4
  implements Downloader.DownloadListener
{
  QCirclePluginManager$4(QCirclePluginManager paramQCirclePluginManager, QCirclePluginInfo paramQCirclePluginInfo, String paramString) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEventId("qcircle_plugin_download").setRetCode(1001L).setPluginVersion(this.a.version));
    QLog.e("QCirclePluginManager", 1, "onDownloadFailed qcirle-plugin.zip ");
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.e("QCirclePluginManager", 1, "onDownloadSucceed qcirle-plugin.zip ");
    paramString = new File(this.b);
    if ((paramString.exists()) && (paramString.length() == this.a.zipFileLength))
    {
      QCirclePluginManager.b(this.c, paramDownloadResult, this.a, this.b);
      return;
    }
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEventId("qcircle_plugin_download").setRetCode(1002L).setPluginVersion(this.a.version));
    paramDownloadResult = new StringBuilder();
    paramDownloadResult.append("file.exists ");
    paramDownloadResult.append(paramString.exists());
    paramDownloadResult.append("file.length()= ");
    paramDownloadResult.append(paramString.length());
    paramDownloadResult.append(" zipFileLength= ");
    paramDownloadResult.append(this.a.zipFileLength);
    QLog.e("QCirclePluginManager", 1, paramDownloadResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remotechecker.QCirclePluginManager.4
 * JD-Core Version:    0.7.0.1
 */