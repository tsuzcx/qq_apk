package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCSoundEffectPlayer;

class TRTCCloudImpl$101
  implements Runnable
{
  TRTCCloudImpl$101(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.apiLog("stopAllAudioEffects");
    TXCSoundEffectPlayer.getInstance().stopAllEffect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.101
 * JD-Core Version:    0.7.0.1
 */