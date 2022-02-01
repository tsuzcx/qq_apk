package com.tencent.liteav;

import com.tencent.rtmp.ui.TXCloudVideoView;

class d$8
  implements Runnable
{
  d$8(d paramd, TXCloudVideoView paramTXCloudVideoView, boolean paramBoolean) {}
  
  public void run()
  {
    TXCloudVideoView localTXCloudVideoView = this.a;
    if (localTXCloudVideoView != null) {
      localTXCloudVideoView.stop(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.d.8
 * JD-Core Version:    0.7.0.1
 */