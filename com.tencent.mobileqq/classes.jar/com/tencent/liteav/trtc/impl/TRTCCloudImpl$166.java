package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudDef.TRTCSpeedTestResult;
import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$166
  implements Runnable
{
  TRTCCloudImpl$166(TRTCCloudImpl paramTRTCCloudImpl, String paramString, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.this$0.mTRTCListener;
    if (localTRTCCloudListener != null)
    {
      TRTCCloudDef.TRTCSpeedTestResult localTRTCSpeedTestResult = new TRTCCloudDef.TRTCSpeedTestResult();
      localTRTCSpeedTestResult.ip = this.val$ip;
      int i = this.val$rtt;
      localTRTCSpeedTestResult.rtt = i;
      float f1 = this.val$upLoss;
      localTRTCSpeedTestResult.upLostRate = f1;
      float f2 = this.val$downLoss;
      localTRTCSpeedTestResult.downLostRate = f2;
      if (f1 >= f2) {
        localTRTCSpeedTestResult.quality = this.this$0.getNetworkQuality(i, (int)(f1 * 100.0F));
      } else {
        localTRTCSpeedTestResult.quality = this.this$0.getNetworkQuality(i, (int)(f2 * 100.0F));
      }
      localTRTCCloudListener.onSpeedTest(localTRTCSpeedTestResult, this.val$finishedCount, this.val$totalCount);
      this.this$0.apiLog("SpeedTest progress %d/%d, result: %s", new Object[] { Integer.valueOf(this.val$finishedCount), Integer.valueOf(this.val$totalCount), localTRTCSpeedTestResult.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.166
 * JD-Core Version:    0.7.0.1
 */