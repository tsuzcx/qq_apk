package com.tencent.ad.tangram.util;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import java.lang.ref.WeakReference;

class AdExposureChecker$a
  implements Runnable
{
  private int count = 0;
  
  private AdExposureChecker$a(AdExposureChecker paramAdExposureChecker) {}
  
  private boolean checkInternal()
  {
    AdLog.i("AdExposureChecker", "count:" + this.count + " status " + AdExposureChecker.access$300(this.this$0).hashCode() + " status: " + AdExposureChecker.access$300(this.this$0));
    if ((AdExposureChecker.access$200(this.this$0) != null) && (AdExposureListHolder.getInstance().inCheckedList(AdExposureChecker.access$200(this.this$0).getTraceId()))) {
      AdLog.e("AdExposureChecker", "trace id is already exposured " + AdExposureChecker.access$200(this.this$0).getTraceId());
    }
    for (;;)
    {
      AdExposureChecker.access$1400(this.this$0);
      AdExposureChecker.access$302(this.this$0, AdExposureChecker.c.END);
      return false;
      if ((AdExposureChecker.access$100(this.this$0) == null) || (AdExposureChecker.access$100(this.this$0).get() == null) || (AdExposureChecker.access$1100(this.this$0)) || (!AdExposureChecker.access$800(this.this$0)) || (AdExposureChecker.access$1600(this.this$0) == null) || (AdExposureChecker.access$1600(this.this$0).get() == null) || (AdExposureChecker.access$300(this.this$0) != AdExposureChecker.c.CHECKING))
      {
        localObject = new StringBuilder().append("check failed : isViewDestroyed ").append(AdExposureChecker.access$1100(this.this$0)).append(" isViewOnForeground ").append(AdExposureChecker.access$800(this.this$0)).append(" status ").append(AdExposureChecker.access$300(this.this$0)).append(" no callback :");
        if ((AdExposureChecker.access$1600(this.this$0) == null) || (AdExposureChecker.access$1600(this.this$0).get() == null)) {}
        for (boolean bool = true;; bool = false)
        {
          AdLog.e("AdExposureChecker", bool);
          break;
        }
      }
      if (((View)AdExposureChecker.access$100(this.this$0).get()).isShown()) {
        break;
      }
      AdLog.e("AdExposureChecker", "!mViewRef.get().isShown()");
    }
    if (!AdExposureChecker.access$1700((View)AdExposureChecker.access$100(this.this$0).get()))
    {
      this.count = 0;
      return false;
    }
    Context localContext;
    AdExposureListHolder localAdExposureListHolder;
    if (this.count >= 1000L / AdExposureChecker.access$1500(this.this$0))
    {
      localContext = ((View)AdExposureChecker.access$100(this.this$0).get()).getContext();
      localAdExposureListHolder = AdExposureListHolder.getInstance();
      if (AdExposureChecker.access$200(this.this$0) == null) {
        break label530;
      }
    }
    label530:
    for (Object localObject = AdExposureChecker.access$200(this.this$0).getTraceId();; localObject = null)
    {
      localAdExposureListHolder.putExternalReportData(localContext, (String)localObject);
      ((AdExposureChecker.ExposureCallback)AdExposureChecker.access$1600(this.this$0).get()).onExposure(AdExposureChecker.access$100(this.this$0));
      AdExposureChecker.access$302(this.this$0, AdExposureChecker.c.CHECKED);
      AdReporterForAnalysis.reportForExposureCallback(localContext, AdExposureChecker.access$200(this.this$0), 0);
      AdLog.d("AdExposureChecker", "exposure success stop check");
      AdExposureChecker.access$1400(this.this$0);
      this.count += 1;
      return true;
    }
  }
  
  public void run()
  {
    checkInternal();
    AdExposureChecker.access$700(this.this$0).postDelayed(AdExposureChecker.access$500(this.this$0), AdExposureChecker.access$1500(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureChecker.a
 * JD-Core Version:    0.7.0.1
 */