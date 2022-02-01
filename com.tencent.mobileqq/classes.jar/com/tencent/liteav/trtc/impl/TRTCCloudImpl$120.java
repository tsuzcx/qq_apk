package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$120
  implements Runnable
{
  TRTCCloudImpl$120(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.apiLog("stopPublishCDNStream");
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    TRTCCloudImpl.access$8600(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.120
 * JD-Core Version:    0.7.0.1
 */