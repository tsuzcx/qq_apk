package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXAudioEffectManagerImpl;

class TRTCCloudImpl$103
  implements Runnable
{
  TRTCCloudImpl$103(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    this.this$0.apiLog("setLocalViewFillMode");
    TXAudioEffectManagerImpl.getInstance().setVoiceReverbType(this.this$0.reverbTypes[this.val$reverbType]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.103
 * JD-Core Version:    0.7.0.1
 */