package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;

class TRTCCloudImpl$41
  implements Runnable
{
  TRTCCloudImpl$41(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLocalViewFillMode ");
    localStringBuilder.append(this.val$mode);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.mCaptureAndEnc.f(this.val$mode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.41
 * JD-Core Version:    0.7.0.1
 */