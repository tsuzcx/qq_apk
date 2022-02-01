package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.structs.a;

class TRTCCloudImpl$93
  implements Runnable
{
  TRTCCloudImpl$93(TRTCCloudImpl paramTRTCCloudImpl, a parama) {}
  
  public void run()
  {
    if (!TRTCCloudImpl.access$1400(this.this$0))
    {
      this.this$0.apiLog("sendCustomAudioData when mEnableCustomAudioCapture is false");
      return;
    }
    TXCAudioEngine.getInstance().sendCustomPCMData(this.val$packet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.93
 * JD-Core Version:    0.7.0.1
 */