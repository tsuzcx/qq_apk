package com.tencent.liteav.trtc.impl;

import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$166
  implements Runnable
{
  TRTCCloudImpl$166(TRTCCloudImpl paramTRTCCloudImpl, TXCloudVideoView paramTXCloudVideoView, String paramString) {}
  
  public void run()
  {
    TXCloudVideoView localTXCloudVideoView = this.val$finalView;
    if (localTXCloudVideoView != null) {
      localTXCloudVideoView.appendEventInfo(this.val$log);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.166
 * JD-Core Version:    0.7.0.1
 */