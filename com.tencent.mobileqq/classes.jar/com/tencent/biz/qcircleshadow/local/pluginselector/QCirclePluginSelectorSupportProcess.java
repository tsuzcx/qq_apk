package com.tencent.biz.qcircleshadow.local.pluginselector;

import android.os.Build.VERSION;
import com.tencent.biz.qcircleshadow.local.QCirclePluginUpdater;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;

public class QCirclePluginSelectorSupportProcess
  extends QCircleBaseSelectorProcess
{
  private boolean a()
  {
    if (Build.VERSION.SDK_INT > 16)
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginSelectorPreProcess#isUnSupport():false");
      return false;
    }
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_system_unsupport"));
    QLog.i("QCIRCLE_PLUGIN", 1, "QCirclePluginSelectorPreProcess#isUnSupport():true");
    return true;
  }
  
  public QCirclePluginUpdater a()
  {
    if (a()) {
      return new QCirclePluginUpdater(null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginselector.QCirclePluginSelectorSupportProcess
 * JD-Core Version:    0.7.0.1
 */