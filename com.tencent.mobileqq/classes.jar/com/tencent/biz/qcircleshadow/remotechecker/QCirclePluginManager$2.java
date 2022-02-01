package com.tencent.biz.qcircleshadow.remotechecker;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleFlutterPluginQualityReporter;
import cooperation.qqcircle.report.QCircleFlutterPluginQualityReporter.ReportData;
import java.io.File;

class QCirclePluginManager$2
  implements Downloader.DownloadListener
{
  QCirclePluginManager$2(QCirclePluginManager paramQCirclePluginManager, QCircleFlutterPluginInfo paramQCircleFlutterPluginInfo, String paramString) {}
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    int i;
    if ((paramDownloadResult != null) && (paramDownloadResult.getStatus() != null)) {
      i = paramDownloadResult.getStatus().failReason;
    } else {
      i = 0;
    }
    QCircleFlutterPluginQualityReporter.report(new QCircleFlutterPluginQualityReporter.ReportData().setEventId("flutter_preload").setRetCode(i).setFlutterPluginVersion(this.a.version).setCheckCode(this.a.salt).setMd5(this.a.zipFileMD5).setUrl(this.a.zipFileUrl));
    QLog.e("QCirclePluginManager", 1, "onDownloadSucceed qcirle-flutter-plugin.zip ");
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String arg1, DownloadResult paramDownloadResult)
  {
    QLog.e("QCirclePluginManager", 1, "onDownloadSucceed qcirle-flutter-plugin.zip ");
    ??? = new File(this.b);
    if ((???.exists()) && (???.length() == this.a.zipFileLength))
    {
      ??? = new QCircleFlutterPluginQualityReporter.ReportData().setEventId("flutter_preload").setRetCode(0L).setFlutterPluginVersion(this.a.version).setCheckCode(this.a.salt).setMd5(this.a.zipFileMD5).setUrl(this.a.zipFileUrl);
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append(System.currentTimeMillis() - QCirclePluginManager.a(this.c));
      paramDownloadResult.append("");
      QCircleFlutterPluginQualityReporter.report(???.setTimeCost(paramDownloadResult.toString()));
      this.a.pluginZipPath = this.b;
      synchronized (QCirclePluginManager.c())
      {
        QCirclePluginManager.b(this.c).delete(QCircleFlutterPluginInfo.class.getSimpleName(), null, null);
        this.a.setStatus(1000);
        QCirclePluginManager.b(this.c).persistOrReplace(this.a);
        return;
      }
    }
    QCircleFlutterPluginQualityReporter.report(new QCircleFlutterPluginQualityReporter.ReportData().setEventId("flutter_preload").setRetCode(1002L).setFlutterPluginVersion(this.a.version).setCheckCode(this.a.salt).setMd5(this.a.zipFileMD5).setUrl(this.a.zipFileUrl));
    paramDownloadResult = new StringBuilder();
    paramDownloadResult.append("file.exists ");
    paramDownloadResult.append(???.exists());
    paramDownloadResult.append("file.length()= ");
    paramDownloadResult.append(???.length());
    paramDownloadResult.append(" zipFileMD5= ");
    paramDownloadResult.append(this.a.zipFileMD5);
    QLog.e("QCirclePluginManager", 1, paramDownloadResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remotechecker.QCirclePluginManager.2
 * JD-Core Version:    0.7.0.1
 */