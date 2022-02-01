package com.tencent.biz.qcircleshadow.remoteCheck;

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
    QCircleFlutterPluginQualityReporter.report(new QCircleFlutterPluginQualityReporter.ReportData().setEvent_id("flutter_preload").setRetCode(i).setFlutterPluginVersion(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.version).setCheckCode(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.salt).setMd5(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.zipFileMD5).setUrl(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.zipFileUrl));
    QLog.e("QCirclePluginManager", 1, "onDownloadSucceed qcirle-flutter-plugin.zip ");
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String arg1, DownloadResult paramDownloadResult)
  {
    QLog.e("QCirclePluginManager", 1, "onDownloadSucceed qcirle-flutter-plugin.zip ");
    ??? = new File(this.jdField_a_of_type_JavaLangString);
    if ((???.exists()) && (???.length() == this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.zipFileLength))
    {
      ??? = new QCircleFlutterPluginQualityReporter.ReportData().setEvent_id("flutter_preload").setRetCode(0L).setFlutterPluginVersion(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.version).setCheckCode(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.salt).setMd5(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.zipFileMD5).setUrl(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.zipFileUrl);
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append(System.currentTimeMillis() - QCirclePluginManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager));
      paramDownloadResult.append("");
      QCircleFlutterPluginQualityReporter.report(???.setTimeCost(paramDownloadResult.toString()));
      this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.pluginZipPath = this.jdField_a_of_type_JavaLangString;
      synchronized (QCirclePluginManager.a())
      {
        QCirclePluginManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager).delete(QCircleFlutterPluginInfo.class.getSimpleName(), null, null);
        this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.setStatus(1000);
        QCirclePluginManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager).persistOrReplace(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo);
        return;
      }
    }
    QCircleFlutterPluginQualityReporter.report(new QCircleFlutterPluginQualityReporter.ReportData().setEvent_id("flutter_preload").setRetCode(1002L).setFlutterPluginVersion(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.version).setCheckCode(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.salt).setMd5(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.zipFileMD5).setUrl(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.zipFileUrl));
    paramDownloadResult = new StringBuilder();
    paramDownloadResult.append("file.exists ");
    paramDownloadResult.append(???.exists());
    paramDownloadResult.append("file.length()= ");
    paramDownloadResult.append(???.length());
    paramDownloadResult.append(" zipFileMD5= ");
    paramDownloadResult.append(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleFlutterPluginInfo.zipFileMD5);
    QLog.e("QCirclePluginManager", 1, paramDownloadResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager.2
 * JD-Core Version:    0.7.0.1
 */