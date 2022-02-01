package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCLiveBGMPlayer;

class TRTCCloudImpl$95
  implements Runnable
{
  TRTCCloudImpl$95(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.apiLog("stopBGM");
    TXCLiveBGMPlayer.getInstance().stopPlay();
    TRTCCloudImpl.access$8102(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.95
 * JD-Core Version:    0.7.0.1
 */