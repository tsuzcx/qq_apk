package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudDef.TRTCAudioFrame;
import com.tencent.trtc.TRTCCloudListener.TRTCAudioFrameListener;

class TRTCCloudImpl$133
  implements Runnable
{
  TRTCCloudImpl$133(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame) {}
  
  public void run()
  {
    TRTCCloudListener.TRTCAudioFrameListener localTRTCAudioFrameListener = this.this$0.mAudioFrameListener;
    if (localTRTCAudioFrameListener != null) {
      localTRTCAudioFrameListener.onMixedAllAudioFrame(this.val$frame);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.133
 * JD-Core Version:    0.7.0.1
 */