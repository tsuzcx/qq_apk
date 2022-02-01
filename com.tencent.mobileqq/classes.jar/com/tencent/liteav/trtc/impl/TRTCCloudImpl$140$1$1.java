package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$140$1$1
  implements Runnable
{
  TRTCCloudImpl$140$1$1(TRTCCloudImpl.140.1 param1, int paramInt) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.this$2.this$1.this$0.mTRTCListener;
    if (localTRTCCloudListener != null) {
      localTRTCCloudListener.onExitRoom(this.val$exitCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.140.1.1
 * JD-Core Version:    0.7.0.1
 */