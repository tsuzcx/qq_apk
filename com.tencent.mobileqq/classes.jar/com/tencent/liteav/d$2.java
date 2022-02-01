package com.tencent.liteav;

import com.tencent.rtmp.ui.TXCloudVideoView;

class d$2
  implements Runnable
{
  d$2(d paramd, TXCloudVideoView paramTXCloudVideoView) {}
  
  public void run()
  {
    TXCloudVideoView localTXCloudVideoView = this.a;
    if (localTXCloudVideoView != null) {
      localTXCloudVideoView.start(d.e(this.b).K, d.e(this.b).L, d.f(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.d.2
 * JD-Core Version:    0.7.0.1
 */