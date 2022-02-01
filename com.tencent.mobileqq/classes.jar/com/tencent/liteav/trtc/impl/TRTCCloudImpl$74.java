package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.beauty.TXBeautyManager;

class TRTCCloudImpl$74
  implements Runnable
{
  TRTCCloudImpl$74(TRTCCloudImpl paramTRTCCloudImpl, String paramString) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setGreenScreenFile ");
    localStringBuilder.append(this.val$file);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    this.this$0.getBeautyManager().setGreenScreenFile(this.val$file);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.74
 * JD-Core Version:    0.7.0.1
 */