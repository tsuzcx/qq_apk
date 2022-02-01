package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$115
  implements Runnable
{
  TRTCCloudImpl$115(TRTCCloudImpl paramTRTCCloudImpl, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    if ((!TRTCCloudImpl.access$6200(this.this$0)) || (!TRTCCloudImpl.access$6100(this.this$0)) || (!TRTCCloudHevcUtil.isLifeCycleEnableHevcEncode()))
    {
      TRTCCloudImpl localTRTCCloudImpl = this.this$0;
      TRTCCloudImpl.access$7300(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext, this.val$data, this.val$repeatCount);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.115
 * JD-Core Version:    0.7.0.1
 */