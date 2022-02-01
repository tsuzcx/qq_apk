package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$7$1
  implements Runnable
{
  TRTCCloudImpl$7$1(TRTCCloudImpl.7 param7) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.this$1.this$0.mTRTCListener;
    if (localTRTCCloudListener == null) {
      return;
    }
    localTRTCCloudListener.onWarning(6001, "ignore upstream for audience", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.7.1
 * JD-Core Version:    0.7.0.1
 */