package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$150$1
  implements Runnable
{
  TRTCCloudImpl$150$1(TRTCCloudImpl.150 param150, TRTCCloudListener paramTRTCCloudListener) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.val$listener;
    if (localTRTCCloudListener != null) {
      localTRTCCloudListener.onUserEnter(this.this$1.val$userID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.150.1
 * JD-Core Version:    0.7.0.1
 */