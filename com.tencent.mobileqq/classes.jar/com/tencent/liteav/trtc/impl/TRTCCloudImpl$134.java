package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloud.BGMNotify;

class TRTCCloudImpl$134
  implements Runnable
{
  TRTCCloudImpl$134(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    TRTCCloud.BGMNotify localBGMNotify = TRTCCloudImpl.access$8100(this.this$0);
    if (localBGMNotify != null) {
      localBGMNotify.onBGMStart(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.134
 * JD-Core Version:    0.7.0.1
 */