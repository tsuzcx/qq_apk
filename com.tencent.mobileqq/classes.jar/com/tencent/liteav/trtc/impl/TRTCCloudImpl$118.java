package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudDef.TRTCPublishCDNParam;

class TRTCCloudImpl$118
  implements Runnable
{
  TRTCCloudImpl$118(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudDef.TRTCPublishCDNParam paramTRTCPublishCDNParam) {}
  
  public void run()
  {
    this.this$0.apiLog("startPublishCDNStream");
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    TRTCCloudImpl.access$8400(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext, this.val$param);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.118
 * JD-Core Version:    0.7.0.1
 */