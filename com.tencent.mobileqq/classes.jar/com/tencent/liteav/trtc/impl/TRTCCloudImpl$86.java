package com.tencent.liteav.trtc.impl;

import android.view.Surface;
import com.tencent.liteav.d;

class TRTCCloudImpl$86
  implements Runnable
{
  TRTCCloudImpl$86(TRTCCloudImpl paramTRTCCloudImpl, Surface paramSurface) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLocalSurface ");
    localStringBuilder.append(this.val$surface);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.mCaptureAndEnc.a(this.val$surface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.86
 * JD-Core Version:    0.7.0.1
 */