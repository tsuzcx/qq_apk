package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloud.BGMNotify;

class TRTCCloudImpl$121
  implements Runnable
{
  TRTCCloudImpl$121(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    TRTCCloud.BGMNotify localBGMNotify = TRTCCloudImpl.access$6500(this.this$0);
    if (localBGMNotify != null) {
      localBGMNotify.onBGMStart(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.121
 * JD-Core Version:    0.7.0.1
 */