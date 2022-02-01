package com.tencent.liteav.trtc.impl;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;

class TRTCCloudImpl$19$1
  implements Runnable
{
  TRTCCloudImpl$19$1(TRTCCloudImpl.19 param19, SurfaceView paramSurfaceView, TextureView paramTextureView) {}
  
  public void run()
  {
    Object localObject = this.val$surfaceView;
    if (localObject != null)
    {
      ((SurfaceView)localObject).getHolder().removeCallback(this.this$1.this$0);
      return;
    }
    localObject = this.val$textureView;
    if (localObject != null) {
      ((TextureView)localObject).setSurfaceTextureListener(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.19.1
 * JD-Core Version:    0.7.0.1
 */