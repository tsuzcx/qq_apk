package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCLiveBGMPlayer;

class TRTCCloudImpl$93
  implements Runnable
{
  TRTCCloudImpl$93(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    float f = this.val$volume / 100.0F;
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBGMPublishVolume ");
    localStringBuilder.append(this.val$volume);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    TXCLiveBGMPlayer.getInstance().setPublishVolume(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.93
 * JD-Core Version:    0.7.0.1
 */