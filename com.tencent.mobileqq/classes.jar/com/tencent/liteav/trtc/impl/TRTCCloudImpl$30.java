package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;

class TRTCCloudImpl$30
  implements Runnable
{
  TRTCCloudImpl$30(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    if (TRTCCloudImpl.access$1600(this.this$0) == TRTCCloudImpl.VideoSourceType.SCREEN)
    {
      this.this$0.apiOnlineLog("pauseScreenCapture");
      this.this$0.mCaptureAndEnc.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.30
 * JD-Core Version:    0.7.0.1
 */