package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$110
  implements Runnable
{
  TRTCCloudImpl$110(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.apiLog("stopPublishing");
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    TRTCCloudImpl.access$6900(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.110
 * JD-Core Version:    0.7.0.1
 */