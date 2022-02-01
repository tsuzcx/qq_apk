package com.tencent.livesdk.livesdkplayer.renderview;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;

class TPTextureView$1
  implements TextureView.SurfaceTextureListener
{
  TPTextureView$1(TPTextureView paramTPTextureView) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (TPTextureView.access$000(this.this$0) != null) {
      TPTextureView.access$000(this.this$0).onViewCreated(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (TPTextureView.access$000(this.this$0) != null) {
      TPTextureView.access$000(this.this$0).onViewDestroyed(paramSurfaceTexture);
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (TPTextureView.access$000(this.this$0) != null) {
      TPTextureView.access$000(this.this$0).onViewChanged(paramSurfaceTexture, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    if (TPTextureView.access$000(this.this$0) != null) {
      TPTextureView.access$000(this.this$0).onViewChanged(paramSurfaceTexture, this.this$0.getWidth(), this.this$0.getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.renderview.TPTextureView.1
 * JD-Core Version:    0.7.0.1
 */