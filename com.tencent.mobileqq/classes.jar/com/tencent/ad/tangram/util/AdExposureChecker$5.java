package com.tencent.ad.tangram.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import java.lang.ref.WeakReference;

final class AdExposureChecker$5
  implements Runnable
{
  AdExposureChecker$5(Context paramContext, WeakReference paramWeakReference, Ad paramAd) {}
  
  public void run()
  {
    if (this.val$context != null)
    {
      Object localObject = this.val$mCallback;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        localObject = this.val$ad;
        if ((localObject != null) && (((Ad)localObject).isValid()) && (!TextUtils.isEmpty(this.val$ad.getTraceId())))
        {
          if (!AdExposureListHolder.getInstance().inCheckedList(this.val$ad.getTraceId()))
          {
            AdExposureListHolder.getInstance().putExternalReportData(this.val$context, this.val$ad.getTraceId());
            ((AdExposureChecker.ExposureCallback)this.val$mCallback.get()).onExposure(null);
            AdAnalysisHelperForUtil.reportForExposureCallback(this.val$context, this.val$ad, 1);
          }
          return;
        }
      }
    }
    AdLog.e("AdExposureChecker", "onClick error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureChecker.5
 * JD-Core Version:    0.7.0.1
 */