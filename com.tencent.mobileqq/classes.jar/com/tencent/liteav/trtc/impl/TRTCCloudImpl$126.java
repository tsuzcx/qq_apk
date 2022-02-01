package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$126
  implements Runnable
{
  TRTCCloudImpl$126(TRTCCloudImpl paramTRTCCloudImpl, int paramInt) {}
  
  public void run()
  {
    TXCKeyPointReportProxy.b(30001, this.val$err);
    TRTCCloudListener localTRTCCloudListener = this.this$0.mTRTCListener;
    long l = this.this$0.mRoomInfo.getRoomElapsed();
    if (localTRTCCloudListener != null)
    {
      int i = this.val$err;
      if (i == 0)
      {
        localTRTCCloudListener.onEnterRoom(l);
        return;
      }
      localTRTCCloudListener.onEnterRoom(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.126
 * JD-Core Version:    0.7.0.1
 */