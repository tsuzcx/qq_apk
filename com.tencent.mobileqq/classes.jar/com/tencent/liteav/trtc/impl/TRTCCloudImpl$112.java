package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$112
  implements Runnable
{
  TRTCCloudImpl$112(TRTCCloudImpl paramTRTCCloudImpl, String paramString, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startPublishing streamId:");
    localStringBuilder.append(this.val$streamId);
    localStringBuilder.append(", streamType:");
    localStringBuilder.append(this.val$streamType);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    int j = this.val$streamType;
    int i = 2;
    if (j == 2) {
      i = 7;
    }
    localTRTCCloudImpl = this.this$0;
    TRTCCloudImpl.access$7100(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext, this.val$streamId, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.112
 * JD-Core Version:    0.7.0.1
 */