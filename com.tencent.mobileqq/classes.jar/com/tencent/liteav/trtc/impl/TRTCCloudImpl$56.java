package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.basic.module.Monitor;

class TRTCCloudImpl$56
  implements Runnable
{
  TRTCCloudImpl$56(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("enableAudioEarMonitoring enable:%b", new Object[] { Boolean.valueOf(this.val$enable) }));
    localStringBuilder.append(" self:");
    localStringBuilder.append(this.this$0.hashCode());
    Monitor.a(1, localStringBuilder.toString(), "", 0);
    TXAudioEffectManagerImpl.getInstance().enableVoiceEarMonitor(this.val$enable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.56
 * JD-Core Version:    0.7.0.1
 */