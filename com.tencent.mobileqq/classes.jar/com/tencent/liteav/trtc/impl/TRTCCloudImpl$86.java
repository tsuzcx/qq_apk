package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCLiveBGMPlayer;

class TRTCCloudImpl$86
  implements Runnable
{
  TRTCCloudImpl$86(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.apiLog("stopBGM");
    TXCLiveBGMPlayer.getInstance().stopPlay();
    TRTCCloudImpl.access$6502(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.86
 * JD-Core Version:    0.7.0.1
 */