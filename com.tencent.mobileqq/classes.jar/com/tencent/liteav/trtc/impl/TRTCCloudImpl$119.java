package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$119
  implements Runnable
{
  TRTCCloudImpl$119(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.apiLog("stopPublishing");
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    TRTCCloudImpl.access$8500(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.119
 * JD-Core Version:    0.7.0.1
 */