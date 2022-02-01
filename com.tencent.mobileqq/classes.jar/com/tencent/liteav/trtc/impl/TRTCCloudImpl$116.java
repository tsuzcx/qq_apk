package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$116
  implements Runnable
{
  TRTCCloudImpl$116(TRTCCloudImpl paramTRTCCloudImpl, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    this.this$0.apiLog("startSpeedTest");
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    TRTCCloudImpl.access$8200(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext, this.val$sdkAppId, this.val$userId, this.val$userSig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.116
 * JD-Core Version:    0.7.0.1
 */