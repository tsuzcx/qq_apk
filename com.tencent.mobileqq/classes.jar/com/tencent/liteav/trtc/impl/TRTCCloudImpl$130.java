package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$130
  implements Runnable
{
  TRTCCloudImpl$130(TRTCCloudImpl paramTRTCCloudImpl, String paramString, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    TRTCCloudImpl.access$9100(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext, Long.valueOf(this.val$tinyId).longValue(), this.val$streamType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.130
 * JD-Core Version:    0.7.0.1
 */