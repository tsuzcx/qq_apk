package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;
import com.tencent.liteav.g;

class TRTCCloudImpl$63
  implements Runnable
{
  TRTCCloudImpl$63(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.mConfig.m ^= true;
    this.this$0.mCaptureAndEnc.k();
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchCamera ");
    localStringBuilder.append(this.this$0.mConfig.m);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    TRTCCloudImpl.access$2100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.63
 * JD-Core Version:    0.7.0.1
 */