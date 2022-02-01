package com.tencent.liteav.audio;

import com.tencent.liteav.basic.log.TXCLog;
import java.util.HashMap;

final class TXAudioEffectManagerImpl$3
  implements Runnable
{
  TXAudioEffectManagerImpl$3(long paramLong, int paramInt) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEffectFinish -> effect id = ");
    localStringBuilder.append(this.val$id);
    localStringBuilder.append(", errCode = ");
    localStringBuilder.append(this.val$errCode);
    TXCLog.i("AudioCenter:TXAudioEffectManager", localStringBuilder.toString());
    if (TXAudioEffectManagerImpl.access$600().get(Long.valueOf(this.val$id)) != null) {
      ((TXAudioEffectManager.TXMusicPlayObserver)TXAudioEffectManagerImpl.access$600().get(Long.valueOf(this.val$id))).onComplete((int)this.val$id, this.val$errCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.TXAudioEffectManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */