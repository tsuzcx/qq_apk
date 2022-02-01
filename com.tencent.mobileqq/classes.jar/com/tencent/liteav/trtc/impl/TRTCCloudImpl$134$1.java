package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$134$1
  implements Runnable
{
  TRTCCloudImpl$134$1(TRTCCloudImpl.134 param134, TRTCCloudListener paramTRTCCloudListener) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.val$listener;
    if (localTRTCCloudListener != null) {
      localTRTCCloudListener.onUserEnter(this.this$1.val$userID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.134.1
 * JD-Core Version:    0.7.0.1
 */