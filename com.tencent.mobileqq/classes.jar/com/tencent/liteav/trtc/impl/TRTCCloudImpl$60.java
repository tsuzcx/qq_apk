package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXAudioEffectManagerImpl;

class TRTCCloudImpl$60
  implements Runnable
{
  TRTCCloudImpl$60(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.apiOnlineLog("enableAudioEarMonitoring enable:%b", new Object[] { Boolean.valueOf(this.val$enable) });
    TXAudioEffectManagerImpl.getInstance().enableVoiceEarMonitor(this.val$enable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.60
 * JD-Core Version:    0.7.0.1
 */