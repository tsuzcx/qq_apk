package com.tencent.liteav.trtc.impl;

import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud.TRTCViewMargin;

class TRTCCloudImpl$106$2
  implements Runnable
{
  TRTCCloudImpl$106$2(TRTCCloudImpl.106 param106, TXCloudVideoView paramTXCloudVideoView1, TXCloudVideoView paramTXCloudVideoView2) {}
  
  public void run()
  {
    TXCloudVideoView localTXCloudVideoView = this.val$remoteView;
    if (localTXCloudVideoView != null) {
      localTXCloudVideoView.setLogMarginRatio(this.this$1.val$margin.leftMargin, this.this$1.val$margin.rightMargin, this.this$1.val$margin.topMargin, this.this$1.val$margin.bottomMargin);
    }
    localTXCloudVideoView = this.val$remoteSubView;
    if (localTXCloudVideoView != null) {
      localTXCloudVideoView.setLogMarginRatio(this.this$1.val$margin.leftMargin, this.this$1.val$margin.rightMargin, this.this$1.val$margin.topMargin, this.this$1.val$margin.bottomMargin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.106.2
 * JD-Core Version:    0.7.0.1
 */