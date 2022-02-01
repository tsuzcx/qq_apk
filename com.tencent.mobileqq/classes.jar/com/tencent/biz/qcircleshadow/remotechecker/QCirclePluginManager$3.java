package com.tencent.biz.qcircleshadow.remotechecker;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import java.io.File;

class QCirclePluginManager$3
  implements Downloader.DownloadListener
{
  QCirclePluginManager$3(QCirclePluginManager paramQCirclePluginManager, QCirclePluginInfo paramQCirclePluginInfo, String paramString) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.e("QCirclePluginManager", 1, "onDownloadFailed qcirle-pluginmanager.apk ");
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEventId("qcircle_plugin_download").setRetCode(2001L).setPluginVersion(this.a.version));
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    QLog.e("QCirclePluginManager", 1, "onDownloadSucceed qcirle-pluginmanager.apk ");
    paramString = new File(this.b);
    if ((paramString.exists()) && (paramString.length() == this.a.managerFilelength))
    {
      QCirclePluginManager.a(this.c, paramDownloadResult, this.a, this.b);
      return;
    }
    paramDownloadResult = new StringBuilder();
    paramDownloadResult.append("file.exists ");
    paramDownloadResult.append(paramString.exists());
    paramDownloadResult.append("file.length()= ");
    paramDownloadResult.append(paramString.length());
    paramDownloadResult.append(" managefilerlength= ");
    paramDownloadResult.append(this.a.managerFilelength);
    QLog.e("QCirclePluginManager", 1, paramDownloadResult.toString());
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEventId("qcircle_plugin_download").setRetCode(2002L).setPluginVersion(this.a.version));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remotechecker.QCirclePluginManager.3
 * JD-Core Version:    0.7.0.1
 */