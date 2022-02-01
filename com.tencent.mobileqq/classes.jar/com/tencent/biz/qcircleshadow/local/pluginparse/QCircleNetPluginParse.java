package com.tencent.biz.qcircleshadow.local.pluginparse;

import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.biz.qcircleshadow.local.QCircleSampleInfo;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginInfo;
import com.tencent.mobileqq.qqcommon.api.IFileUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import java.io.File;

public class QCircleNetPluginParse
  extends QCircleBasePluginParse
{
  public QCircleNetPluginParse(String paramString, QCirclePluginInfo paramQCirclePluginInfo)
  {
    super(paramString, paramQCirclePluginInfo);
  }
  
  private void a(int paramInt)
  {
    QCirclePluginQualityReporter.ReportData localReportData = new QCirclePluginQualityReporter.ReportData();
    localReportData.setRetCode(paramInt).setPluginVersion(this.jdField_a_of_type_Int).setEvent_id("qcircle_plugin_load_result");
    localReportData.setPluginType("Q_CIRCLE_PLUGIN_NETWORK");
    QCirclePluginQualityReporter.report(localReportData);
  }
  
  private boolean a(QCircleSampleInfo paramQCircleSampleInfo)
  {
    if (paramQCircleSampleInfo == null) {
      return false;
    }
    if (paramQCircleSampleInfo.b() != this.jdField_a_of_type_Int)
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "parseNet#:version not match,config version:" + paramQCircleSampleInfo.b() + " netVersion:" + this.jdField_a_of_type_Int);
      a(2);
      return false;
    }
    if (paramQCircleSampleInfo.a() > QCircleHostConstants._AppSetting.getHostVersion())
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "parseNet#:version not match,host version too low supportMinHostVersion:" + paramQCircleSampleInfo.a() + " hostVersion:" + QCircleHostConstants._AppSetting.getHostVersion());
      a(4);
      return false;
    }
    return true;
  }
  
  private boolean a(QCirclePluginInfo paramQCirclePluginInfo)
  {
    if (paramQCirclePluginInfo == null) {
      return false;
    }
    if ((((IFileUtilsApi)QRoute.api(IFileUtilsApi.class)).fileExists(paramQCirclePluginInfo.pluginManagerPath)) && (((IFileUtilsApi)QRoute.api(IFileUtilsApi.class)).fileExists(paramQCirclePluginInfo.pluginZipPath)))
    {
      File localFile1 = new File(paramQCirclePluginInfo.pluginManagerPath);
      File localFile2 = new File(paramQCirclePluginInfo.pluginZipPath);
      if ((localFile1.length() == paramQCirclePluginInfo.managerFilelength) && (localFile2.length() == paramQCirclePluginInfo.zipFileLength))
      {
        QLog.i("QCIRCLE_PLUGIN", 1, "parseNet#fileLengthValid():true");
        return true;
      }
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "parseNet#fileLengthValid():false");
    return false;
  }
  
  private QCircleSampleInfo b()
  {
    String str1 = this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.pluginZipPath;
    String str2 = this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.pluginManagerPath;
    if ((!((IFileUtilsApi)QRoute.api(IFileUtilsApi.class)).fileExists(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.pluginZipPath)) || (!((IFileUtilsApi)QRoute.api(IFileUtilsApi.class)).fileExists(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo.pluginManagerPath)) || (!a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginInfo))) {
      return null;
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "parseNet#:net plugin has in folder");
    Object localObject = this.jdField_a_of_type_ComTencentBizQcircleshadowLocalPluginparseQCircleUnZip.a(new File(str1));
    if (!a((String)localObject, str1, "parseNet#")) {
      return null;
    }
    localObject = a(a(new File(this.jdField_a_of_type_ComTencentBizQcircleshadowLocalPluginparseQCircleUnZip.a((String)localObject, new File(str1)), "config.json").getAbsolutePath()));
    if (!a((QCircleSampleInfo)localObject)) {
      return null;
    }
    ((QCircleSampleInfo)localObject).d(this.e).a(str1).b(str2).b(this.jdField_a_of_type_Int);
    return localObject;
  }
  
  public QCircleSampleInfo a()
  {
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginparse.QCircleNetPluginParse
 * JD-Core Version:    0.7.0.1
 */