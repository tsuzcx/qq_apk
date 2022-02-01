package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$144
  implements Runnable
{
  TRTCCloudImpl$144(TRTCCloudImpl paramTRTCCloudImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.mTRTCListener != null) {
      this.this$0.mTRTCListener.onSwitchRoom(this.val$err, this.val$errMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.144
 * JD-Core Version:    0.7.0.1
 */