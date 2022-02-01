package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.beauty.TXBeautyManager;

class TRTCCloudImpl$73
  implements Runnable
{
  TRTCCloudImpl$73(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMotionMute ");
    localStringBuilder.append(this.val$motionMute);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.getBeautyManager().setMotionMute(this.val$motionMute);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.73
 * JD-Core Version:    0.7.0.1
 */