package com.tencent.liteav.trtc.impl;

import android.graphics.Bitmap;
import com.tencent.liteav.d;

class TRTCCloudImpl$78
  implements Runnable
{
  TRTCCloudImpl$78(TRTCCloudImpl paramTRTCCloudImpl, int paramInt, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addWatermark stream:");
    localStringBuilder.append(this.val$streamType);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    if (this.val$streamType != 2)
    {
      this.this$0.mConfig.E = this.val$image;
      this.this$0.mConfig.H = this.val$x;
      this.this$0.mConfig.I = this.val$y;
      this.this$0.mConfig.J = this.val$width;
      this.this$0.mCaptureAndEnc.a(this.val$image, this.val$x, this.val$y, this.val$width);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.78
 * JD-Core Version:    0.7.0.1
 */