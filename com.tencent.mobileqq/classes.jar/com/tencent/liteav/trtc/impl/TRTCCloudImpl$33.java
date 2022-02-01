package com.tencent.liteav.trtc.impl;

import android.graphics.Bitmap;
import com.tencent.liteav.d;

class TRTCCloudImpl$33
  implements Runnable
{
  TRTCCloudImpl$33(TRTCCloudImpl paramTRTCCloudImpl, Bitmap paramBitmap, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVideoMuteImage ");
    localStringBuilder.append(this.val$image);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.val$fps);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    int j = this.val$fps;
    int i;
    if (j > 20)
    {
      i = 20;
    }
    else
    {
      i = j;
      if (j < 5) {
        i = 5;
      }
    }
    this.this$0.mConfig.B = this.val$image;
    this.this$0.mConfig.D = i;
    this.this$0.mConfig.C = -1;
    this.this$0.mCaptureAndEnc.a(this.this$0.mConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.33
 * JD-Core Version:    0.7.0.1
 */