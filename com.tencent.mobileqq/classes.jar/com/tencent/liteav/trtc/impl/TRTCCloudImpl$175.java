package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$175
  implements Runnable
{
  TRTCCloudImpl$175(TRTCCloudImpl paramTRTCCloudImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    this.this$0.apiOnlineLog(String.format("onCancelTranscoding err:%d, msg:%s", new Object[] { Integer.valueOf(this.val$code), this.val$msg }));
    TRTCCloudListener localTRTCCloudListener = this.this$0.mTRTCListener;
    if (localTRTCCloudListener != null) {
      localTRTCCloudListener.onSetMixTranscodingConfig(this.val$code, this.val$msg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.175
 * JD-Core Version:    0.7.0.1
 */