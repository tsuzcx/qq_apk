package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;

class TRTCCloudImpl$45
  implements Runnable
{
  TRTCCloudImpl$45(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAudioQuality ");
    localStringBuilder.append(this.val$quality);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    TXCAudioEngine.getInstance().setAudioQuality(this.val$quality, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.45
 * JD-Core Version:    0.7.0.1
 */