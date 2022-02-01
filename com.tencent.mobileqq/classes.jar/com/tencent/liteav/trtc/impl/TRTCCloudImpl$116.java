package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.trtc.TRTCCloudListener.TRTCAudioFrameListener;

class TRTCCloudImpl$116
  implements Runnable
{
  TRTCCloudImpl$116(TRTCCloudImpl paramTRTCCloudImpl1, TRTCCloudListener.TRTCAudioFrameListener paramTRTCAudioFrameListener, TRTCCloudImpl paramTRTCCloudImpl2) {}
  
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
      this.this$0.mRoomInfo.forEachUser(new TRTCCloudImpl.116.1(this));
      return;
    }
    TXCAudioEngine.setPlayoutDataListener(this.val$refThis);
    TXCAudioEngine.getInstance().setAudioCaptureDataListener(this.val$refThis);
    this.this$0.mRoomInfo.forEachUser(new TRTCCloudImpl.116.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.116
 * JD-Core Version:    0.7.0.1
 */