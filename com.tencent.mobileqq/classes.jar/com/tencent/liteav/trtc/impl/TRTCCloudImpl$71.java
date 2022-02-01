package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.beauty.TXBeautyManager;

class TRTCCloudImpl$71
  implements Runnable
{
  TRTCCloudImpl$71(TRTCCloudImpl paramTRTCCloudImpl, float paramFloat) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setFilterStrength: ");
    localStringBuilder.append(this.val$concentration);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.getBeautyManager().setFilterStrength(this.val$concentration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.71
 * JD-Core Version:    0.7.0.1
 */