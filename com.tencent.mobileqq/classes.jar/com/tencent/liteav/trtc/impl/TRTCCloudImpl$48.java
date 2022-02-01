package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$48
  implements Runnable
{
  TRTCCloudImpl$48(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    int i = this.val$type;
    if (i == 0) {
      this.this$0.mPriorStreamType = 2;
    } else if (i == 1) {
      this.this$0.mPriorStreamType = 3;
    } else {
      this.this$0.mPriorStreamType = 2;
    }
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPriorRemoteVideoStreamType ");
    localStringBuilder.append(this.this$0.mPriorStreamType);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.48
 * JD-Core Version:    0.7.0.1
 */