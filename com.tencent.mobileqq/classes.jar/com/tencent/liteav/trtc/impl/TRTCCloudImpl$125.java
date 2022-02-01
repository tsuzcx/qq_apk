package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.trtc.TRTCCloudListener.TRTCAudioFrameListener;

class TRTCCloudImpl$125
  implements Runnable
{
  TRTCCloudImpl$125(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudListener.TRTCAudioFrameListener paramTRTCAudioFrameListener) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAudioFrameListener ");
    localStringBuilder.append(this.val$listener);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    localTRTCCloudImpl = this.this$0;
    localTRTCCloudImpl.mAudioFrameListener = this.val$listener;
    if (localTRTCCloudImpl.mAudioFrameListener == null)
    {
      TXCAudioEngine.setPlayoutDataListener(null);
      TXCAudioEngine.getInstance().setAudioCaptureDataListener(null);
      TXCAudioEngine.getInstance().setMixedAllDataListener(null);
      this.this$0.mRoomInfo.forEachUser(new TRTCCloudImpl.125.1(this));
      return;
    }
    TXCAudioEngine.setPlayoutDataListener(this.this$0);
    TXCAudioEngine.getInstance().setAudioCaptureDataListener(this.this$0);
    TXCAudioEngine.getInstance().setMixedAllDataListener(this.this$0);
    this.this$0.mRoomInfo.forEachUser(new TRTCCloudImpl.125.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.125
 * JD-Core Version:    0.7.0.1
 */