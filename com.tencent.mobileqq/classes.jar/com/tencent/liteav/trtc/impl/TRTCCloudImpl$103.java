package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCSoundEffectPlayer;

class TRTCCloudImpl$103
  implements Runnable
{
  TRTCCloudImpl$103(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pauseAudioEffect -> effectId = ");
    localStringBuilder.append(this.val$effectId);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    TXCSoundEffectPlayer.getInstance().pauseEffectWithId(this.val$effectId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.103
 * JD-Core Version:    0.7.0.1
 */