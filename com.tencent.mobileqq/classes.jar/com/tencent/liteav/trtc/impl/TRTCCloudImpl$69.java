package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.beauty.TXBeautyManager;

class TRTCCloudImpl$69
  implements Runnable
{
  TRTCCloudImpl$69(TRTCCloudImpl paramTRTCCloudImpl, String paramString) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("selectMotionTmpl ");
    localStringBuilder.append(this.val$motionPath);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.getBeautyManager().setMotionTmpl(this.val$motionPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.69
 * JD-Core Version:    0.7.0.1
 */