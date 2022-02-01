package com.tencent.live2.a;

import com.tencent.liteav.audio.TXAudioEffectManagerImpl.TXAudioEffectManagerListener;
import com.tencent.rtmp.TXLivePushConfig;

class b$1
  implements TXAudioEffectManagerImpl.TXAudioEffectManagerListener
{
  b$1(b paramb) {}
  
  public void onSwitchVoiceEarMonitor(boolean paramBoolean)
  {
    b.a(this.a).enableAudioEarMonitoring(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.a.b.1
 * JD-Core Version:    0.7.0.1
 */