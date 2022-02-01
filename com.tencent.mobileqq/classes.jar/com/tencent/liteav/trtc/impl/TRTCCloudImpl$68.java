package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$68
  implements Runnable
{
  TRTCCloudImpl$68(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.apiLog("stopLocalRecording");
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    TRTCCloudImpl.access$5700(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.68
 * JD-Core Version:    0.7.0.1
 */