package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;

class TRTCCloudImpl$139
  implements Runnable
{
  TRTCCloudImpl$139(TRTCCloudImpl paramTRTCCloudImpl, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    TXCAudioEngine.getInstance().setAudioEncoderParam(this.val$encFrameLenMs, this.val$encBitrate);
    TXCAudioEngine.getInstance().setEncoderFECPercent(this.val$fecRate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.139
 * JD-Core Version:    0.7.0.1
 */