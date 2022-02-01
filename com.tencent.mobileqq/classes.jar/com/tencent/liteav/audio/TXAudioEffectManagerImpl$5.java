package com.tencent.liteav.audio;

import java.util.HashMap;

final class TXAudioEffectManagerImpl$5
  implements Runnable
{
  TXAudioEffectManagerImpl$5(long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    if (TXAudioEffectManagerImpl.access$600().get(Long.valueOf(this.val$id)) != null) {
      ((TXAudioEffectManager.TXMusicPlayObserver)TXAudioEffectManagerImpl.access$600().get(Long.valueOf(this.val$id))).onPlayProgress((int)this.val$id, this.val$curPtsMS, this.val$durationMS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.TXAudioEffectManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */