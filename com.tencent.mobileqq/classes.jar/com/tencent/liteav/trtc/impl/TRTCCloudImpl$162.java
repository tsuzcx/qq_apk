package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$162
  implements Runnable
{
  TRTCCloudImpl$162(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.this$0.mTRTCListener;
    if (localTRTCCloudListener != null) {
      localTRTCCloudListener.onTryToReconnect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.162
 * JD-Core Version:    0.7.0.1
 */