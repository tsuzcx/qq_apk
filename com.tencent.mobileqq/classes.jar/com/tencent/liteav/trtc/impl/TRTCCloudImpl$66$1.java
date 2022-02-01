package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$66$1
  implements Runnable
{
  TRTCCloudImpl$66$1(TRTCCloudImpl.66 param66) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.this$1.this$0.mTRTCListener;
    if (localTRTCCloudListener == null) {
      return;
    }
    this.this$1.this$0.apiLog("startLocalAudioRecord onWarning:7001");
    localTRTCCloudListener.onWarning(7001, "write file failed when recording audio.", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.66.1
 * JD-Core Version:    0.7.0.1
 */