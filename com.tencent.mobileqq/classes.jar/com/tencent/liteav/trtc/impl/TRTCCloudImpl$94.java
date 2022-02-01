package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXAudioEffectManagerImpl;

class TRTCCloudImpl$94
  implements Runnable
{
  TRTCCloudImpl$94(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    this.this$0.apiLog("setLocalViewFillMode");
    TXAudioEffectManagerImpl.getInstance().setVoiceReverbType(this.this$0.reverbTypes[this.val$reverbType]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.94
 * JD-Core Version:    0.7.0.1
 */