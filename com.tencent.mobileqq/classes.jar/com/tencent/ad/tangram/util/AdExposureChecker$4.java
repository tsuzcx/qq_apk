package com.tencent.ad.tangram.util;

import com.tencent.ad.tangram.log.AdLog;

class AdExposureChecker$4
  implements Runnable
{
  AdExposureChecker$4(AdExposureChecker paramAdExposureChecker) {}
  
  public void run()
  {
    AdLog.e("AdExposureChecker", "onActivityDestroy");
    AdExposureChecker.access$1102(this.this$0, true);
    AdExposureChecker.access$1200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureChecker.4
 * JD-Core Version:    0.7.0.1
 */