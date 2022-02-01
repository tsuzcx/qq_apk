package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$141
  implements Runnable
{
  TRTCCloudImpl$141(TRTCCloudImpl paramTRTCCloudImpl, String paramString, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onKickOut ");
    localStringBuilder.append(this.val$errMsg);
    localTRTCCloudImpl.exitRoomInternal(false, localStringBuilder.toString());
    TRTCCloudImpl.access$9500(this.this$0, this.val$err, this.val$errMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.141
 * JD-Core Version:    0.7.0.1
 */