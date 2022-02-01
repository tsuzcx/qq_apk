package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.beauty.TXBeautyManager;

class TRTCCloudImpl$80
  implements Runnable
{
  TRTCCloudImpl$80(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setNoseSlimLevel ");
    localStringBuilder.append(this.val$noseSlimLevel);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.getBeautyManager().setNoseSlimLevel(this.val$noseSlimLevel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.80
 * JD-Core Version:    0.7.0.1
 */