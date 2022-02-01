package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$170
  implements Runnable
{
  TRTCCloudImpl$170(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudListener paramTRTCCloudListener, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    this.val$listener.onUserSubStreamAvailable(this.val$userId, this.val$subAvailable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.170
 * JD-Core Version:    0.7.0.1
 */