package com.tencent.ilivesdk.playview.view;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

class PlayTextureView$11
  implements SurfaceTexture.OnFrameAvailableListener
{
  PlayTextureView$11(PlayTextureView paramPlayTextureView) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.this$0.requestRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayTextureView.11
 * JD-Core Version:    0.7.0.1
 */