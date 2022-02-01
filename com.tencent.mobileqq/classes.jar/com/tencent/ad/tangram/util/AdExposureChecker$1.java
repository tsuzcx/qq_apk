package com.tencent.ad.tangram.util;

import android.os.Handler;
import android.view.View;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import java.lang.ref.WeakReference;

class AdExposureChecker$1
  implements Runnable
{
  AdExposureChecker$1(AdExposureChecker paramAdExposureChecker) {}
  
  public void run()
  {
    if ((AdExposureChecker.access$100(this.this$0) == null) || (AdExposureChecker.access$100(this.this$0).get() == null) || (AdExposureChecker.access$200(this.this$0) == null) || (AdExposureChecker.access$300(this.this$0) == AdExposureChecker.c.CHECKING))
    {
      AdLog.e("AdExposureChecker", "startCheck: " + AdExposureChecker.access$300(this.this$0));
      return;
    }
    if (!AdExposureListHolder.getInstance().containsTraceIdForAnalysis(AdExposureChecker.access$200(this.this$0).getTraceId()))
    {
      AdReporterForAnalysis.reportForExposureApiInvoked(((View)AdExposureChecker.access$100(this.this$0).get()).getContext(), AdExposureChecker.access$200(this.this$0));
      AdExposureListHolder.getInstance().addTraceIdForAnalysis(AdExposureChecker.access$200(this.this$0).getTraceId());
    }
    AdExposureChecker.access$400(this.this$0, (View)AdExposureChecker.access$100(this.this$0).get());
    if (AdExposureChecker.access$500(this.this$0) == null) {
      AdExposureChecker.access$502(this.this$0, new AdExposureChecker.a(this.this$0, null));
    }
    AdExposureChecker.access$302(this.this$0, AdExposureChecker.c.CHECKING);
    AdExposureChecker.access$700(this.this$0).post(AdExposureChecker.access$500(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureChecker.1
 * JD-Core Version:    0.7.0.1
 */