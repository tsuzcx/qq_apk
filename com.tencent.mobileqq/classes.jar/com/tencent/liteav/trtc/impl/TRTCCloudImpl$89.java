package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCLiveBGMPlayer;

class TRTCCloudImpl$89
  implements Runnable
{
  TRTCCloudImpl$89(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBGMPosition ");
    localStringBuilder.append(this.val$progress);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    TXCLiveBGMPlayer.getInstance().setBGMPosition(this.val$progress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.89
 * JD-Core Version:    0.7.0.1
 */