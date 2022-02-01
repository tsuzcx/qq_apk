package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCSoundEffectPlayer;

class TRTCCloudImpl$111
  implements Runnable
{
  TRTCCloudImpl$111(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAllAudioEffectsVolume volume = ");
    localStringBuilder.append(this.val$volume);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    float f = this.val$volume / 100.0F;
    TXCSoundEffectPlayer.getInstance().setEffectsVolume(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.111
 * JD-Core Version:    0.7.0.1
 */