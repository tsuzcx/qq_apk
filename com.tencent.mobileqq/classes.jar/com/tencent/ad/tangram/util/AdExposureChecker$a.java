package com.tencent.ad.tangram.util;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import java.lang.ref.WeakReference;

class AdExposureChecker$a
  implements Runnable
{
  private int count = 0;
  
  private AdExposureChecker$a(AdExposureChecker paramAdExposureChecker) {}
  
  private boolean checkInternal()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("count:");
    ((StringBuilder)localObject).append(this.count);
    ((StringBuilder)localObject).append(" status ");
    ((StringBuilder)localObject).append(AdExposureChecker.access$300(this.this$0).hashCode());
    ((StringBuilder)localObject).append(" status: ");
    ((StringBuilder)localObject).append(AdExposureChecker.access$300(this.this$0));
    AdLog.i("AdExposureChecker", ((StringBuilder)localObject).toString());
    if ((AdExposureChecker.access$200(this.this$0) != null) && (AdExposureListHolder.getInstance().inCheckedList(AdExposureChecker.access$200(this.this$0).getTraceId())))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("trace id is already exposured ");
      ((StringBuilder)localObject).append(AdExposureChecker.access$200(this.this$0).getTraceId());
      AdLog.e("AdExposureChecker", ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = AdExposureChecker.access$100(this.this$0);
      boolean bool2 = true;
      if ((localObject != null) && (AdExposureChecker.access$100(this.this$0).get() != null) && (!AdExposureChecker.access$1100(this.this$0)) && (AdExposureChecker.access$800(this.this$0)) && (AdExposureChecker.access$1600(this.this$0) != null) && (AdExposureChecker.access$1600(this.this$0).get() != null) && (AdExposureChecker.access$300(this.this$0) == AdExposureChecker.c.CHECKING))
      {
        if (!((View)AdExposureChecker.access$100(this.this$0).get()).isShown())
        {
          AdLog.e("AdExposureChecker", "!mViewRef.get().isShown()");
        }
        else
        {
          if (!AdExposureChecker.access$1700((View)AdExposureChecker.access$100(this.this$0).get()))
          {
            this.count = 0;
            return false;
          }
          if (this.count >= 1000L / AdExposureChecker.access$1500(this.this$0))
          {
            Context localContext = ((View)AdExposureChecker.access$100(this.this$0).get()).getContext();
            AdExposureListHolder localAdExposureListHolder = AdExposureListHolder.getInstance();
            if (AdExposureChecker.access$200(this.this$0) != null) {
              localObject = AdExposureChecker.access$200(this.this$0).getTraceId();
            } else {
              localObject = null;
            }
            localAdExposureListHolder.putExternalReportData(localContext, (String)localObject);
            ((AdExposureChecker.ExposureCallback)AdExposureChecker.access$1600(this.this$0).get()).onExposure(AdExposureChecker.access$100(this.this$0));
            AdExposureChecker.access$302(this.this$0, AdExposureChecker.c.CHECKED);
            AdAnalysisHelperForUtil.reportForExposureCallback(localContext, AdExposureChecker.access$200(this.this$0), 0);
            AdLog.d("AdExposureChecker", "exposure success stop check");
            AdExposureChecker.access$1400(this.this$0);
          }
          this.count += 1;
          return true;
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("check failed : isViewDestroyed ");
        ((StringBuilder)localObject).append(AdExposureChecker.access$1100(this.this$0));
        ((StringBuilder)localObject).append(" isViewOnForeground ");
        ((StringBuilder)localObject).append(AdExposureChecker.access$800(this.this$0));
        ((StringBuilder)localObject).append(" status ");
        ((StringBuilder)localObject).append(AdExposureChecker.access$300(this.this$0));
        ((StringBuilder)localObject).append(" no callback :");
        boolean bool1 = bool2;
        if (AdExposureChecker.access$1600(this.this$0) != null) {
          if (AdExposureChecker.access$1600(this.this$0).get() == null) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        ((StringBuilder)localObject).append(bool1);
        AdLog.e("AdExposureChecker", ((StringBuilder)localObject).toString());
      }
    }
    AdExposureChecker.access$1400(this.this$0);
    AdExposureChecker.access$302(this.this$0, AdExposureChecker.c.END);
    return false;
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