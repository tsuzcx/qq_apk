package com.tencent.biz.qcircleshadow.local.pluginselector;

import com.tencent.biz.qcircleshadow.local.QCirclePluginUpdater;
import com.tencent.biz.qcircleshadow.local.QCircleSampleInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;

public class QCirclePluginSelectorNetProcess
  extends QCircleBaseSelectorProcess
{
  QCircleSampleInfo a;
  QCircleSampleInfo b;
  
  public QCirclePluginSelectorNetProcess(QCircleSampleInfo paramQCircleSampleInfo1, QCircleSampleInfo paramQCircleSampleInfo2)
  {
    this.a = paramQCircleSampleInfo1;
    this.b = paramQCircleSampleInfo2;
  }
  
  private QCirclePluginUpdater a(QCircleSampleInfo paramQCircleSampleInfo1, QCircleSampleInfo paramQCircleSampleInfo2)
  {
    a("qcircle_net_compare_begin", 0);
    if (paramQCircleSampleInfo1.b() <= paramQCircleSampleInfo2.b())
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginSelectorNetProcess#checkNet():net plugin version:" + paramQCircleSampleInfo1.b() + " lower then asset, go to checkAsset");
      a("qcircle_net_compare_asset", 1);
      return null;
    }
    return a(paramQCircleSampleInfo1, false);
  }
  
  private QCirclePluginUpdater a(QCircleSampleInfo paramQCircleSampleInfo, boolean paramBoolean)
  {
    if (paramBoolean) {
      a("qcircle_net_compare_begin", 0);
    }
    if (!a(paramQCircleSampleInfo.b()))
    {
      a("qcircle_net_crash_max", 1);
      QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginSelectorNetProcess#checkNet():net plugin version:" + paramQCircleSampleInfo.b() + " crash too many, go to checkAsset");
      return null;
    }
    if (paramQCircleSampleInfo.b() < 8050500)
    {
      a("qcircle_net_compare_minversion", 1);
      QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginSelectorNetProcess#checkNet():net plugin version:" + paramQCircleSampleInfo.b() + " mini not support, go to checkAsset");
      return null;
    }
    a("qcircle_net_check_success", 0);
    StringBuilder localStringBuilder = new StringBuilder().append("QCirclePluginSelectorNetProcess#checkNet():use netWork plugin, net version:").append(paramQCircleSampleInfo.b()).append(" asset version:");
    if (this.b != null) {}
    for (Object localObject = Integer.valueOf(this.b.b());; localObject = " ")
    {
      QLog.i("QCIRCLE_PLUGIN", 1, localObject + " MiniSupportVersion" + 8050500);
      return new QCirclePluginUpdater(paramQCircleSampleInfo);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    QCirclePluginQualityReporter.ReportData localReportData;
    if (this.a != null)
    {
      localReportData = new QCirclePluginQualityReporter.ReportData().setEvent_id(paramString).setPluginType("Q_CIRCLE_PLUGIN_NETWORK").setPluginVersion(this.a.b());
      if (this.b == null) {
        break label70;
      }
    }
    label70:
    for (paramString = Integer.valueOf(this.b.b());; paramString = "")
    {
      QCirclePluginQualityReporter.report(localReportData.setExt1(String.valueOf(paramString)).setRetCode(paramInt));
      return;
    }
  }
  
  public QCirclePluginUpdater a()
  {
    if (this.a == null) {
      return null;
    }
    if (this.b != null) {
      return a(this.a, this.b);
    }
    return a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginselector.QCirclePluginSelectorNetProcess
 * JD-Core Version:    0.7.0.1
 */