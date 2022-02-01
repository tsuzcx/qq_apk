package com.tencent.liteav;

import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.rtmp.ui.TXCloudVideoView;

class d$24
  implements Runnable
{
  d$24(d paramd, TXCGLSurfaceView[] paramArrayOfTXCGLSurfaceView, TXCloudVideoView paramTXCloudVideoView) {}
  
  public void run()
  {
    this.a[0] = new TXCGLSurfaceView(this.b.getContext());
    this.b.addVideoView(this.a[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.d.24
 * JD-Core Version:    0.7.0.1
 */