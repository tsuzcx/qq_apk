package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;

class TRTCCloudImpl$45
  implements Runnable
{
  TRTCCloudImpl$45(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vrotation setVideoEncoderRotation ");
    localStringBuilder.append(this.val$rotation);
    localStringBuilder.append(", g sensor mode ");
    localStringBuilder.append(TRTCCloudImpl.access$3400(this.this$0));
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    if (TRTCCloudImpl.access$3400(this.this$0) == 0) {
      this.this$0.mCaptureAndEnc.a(this.val$rotation * 90);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.45
 * JD-Core Version:    0.7.0.1
 */