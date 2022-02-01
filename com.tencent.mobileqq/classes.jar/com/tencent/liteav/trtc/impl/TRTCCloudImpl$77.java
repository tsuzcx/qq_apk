package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.beauty.TXBeautyManager;

class TRTCCloudImpl$77
  implements Runnable
{
  TRTCCloudImpl$77(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setFaceVLevel ");
    localStringBuilder.append(this.val$faceVLevel);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.getBeautyManager().setFaceVLevel(this.val$faceVLevel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.77
 * JD-Core Version:    0.7.0.1
 */