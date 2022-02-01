package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioFrameCallbackFormat;

class TRTCCloudImpl$128
  implements Runnable
{
  TRTCCloudImpl$128(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudDef.TRTCAudioFrameCallbackFormat paramTRTCAudioFrameCallbackFormat) {}
  
  public void run()
  {
    TXCAudioEngine.getInstance().setPlayoutDataCallbackFormat(this.val$format.sampleRate, this.val$format.channel, this.val$format.samplesPerCall);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.128
 * JD-Core Version:    0.7.0.1
 */