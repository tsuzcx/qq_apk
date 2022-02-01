package com.tencent.biz.qcircleshadow.local.pluginselector;

import com.tencent.biz.qcircleshadow.local.QCirclePluginUpdater;
import com.tencent.biz.qcircleshadow.local.QCircleSampleInfo;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;

public class QCirclePluginSelectorWnsProcess
  extends QCircleBaseSelectorProcess
{
  private QCircleSampleInfo a;
  
  public QCirclePluginSelectorWnsProcess(QCircleSampleInfo paramQCircleSampleInfo)
  {
    this.a = paramQCircleSampleInfo;
  }
  
  private QCirclePluginUpdater a(QCircleSampleInfo paramQCircleSampleInfo)
  {
    if (QCircleConfigHelper.a())
    {
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_wns_load_asset").setPluginType("Q_CIRCLE_PLUGIN_ASSET").setPluginVersion(paramQCircleSampleInfo.b()));
      QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginSelectorWnsProcess#checkWNS():WNS force use asset true");
      return new QCirclePluginUpdater(paramQCircleSampleInfo);
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginSelectorWnsProcess#checkWNS():WNS force use asset false");
    return null;
  }
  
  public QCirclePluginUpdater a()
  {
    return a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginselector.QCirclePluginSelectorWnsProcess
 * JD-Core Version:    0.7.0.1
 */