package com.tencent.ad.tangram.util;

import android.view.View;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

class AdExposureChecker$6
  extends AdExposureChecker.b
{
  AdExposureChecker$6(AdExposureChecker paramAdExposureChecker, long paramLong)
  {
    super(paramAdExposureChecker, paramLong);
  }
  
  void onScrollChangedOverDuration()
  {
    AdExposureChecker localAdExposureChecker = this.this$0;
    if (!AdExposureChecker.access$1300(localAdExposureChecker, (View)AdExposureChecker.access$100(localAdExposureChecker).get()))
    {
      AdLog.e("AdExposureChecker", "onScrollChangedOverDuration view invisible");
      AdExposureChecker.access$1400(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureChecker.6
 * JD-Core Version:    0.7.0.1
 */