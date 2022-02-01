package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloud.BGMNotify;

class TRTCCloudImpl$136
  implements Runnable
{
  TRTCCloudImpl$136(TRTCCloudImpl paramTRTCCloudImpl, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    TRTCCloud.BGMNotify localBGMNotify = TRTCCloudImpl.access$8100(this.this$0);
    if (localBGMNotify != null) {
      localBGMNotify.onBGMProgress(this.val$curPtsMS, this.val$durationMS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.136
 * JD-Core Version:    0.7.0.1
 */