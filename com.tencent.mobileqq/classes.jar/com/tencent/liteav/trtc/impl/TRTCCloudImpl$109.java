package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudDef.TRTCPublishCDNParam;

class TRTCCloudImpl$109
  implements Runnable
{
  TRTCCloudImpl$109(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudDef.TRTCPublishCDNParam paramTRTCPublishCDNParam) {}
  
  public void run()
  {
    this.this$0.apiLog("startPublishCDNStream");
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    TRTCCloudImpl.access$6800(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext, this.val$param);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.109
 * JD-Core Version:    0.7.0.1
 */