package com.tencent.liteav.audio;

import com.tencent.liteav.basic.log.TXCLog;
import java.util.HashMap;

class TXAudioEffectManagerImpl$1
  implements Runnable
{
  TXAudioEffectManagerImpl$1(TXAudioEffectManagerImpl paramTXAudioEffectManagerImpl, TXAudioEffectManager.TXMusicPlayObserver paramTXMusicPlayObserver, int paramInt) {}
  
  public void run()
  {
    if (this.val$observer == null) {
      TXAudioEffectManagerImpl.access$600().remove(Long.valueOf(TXAudioEffectManagerImpl.access$500(TXAudioEffectManagerImpl.access$400(this.this$0), this.val$id)));
    } else {
      TXAudioEffectManagerImpl.access$600().put(Long.valueOf(TXAudioEffectManagerImpl.access$500(TXAudioEffectManagerImpl.access$400(this.this$0), this.val$id)), this.val$observer);
    }
    TXCLog.i("AudioCenter:TXAudioEffectManager", "setMusicObserver map count: %d", new Object[] { Integer.valueOf(TXAudioEffectManagerImpl.access$600().size()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.TXAudioEffectManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */