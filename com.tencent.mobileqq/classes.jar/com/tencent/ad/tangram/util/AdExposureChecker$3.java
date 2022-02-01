package com.tencent.ad.tangram.util;

import com.tencent.ad.tangram.log.AdLog;

class AdExposureChecker$3
  implements Runnable
{
  AdExposureChecker$3(AdExposureChecker paramAdExposureChecker) {}
  
  public void run()
  {
    AdLog.e("AdExposureChecker", "onActivityPause");
    AdExposureChecker.access$802(this.this$0, false);
    AdExposureChecker.access$1000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureChecker.3
 * JD-Core Version:    0.7.0.1
 */