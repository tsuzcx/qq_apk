package com.google.android.filament.android;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.TextureView;

class UiHelper$TextureViewHandler
  implements UiHelper.RenderSurface
{
  private Surface mSurface;
  private TextureView mTextureView;
  
  UiHelper$TextureViewHandler(UiHelper paramUiHelper, TextureView paramTextureView)
  {
    this.mTextureView = paramTextureView;
  }
  
  public void detach()
  {
    setSurface(null);
  }
  
  public void resize(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 15) {
      this.mTextureView.getSurfaceTexture().setDefaultBufferSize(paramInt1, paramInt2);
    }
    UiHelper.access$000(this.this$0).onResized(paramInt1, paramInt2);
  }
  
  void setSurface(Surface paramSurface)
  {
    if ((paramSurface == null) && (this.mSurface != null)) {
      this.mSurface.release();
    }
    this.mSurface = paramSurface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.android.UiHelper.TextureViewHandler
 * JD-Core Version:    0.7.0.1
 */