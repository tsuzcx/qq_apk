package com.tencent.ilivesdk.playview.view;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

class PlayView$11
  implements SurfaceTexture.OnFrameAvailableListener
{
  PlayView$11(PlayView paramPlayView) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.this$0.requestRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayView.11
 * JD-Core Version:    0.7.0.1
 */