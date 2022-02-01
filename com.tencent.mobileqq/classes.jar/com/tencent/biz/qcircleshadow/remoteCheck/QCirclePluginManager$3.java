package com.tencent.biz.qcircleshadow.remoteCheck;

import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.persistence.EntityManager;
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
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(1001L).setPluginVersion(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.version));
    QLog.e("QCirclePluginManager", 1, "onDownloadFailed qcirle-plugin.zip ");
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String arg1, DownloadResult paramDownloadResult)
  {
    QLog.e("QCirclePluginManager", 1, "onDownloadSucceed qcirle-plugin.zip ");
    ??? = new File(this.jdField_a_of_type_JavaLangString);
    if ((???.exists()) && (???.length() == this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.zipFileLength))
    {
      if ((paramDownloadResult != null) && (paramDownloadResult.getReport() != null))
      {
        ??? = String.valueOf(paramDownloadResult.getReport().fileSize);
        paramDownloadResult = String.valueOf(paramDownloadResult.getReport().downloadTime);
      }
      else
      {
        ??? = "";
        paramDownloadResult = "";
      }
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(1000L).setPluginVersion(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.version).setExt1(???).setExt2(paramDownloadResult));
      ??? = this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo;
      ???.pluginZipPath = this.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(???.pluginManagerPath))
      {
        this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.isReady = true;
      }
      else
      {
        ??? = QCirclePluginManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager);
        paramDownloadResult = new StringBuilder();
        paramDownloadResult.append(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.version);
        paramDownloadResult.append("");
        ??? = (QCirclePluginInfo)???.find(QCirclePluginInfo.class, paramDownloadResult.toString());
        if ((??? != null) && (???.pluginManagerPath != null))
        {
          this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.pluginManagerPath = ???.pluginManagerPath;
          this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.isReady = true;
        }
      }
      synchronized (QCirclePluginManager.b())
      {
        if (this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.isReady)
        {
          QCirclePluginManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager).delete(QCirclePluginInfo.class.getSimpleName(), null, null);
        }
        else
        {
          paramDownloadResult = QCirclePluginManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager);
          String str = QCirclePluginInfo.class.getSimpleName();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.version);
          localStringBuilder.append("");
          paramDownloadResult.delete(str, "version=?", new String[] { localStringBuilder.toString() });
        }
        this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.setStatus(1000);
        QCirclePluginManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager).persistOrReplace(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo);
        return;
      }
    }
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(1002L).setPluginVersion(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.version));
    paramDownloadResult = new StringBuilder();
    paramDownloadResult.append("file.exists ");
    paramDownloadResult.append(???.exists());
    paramDownloadResult.append("file.length()= ");
    paramDownloadResult.append(???.length());
    paramDownloadResult.append(" zipFileLength= ");
    paramDownloadResult.append(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.zipFileLength);
    QLog.e("QCirclePluginManager", 1, paramDownloadResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager.3
 * JD-Core Version:    0.7.0.1
 */