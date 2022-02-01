package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;

class TRTCCloudImpl$47
  implements Runnable
{
  TRTCCloudImpl$47(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    if (!TRTCCloudImpl.access$1500(this.this$0))
    {
      this.this$0.apiLog("stopLocalAudio when no capturing audio, ignore!!!");
      return;
    }
    this.this$0.apiLog("stopLocalAudio");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopLocalAudio self:");
    localStringBuilder.append(this.this$0.hashCode());
    Monitor.a(1, localStringBuilder.toString(), "", 0);
    TXCEventRecorderProxy.a("18446744073709551615", 3001, 2L, -1L, "", 0);
    TRTCCloudImpl.access$1502(this.this$0, false);
    TXCAudioEngine.getInstance().stopLocalAudio();
    this.this$0.enableAudioStream(false);
    TXCKeyPointReportProxy.a(40050, 0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.47
 * JD-Core Version:    0.7.0.1
 */