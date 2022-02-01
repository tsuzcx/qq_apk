package com.tencent.ad.tangram.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import java.lang.ref.WeakReference;

final class AdExposureChecker$5
  implements Runnable
{
  AdExposureChecker$5(Context paramContext, WeakReference paramWeakReference, Ad paramAd) {}
  
  public void run()
  {
    if ((this.val$context == null) || (this.val$mCallback == null) || (this.val$mCallback.get() == null) || (this.val$ad == null) || (!this.val$ad.isValid()) || (TextUtils.isEmpty(this.val$ad.getTraceId()))) {
      AdLog.e("AdExposureChecker", "onClick error");
    }
    while (AdExposureListHolder.getInstance().inCheckedList(this.val$ad.getTraceId())) {
      return;
    }
    AdExposureListHolder.getInstance().putExternalReportData(this.val$context, this.val$ad.getTraceId());
    ((AdExposureChecker.ExposureCallback)this.val$mCallback.get()).onExposure(null);
    AdReporterForAnalysis.reportForExposureCallback(this.val$context, this.val$ad, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureChecker.5
 * JD-Core Version:    0.7.0.1
 */