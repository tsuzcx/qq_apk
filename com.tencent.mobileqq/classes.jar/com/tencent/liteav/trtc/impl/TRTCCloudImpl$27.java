package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.d;

class TRTCCloudImpl$27
  implements Runnable
{
  TRTCCloudImpl$27(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    if (TRTCCloudImpl.access$1600(this.this$0) == TRTCCloudImpl.VideoSourceType.SCREEN)
    {
      this.this$0.apiLog("resume screen capture");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resume screen capture self:");
      localStringBuilder.append(this.this$0.hashCode());
      Monitor.a(1, localStringBuilder.toString(), "", 0);
      this.this$0.mCaptureAndEnc.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.27
 * JD-Core Version:    0.7.0.1
 */