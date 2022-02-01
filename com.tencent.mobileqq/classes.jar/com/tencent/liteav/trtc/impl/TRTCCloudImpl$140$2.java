package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$140$2
  implements Runnable
{
  TRTCCloudImpl$140$2(TRTCCloudImpl.140 param140) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.this$1.this$0.mTRTCListener;
    if (localTRTCCloudListener != null) {
      localTRTCCloudListener.onExitRoom(this.this$1.val$err);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.140.2
 * JD-Core Version:    0.7.0.1
 */