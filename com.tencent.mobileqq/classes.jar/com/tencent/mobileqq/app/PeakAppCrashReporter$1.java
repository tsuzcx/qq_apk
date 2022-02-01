package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

class PeakAppCrashReporter$1
  implements Runnable
{
  PeakAppCrashReporter$1(PeakAppCrashReporter paramPeakAppCrashReporter, long paramLong, String paramString) {}
  
  public void run()
  {
    QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.E_PEAK_CRASH_PATHINFO, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("ext1", String.valueOf(this.a)), QCircleReportHelper.newEntry("ext2", this.b) }));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPeakAppCreated, reportCrashReportInfo, reportEntry = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", reportExtraInfo = ");
    localStringBuilder.append(this.b);
    QLog.d("PeakAppCrashReporter", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppCrashReporter.1
 * JD-Core Version:    0.7.0.1
 */