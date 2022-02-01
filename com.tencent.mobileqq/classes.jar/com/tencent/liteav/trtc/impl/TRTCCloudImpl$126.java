package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioFrameCallbackFormat;

class TRTCCloudImpl$126
  implements Runnable
{
  TRTCCloudImpl$126(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudDef.TRTCAudioFrameCallbackFormat paramTRTCAudioFrameCallbackFormat) {}
  
  public void run()
  {
    TXCAudioEngine.getInstance().setCaptureDataCallbackFormat(this.val$format.sampleRate, this.val$format.channel, this.val$format.samplesPerCall);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.126
 * JD-Core Version:    0.7.0.1
 */