package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$11
  implements Runnable
{
  TRTCCloudImpl$11(TRTCCloudImpl paramTRTCCloudImpl, String paramString) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ConnectOtherRoom ");
    localStringBuilder.append(this.val$param);
    localTRTCCloudImpl.apiOnlineLog(localStringBuilder.toString());
    localTRTCCloudImpl = this.this$0;
    TRTCCloudImpl.access$1700(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext, this.val$param);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.11
 * JD-Core Version:    0.7.0.1
 */