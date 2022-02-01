package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$189
  implements Runnable
{
  TRTCCloudImpl$189(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudListener paramTRTCCloudListener, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    this.val$listener.onUserAudioAvailable(this.val$userId, this.val$audioAvailable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.189
 * JD-Core Version:    0.7.0.1
 */