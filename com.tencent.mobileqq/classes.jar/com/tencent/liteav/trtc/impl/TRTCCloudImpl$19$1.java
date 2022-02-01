package com.tencent.liteav.trtc.impl;

import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$19$1
  implements Runnable
{
  TRTCCloudImpl$19$1(TRTCCloudImpl.19 param19, TXCloudVideoView paramTXCloudVideoView) {}
  
  public void run()
  {
    TXCloudVideoView localTXCloudVideoView = this.val$view;
    if (localTXCloudVideoView != null) {
      localTXCloudVideoView.removeVideoView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.19.1
 * JD-Core Version:    0.7.0.1
 */