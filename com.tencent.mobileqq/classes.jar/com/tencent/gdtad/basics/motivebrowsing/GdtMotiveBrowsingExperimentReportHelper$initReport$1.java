package com.tencent.gdtad.basics.motivebrowsing;

import com.tencent.gdtad.log.GdtLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GdtMotiveBrowsingExperimentReportHelper$initReport$1
  implements Runnable
{
  GdtMotiveBrowsingExperimentReportHelper$initReport$1(GdtMotiveBrowsingExperimentReportHelper paramGdtMotiveBrowsingExperimentReportHelper, GdtMotiveBrowsingExperimentReportHelper.ReportCallback paramReportCallback) {}
  
  public final void run()
  {
    GdtMotiveBrowsingExperimentReportHelper.ReportCallback localReportCallback = this.a;
    if (localReportCallback != null) {
      localReportCallback.a("gdtmsg://e.qq.com/reportExposureRewardAd/rewardAD", this.this$0.b());
    }
    GdtLog.b("GdtMotiveBrowsingExperimentReportHelper", "report expose");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingExperimentReportHelper.initReport.1
 * JD-Core Version:    0.7.0.1
 */