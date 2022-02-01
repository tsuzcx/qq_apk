package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCSoundEffectPlayer;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioEffectParam;

class TRTCCloudImpl$98
  implements Runnable
{
  TRTCCloudImpl$98(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudDef.TRTCAudioEffectParam paramTRTCAudioEffectParam) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playAudioEffect -> effectId = ");
    localStringBuilder.append(this.val$effect.effectId);
    localStringBuilder.append(" path = ");
    localStringBuilder.append(this.val$effect.path);
    localStringBuilder.append(" publish = ");
    localStringBuilder.append(this.val$effect.publish);
    localStringBuilder.append(" loopCount = ");
    localStringBuilder.append(this.val$effect.loopCount);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    TXCSoundEffectPlayer.getInstance().playEffectWithId(this.val$effect.effectId, this.val$effect.path, this.val$effect.publish, this.val$effect.loopCount);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.98
 * JD-Core Version:    0.7.0.1
 */