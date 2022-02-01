package com.tencent.liteav.trtc.impl;

import android.graphics.Bitmap;
import com.tencent.liteav.d;

class TRTCCloudImpl$81
  implements Runnable
{
  TRTCCloudImpl$81(TRTCCloudImpl paramTRTCCloudImpl, int paramInt, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addWatermark stream:");
    localStringBuilder.append(this.val$streamType);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    if (this.val$streamType != 2)
    {
      this.this$0.mConfig.F = this.val$image;
      this.this$0.mConfig.I = this.val$x;
      this.this$0.mConfig.J = this.val$y;
      this.this$0.mConfig.K = this.val$width;
      this.this$0.mCaptureAndEnc.a(this.val$image, this.val$x, this.val$y, this.val$width);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.81
 * JD-Core Version:    0.7.0.1
 */