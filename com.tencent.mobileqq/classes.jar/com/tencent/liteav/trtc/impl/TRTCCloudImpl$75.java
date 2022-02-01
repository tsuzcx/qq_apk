package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.beauty.TXBeautyManager;

class TRTCCloudImpl$75
  implements Runnable
{
  TRTCCloudImpl$75(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setEyeScaleLevel ");
    localStringBuilder.append(this.val$eyeScaleLevel);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.getBeautyManager().setEyeScaleLevel(this.val$eyeScaleLevel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.75
 * JD-Core Version:    0.7.0.1
 */