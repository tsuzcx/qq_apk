package com.tencent.liteav.trtc.impl;

import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$105$2$1
  implements Runnable
{
  TRTCCloudImpl$105$2$1(TRTCCloudImpl.105.2 param2, TXCloudVideoView paramTXCloudVideoView1, TXCloudVideoView paramTXCloudVideoView2) {}
  
  public void run()
  {
    TXCloudVideoView localTXCloudVideoView = this.val$remoteView;
    if (localTXCloudVideoView != null) {
      localTXCloudVideoView.showVideoDebugLog(this.this$2.this$1.val$showType);
    }
    localTXCloudVideoView = this.val$remoteSubView;
    if (localTXCloudVideoView != null) {
      localTXCloudVideoView.showVideoDebugLog(this.this$2.this$1.val$showType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.105.2.1
 * JD-Core Version:    0.7.0.1
 */