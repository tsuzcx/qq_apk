package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$191
  implements Runnable
{
  TRTCCloudImpl$191(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudListener paramTRTCCloudListener, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    this.val$listener.onUserSubStreamAvailable(this.val$userId, this.val$subAvailable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.191
 * JD-Core Version:    0.7.0.1
 */