package com.tencent.biz.qcircleshadow.lib;

import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class QCirclePluginTrace$1
  implements Runnable
{
  QCirclePluginTrace$1(QCirclePluginTrace paramQCirclePluginTrace, long paramLong, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = QCirclePluginTrace.access$000(this.this$0).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      long l = ((Long)QCirclePluginTrace.access$000(this.this$0).remove(str)).longValue();
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id(str).setPluginVersion(this.val$pluginVersion).setPluginType(this.val$pluginType).setTimeCost(String.valueOf(l)).setExt1(String.valueOf(this.val$hasPreload)));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("flush  trace:");
      localStringBuilder.append(str);
      localStringBuilder.append(", time cost:");
      localStringBuilder.append(l);
      localStringBuilder.append(", has preload:");
      localStringBuilder.append(this.val$hasPreload);
      QLog.d("QCirclePluginLoadTrace", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCirclePluginTrace.1
 * JD-Core Version:    0.7.0.1
 */