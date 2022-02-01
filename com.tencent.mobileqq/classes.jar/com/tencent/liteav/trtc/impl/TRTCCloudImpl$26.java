package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.d;

class TRTCCloudImpl$26
  implements Runnable
{
  TRTCCloudImpl$26(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    if (TRTCCloudImpl.access$1600(this.this$0) == TRTCCloudImpl.VideoSourceType.SCREEN)
    {
      this.this$0.apiLog("pause screen capture");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pause screen capture self:");
      localStringBuilder.append(this.this$0.hashCode());
      Monitor.a(1, localStringBuilder.toString(), "", 0);
      this.this$0.mCaptureAndEnc.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.26
 * JD-Core Version:    0.7.0.1
 */