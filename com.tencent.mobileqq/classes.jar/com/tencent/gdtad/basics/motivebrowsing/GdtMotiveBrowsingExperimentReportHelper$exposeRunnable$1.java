package com.tencent.gdtad.basics.motivebrowsing;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GdtMotiveBrowsingExperimentReportHelper$exposeRunnable$1
  implements Runnable
{
  GdtMotiveBrowsingExperimentReportHelper$exposeRunnable$1(GdtMotiveBrowsingExperimentReportHelper paramGdtMotiveBrowsingExperimentReportHelper) {}
  
  public final void run()
  {
    GdtMotiveBrowsingExperimentReportHelper.ReportCallback localReportCallback = this.this$0.a();
    if (localReportCallback != null) {
      localReportCallback.a("gdtmsg://e.qq.com/reportExposureRewardAd/rewardAD", this.this$0.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingExperimentReportHelper.exposeRunnable.1
 * JD-Core Version:    0.7.0.1
 */