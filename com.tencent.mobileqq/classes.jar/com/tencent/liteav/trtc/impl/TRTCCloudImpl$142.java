package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$142
  implements Runnable
{
  TRTCCloudImpl$142(TRTCCloudImpl paramTRTCCloudImpl, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    if (this.this$0.mTRTCListener != null) {
      this.this$0.mTRTCListener.onConnectOtherRoom(this.val$userID, this.val$err, this.val$errMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.142
 * JD-Core Version:    0.7.0.1
 */