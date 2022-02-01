package com.tencent.liteav.trtc.impl;

import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$185
  implements Runnable
{
  TRTCCloudImpl$185(TRTCCloudImpl paramTRTCCloudImpl, TXCloudVideoView paramTXCloudVideoView1, TXCloudVideoView paramTXCloudVideoView2) {}
  
  public void run()
  {
    TXCloudVideoView localTXCloudVideoView = this.val$view;
    if (localTXCloudVideoView != null) {
      localTXCloudVideoView.removeVideoView();
    }
    localTXCloudVideoView = this.val$subView;
    if (localTXCloudVideoView != null) {
      localTXCloudVideoView.removeVideoView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.185
 * JD-Core Version:    0.7.0.1
 */