package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$46
  implements Runnable
{
  TRTCCloudImpl$46(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    if (TRTCCloudImpl.access$1600(this.this$0) == TRTCCloudImpl.VideoSourceType.SCREEN)
    {
      this.this$0.apiLog("setGSensorMode has been ignored for screen capturing");
      return;
    }
    TRTCCloudImpl.access$3402(this.this$0, this.val$mode);
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vrotation setGSensorMode ");
    localStringBuilder.append(this.val$mode);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.46
 * JD-Core Version:    0.7.0.1
 */