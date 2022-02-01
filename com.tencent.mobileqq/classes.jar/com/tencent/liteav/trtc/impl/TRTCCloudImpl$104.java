package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXAudioEffectManagerImpl;

class TRTCCloudImpl$104
  implements Runnable
{
  TRTCCloudImpl$104(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TXAudioEffectManagerImpl.getInstance().setVoiceChangerType(this.this$0.voiceChangerTypes[this.val$voiceChangerType]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.104
 * JD-Core Version:    0.7.0.1
 */