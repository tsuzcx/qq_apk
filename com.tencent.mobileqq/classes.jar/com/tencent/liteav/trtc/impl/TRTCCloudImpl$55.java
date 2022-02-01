package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.TXCEventRecorderProxy;

class TRTCCloudImpl$55
  implements Runnable
{
  TRTCCloudImpl$55(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean) {}
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("muteLocalAudio ");
    localStringBuilder.append(this.val$mute);
    localTRTCCloudImpl.apiOnlineLog(localStringBuilder.toString());
    localTRTCCloudImpl = this.this$0;
    localTRTCCloudImpl.muteLocalAudio(this.val$mute, localTRTCCloudImpl);
    if (this.val$mute)
    {
      TXCEventRecorderProxy.a("18446744073709551615", 3001, 1L, -1L, "", 0);
      return;
    }
    TXCEventRecorderProxy.a("18446744073709551615", 3001, 3L, -1L, "", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.55
 * JD-Core Version:    0.7.0.1
 */