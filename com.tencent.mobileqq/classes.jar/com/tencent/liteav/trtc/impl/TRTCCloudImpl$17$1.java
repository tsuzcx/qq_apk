package com.tencent.liteav.trtc.impl;

import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$17$1
  implements Runnable
{
  TRTCCloudImpl$17$1(TRTCCloudImpl.17 param17, TXCloudVideoView paramTXCloudVideoView) {}
  
  public void run()
  {
    TXCloudVideoView localTXCloudVideoView = this.val$view;
    if (localTXCloudVideoView != null) {
      localTXCloudVideoView.removeVideoView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.17.1
 * JD-Core Version:    0.7.0.1
 */