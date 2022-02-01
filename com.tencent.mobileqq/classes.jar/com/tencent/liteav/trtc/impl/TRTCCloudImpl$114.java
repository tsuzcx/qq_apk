package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$114
  implements Runnable
{
  TRTCCloudImpl$114(TRTCCloudImpl paramTRTCCloudImpl, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    TRTCCloudImpl.access$7200(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext, this.val$cmdID, this.val$finalMsg, this.val$reliable, this.val$ordered);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.114
 * JD-Core Version:    0.7.0.1
 */