package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCSoundEffectPlayer;

class TRTCCloudImpl$113
  implements Runnable
{
  TRTCCloudImpl$113(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumeAudioEffect -> effectId = ");
    localStringBuilder.append(this.val$effectId);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    TXCSoundEffectPlayer.getInstance().resumeEffectWithId(this.val$effectId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.113
 * JD-Core Version:    0.7.0.1
 */