package com.tencent.liteav.audio;

import java.util.HashMap;

class TXAudioEffectManagerImpl$2
  implements Runnable
{
  TXAudioEffectManagerImpl$2(TXAudioEffectManagerImpl paramTXAudioEffectManagerImpl, long paramLong) {}
  
  public void run()
  {
    TXAudioEffectManagerImpl.access$600().remove(Long.valueOf(this.val$finalId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.TXAudioEffectManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */