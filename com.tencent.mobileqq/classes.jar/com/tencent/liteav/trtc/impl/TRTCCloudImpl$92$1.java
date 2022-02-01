package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$92$1
  implements Runnable
{
  TRTCCloudImpl$92$1(TRTCCloudImpl.92 param92) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.this$1.this$0.mTRTCListener;
    if (localTRTCCloudListener == null) {
      return;
    }
    localTRTCCloudListener.onWarning(6001, "ignore send custom audio,for role audience", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.92.1
 * JD-Core Version:    0.7.0.1
 */