package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.impl.TXCAudioEngineJNI.a;

class TRTCCloudImpl$66
  implements TXCAudioEngineJNI.a
{
  TRTCCloudImpl$66(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void onLocalAudioWriteFailed()
  {
    this.this$0.runOnListenerThread(new TRTCCloudImpl.66.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.66
 * JD-Core Version:    0.7.0.1
 */