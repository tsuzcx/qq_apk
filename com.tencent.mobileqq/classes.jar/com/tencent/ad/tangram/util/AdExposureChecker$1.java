package com.tencent.ad.tangram.util;

import android.os.Handler;
import android.view.View;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import java.lang.ref.WeakReference;

class AdExposureChecker$1
  implements Runnable
{
  AdExposureChecker$1(AdExposureChecker paramAdExposureChecker) {}
  
  public void run()
  {
    if ((AdExposureChecker.access$100(this.this$0) != null) && (AdExposureChecker.access$100(this.this$0).get() != null) && (AdExposureChecker.access$200(this.this$0) != null) && (AdExposureChecker.access$300(this.this$0) != AdExposureChecker.c.CHECKING))
    {
      if (!AdExposureListHolder.getInstance().containsTraceIdForAnalysis(AdExposureChecker.access$200(this.this$0).getTraceId()))
      {
        AdAnalysisHelperForUtil.reportForExposureApiInvoked(((View)AdExposureChecker.access$100(this.this$0).get()).getContext(), AdExposureChecker.access$200(this.this$0));
        AdExposureListHolder.getInstance().addTraceIdForAnalysis(AdExposureChecker.access$200(this.this$0).getTraceId());
      }
      localObject = this.this$0;
      AdExposureChecker.access$400((AdExposureChecker)localObject, (View)AdExposureChecker.access$100((AdExposureChecker)localObject).get());
      if (AdExposureChecker.access$500(this.this$0) == null)
      {
        localObject = this.this$0;
        AdExposureChecker.access$502((AdExposureChecker)localObject, new AdExposureChecker.a((AdExposureChecker)localObject, null));
      }
      AdExposureChecker.access$302(this.this$0, AdExposureChecker.c.CHECKING);
      AdExposureChecker.access$700(this.this$0).post(AdExposureChecker.access$500(this.this$0));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startCheck: ");
    ((StringBuilder)localObject).append(AdExposureChecker.access$300(this.this$0));
    AdLog.e("AdExposureChecker", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureChecker.1
 * JD-Core Version:    0.7.0.1
 */