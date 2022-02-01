package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCLiveBGMPlayer;

class TRTCCloudImpl$96
  implements Runnable
{
  TRTCCloudImpl$96(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.apiLog("pauseBGM");
    TXCLiveBGMPlayer.getInstance().pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.96
 * JD-Core Version:    0.7.0.1
 */