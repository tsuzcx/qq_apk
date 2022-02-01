package com.tencent.biz.qcircleshadow.local.pluginselector;

import com.tencent.biz.qcircleshadow.local.QCirclePluginUpdater;
import com.tencent.biz.qcircleshadow.local.QCircleSampleInfo;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qcircle.cooperation.config.QCircleSpUtil;
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
      paramQCircleSampleInfo2 = new StringBuilder();
      paramQCircleSampleInfo2.append("QCirclePluginSelectorNetProcess#checkNet():net plugin version:");
      paramQCircleSampleInfo2.append(paramQCircleSampleInfo1.b());
      paramQCircleSampleInfo2.append(" lower then asset, go to checkAsset");
      QLog.i("QCIRCLE_PLUGIN", 1, paramQCircleSampleInfo2.toString());
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QCirclePluginSelectorNetProcess#checkNet():net plugin version:");
      ((StringBuilder)localObject).append(paramQCircleSampleInfo.b());
      ((StringBuilder)localObject).append(" crash too many, go to checkAsset");
      QLog.i("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    if (paramQCircleSampleInfo.b() < 80700)
    {
      a("qcircle_net_compare_minversion", 1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QCirclePluginSelectorNetProcess#checkNet():net plugin version:");
      ((StringBuilder)localObject).append(paramQCircleSampleInfo.b());
      ((StringBuilder)localObject).append(" mini not support, go to checkAsset");
      QLog.i("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    a("qcircle_net_check_success", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCirclePluginSelectorNetProcess#checkNet():use netWork plugin, net version:");
    localStringBuilder.append(paramQCircleSampleInfo.b());
    localStringBuilder.append(" asset version:");
    Object localObject = this.b;
    if (localObject != null) {
      localObject = Integer.valueOf(((QCircleSampleInfo)localObject).b());
    } else {
      localObject = " ";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(" MiniSupportVersion");
    localStringBuilder.append(80700);
    QLog.i("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
    return new QCirclePluginUpdater(paramQCircleSampleInfo);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.a != null)
    {
      QCirclePluginQualityReporter.ReportData localReportData = new QCirclePluginQualityReporter.ReportData().setEvent_id(paramString).setPluginType("Q_CIRCLE_PLUGIN_NETWORK").setPluginVersion(this.a.b());
      paramString = this.b;
      if (paramString != null) {
        paramString = Integer.valueOf(paramString.b());
      } else {
        paramString = "";
      }
      QCirclePluginQualityReporter.report(localReportData.setExt1(String.valueOf(paramString)).setRetCode(paramInt));
    }
  }
  
  private boolean a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("SP_KEY_ENTER_PLUGIN_VERSION_PRFIX_");
    ((StringBuilder)localObject1).append(this.a.b());
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = Integer.valueOf(0);
    int i = ((Integer)QCircleSpUtil.a((String)localObject2, localObject1)).intValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCirclePluginSelectorNetProcess#hasNeverEnterSplash() key:");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(" value:");
    localStringBuilder.append(i);
    QLog.i("QCIRCLE_PLUGIN", 1, localStringBuilder.toString());
    if (i > 0) {
      return false;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("SP_KEY_START_PLUGIN_VERSION_PRFIX_");
    ((StringBuilder)localObject2).append(this.a.b());
    localObject2 = ((StringBuilder)localObject2).toString();
    int j = ((Integer)QCircleSpUtil.a((String)localObject2, localObject1)).intValue();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("QCirclePluginSelectorNetProcess#hasNeverEnterSplash() key:");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(" value:");
    ((StringBuilder)localObject1).append(j);
    QLog.i("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject1).toString());
    if (j - i >= QCircleConfigHelper.c())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QCirclePluginSelectorNetProcess#hasNeverEnterSplash():");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(i);
      QLog.i("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject1).toString());
      return true;
    }
    return false;
  }
  
  public QCirclePluginUpdater a()
  {
    if (this.a == null) {
      return null;
    }
    if (a())
    {
      QCirclePluginManager.a().a(this.a.b());
      return null;
    }
    QCircleSampleInfo localQCircleSampleInfo = this.b;
    if (localQCircleSampleInfo != null) {
      return a(this.a, localQCircleSampleInfo);
    }
    return a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginselector.QCirclePluginSelectorNetProcess
 * JD-Core Version:    0.7.0.1
 */