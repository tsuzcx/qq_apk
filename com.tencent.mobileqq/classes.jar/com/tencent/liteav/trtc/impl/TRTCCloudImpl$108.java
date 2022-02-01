package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCSoundEffectPlayer;

class TRTCCloudImpl$108
  implements Runnable
{
  TRTCCloudImpl$108(TRTCCloudImpl paramTRTCCloudImpl, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAudioEffectVolume -> effectId = ");
    localStringBuilder.append(this.val$effectId);
    localStringBuilder.append(" volume = ");
    localStringBuilder.append(this.val$volume);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    float f = this.val$volume / 100.0F;
    TXCSoundEffectPlayer.getInstance().setVolumeOfEffect(this.val$effectId, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.108
 * JD-Core Version:    0.7.0.1
 */