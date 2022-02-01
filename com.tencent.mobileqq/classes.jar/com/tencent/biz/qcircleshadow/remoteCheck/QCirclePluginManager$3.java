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
    QLog.e("QCirclePluginManager", 1, "onDownloadFailed qcirle-pluginmanager.apk ");
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(2001L).setPluginVersion(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.version));
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String arg1, DownloadResult paramDownloadResult)
  {
    QLog.e("QCirclePluginManager", 1, "onDownloadSucceed qcirle-pluginmanager.apk ");
    ??? = new File(this.jdField_a_of_type_JavaLangString);
    if ((???.exists()) && (???.length() == this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.managerFilelength))
    {
      this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.pluginManagerPath = this.jdField_a_of_type_JavaLangString;
      String str2 = "";
      String str3 = "";
      String str1 = str3;
      ??? = str2;
      if (paramDownloadResult != null)
      {
        str1 = str3;
        ??? = str2;
        if (paramDownloadResult.getReport() != null)
        {
          ??? = String.valueOf(paramDownloadResult.getReport().fileSize);
          str1 = String.valueOf(paramDownloadResult.getReport().downloadTime);
        }
      }
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(2000L).setPluginVersion(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.version).setExt1(???).setExt2(str1));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.pluginZipPath)) {
        this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.isReady = true;
      }
      synchronized (QCirclePluginManager.a())
      {
        while (this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.isReady)
        {
          QCirclePluginManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager).delete(QCirclePluginInfo.class.getSimpleName(), null, null);
          this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.setStatus(1000);
          QCirclePluginManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager).persistOrReplace(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo);
          return;
          ??? = (QCirclePluginInfo)QCirclePluginManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager).find(QCirclePluginInfo.class, this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.version + "");
          if ((??? != null) && (???.pluginZipPath != null))
          {
            this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.pluginZipPath = ???.pluginZipPath;
            this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.isReady = true;
          }
        }
        QCirclePluginManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager).delete(QCirclePluginInfo.class.getSimpleName(), "version=?", new String[] { this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.version + "" });
      }
    }
    QLog.e("QCirclePluginManager", 1, "file.exists " + ???.exists() + "file.length()= " + ???.length() + " managefilerlength= " + this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.managerFilelength);
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(2002L).setPluginVersion(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.version));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager.3
 * JD-Core Version:    0.7.0.1
 */