package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$61
  implements Runnable
{
  TRTCCloudImpl$61(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.this$0.mTRTCListener;
    if (localTRTCCloudListener != null) {
      localTRTCCloudListener.onScreenCaptureStarted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.61
 * JD-Core Version:    0.7.0.1
 */