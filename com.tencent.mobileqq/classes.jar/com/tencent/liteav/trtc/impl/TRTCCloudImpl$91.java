package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCLiveBGMPlayer;

class TRTCCloudImpl$91
  implements Runnable
{
  TRTCCloudImpl$91(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBGMVolume ");
    localStringBuilder.append(this.val$volume);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    float f = this.val$volume / 100.0F;
    TXCLiveBGMPlayer.getInstance().setVolume(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.91
 * JD-Core Version:    0.7.0.1
 */