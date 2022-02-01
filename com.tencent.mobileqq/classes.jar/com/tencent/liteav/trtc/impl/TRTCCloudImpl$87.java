package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;

class TRTCCloudImpl$87
  implements Runnable
{
  TRTCCloudImpl$87(TRTCCloudImpl paramTRTCCloudImpl, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLocalSurfaceSize: ");
    localStringBuilder.append(this.val$width);
    localStringBuilder.append(",");
    localStringBuilder.append(this.val$height);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.mCaptureAndEnc.a(this.val$width, this.val$height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.87
 * JD-Core Version:    0.7.0.1
 */