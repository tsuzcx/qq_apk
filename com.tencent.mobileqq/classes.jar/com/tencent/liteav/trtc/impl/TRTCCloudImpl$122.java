package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloud.BGMNotify;

class TRTCCloudImpl$122
  implements Runnable
{
  TRTCCloudImpl$122(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TRTCCloud.BGMNotify localBGMNotify = TRTCCloudImpl.access$6500(this.this$0);
    if (localBGMNotify != null) {
      localBGMNotify.onBGMComplete(this.val$err);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.122
 * JD-Core Version:    0.7.0.1
 */