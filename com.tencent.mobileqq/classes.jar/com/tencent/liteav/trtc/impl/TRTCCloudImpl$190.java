package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$190
  implements Runnable
{
  TRTCCloudImpl$190(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudListener paramTRTCCloudListener, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    this.val$listener.onUserVideoAvailable(this.val$userId, this.val$mainAvailable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.190
 * JD-Core Version:    0.7.0.1
 */