package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.g;

class TRTCCloudImpl$32
  implements Runnable
{
  TRTCCloudImpl$32(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("muteLocalVideo mute:");
    localStringBuilder.append(this.val$mute);
    localStringBuilder.append(", pauseImg:");
    localStringBuilder.append(this.this$0.mConfig.B);
    localTRTCCloudImpl.apiOnlineLog(localStringBuilder.toString());
    long l;
    if (this.val$mute) {
      l = 1L;
    } else {
      l = 0L;
    }
    TXCEventRecorderProxy.a("18446744073709551615", 4006, l, -1L, "", 2);
    localTRTCCloudImpl = this.this$0;
    localTRTCCloudImpl.muteLocalVideo(this.val$mute, localTRTCCloudImpl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.32
 * JD-Core Version:    0.7.0.1
 */