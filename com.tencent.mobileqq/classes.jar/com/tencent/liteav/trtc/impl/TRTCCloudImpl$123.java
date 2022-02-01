package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$123
  implements Runnable
{
  TRTCCloudImpl$123(TRTCCloudImpl paramTRTCCloudImpl, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    TRTCCloudImpl.access$8800(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext, this.val$cmdID, this.val$data, this.val$reliable, this.val$ordered);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.123
 * JD-Core Version:    0.7.0.1
 */