package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;

class TRTCCloudImpl$50
  implements Runnable
{
  TRTCCloudImpl$50(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVideoEncoderMirror ");
    localStringBuilder.append(this.val$mirror);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.mConfig.T = this.val$mirror;
    this.this$0.mCaptureAndEnc.g(this.val$mirror);
    TRTCCloudImpl.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.50
 * JD-Core Version:    0.7.0.1
 */