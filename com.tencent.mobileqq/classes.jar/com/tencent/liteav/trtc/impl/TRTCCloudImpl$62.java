package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$62
  implements Runnable
{
  TRTCCloudImpl$62(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.this$0.mTRTCListener;
    if (localTRTCCloudListener != null) {
      localTRTCCloudListener.onScreenCaptureResumed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.62
 * JD-Core Version:    0.7.0.1
 */