package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$111
  implements Runnable
{
  TRTCCloudImpl$111(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.apiLog("stopPublishCDNStream");
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    TRTCCloudImpl.access$7000(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.111
 * JD-Core Version:    0.7.0.1
 */