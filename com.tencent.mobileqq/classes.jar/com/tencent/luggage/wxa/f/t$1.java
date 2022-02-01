package com.tencent.luggage.wxa.f;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup;

class t$1
  implements TextureView.SurfaceTextureListener
{
  t$1(t paramt, ViewGroup paramViewGroup) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    f.a(t.b(), "onSurfaceTextureAvailable, width = %d, height = %d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.b.b(paramInt1, paramInt2);
    t.a(this.b, this.a.getMeasuredHeight());
    t.a(this.b);
    this.b.j();
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    f.b(t.b(), "onSurfaceTextureDestroyed");
    this.b.b(0, 0);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    f.a(t.b(), "onSurfaceTextureSizeChanged, width = %d, height = %d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.b.b(paramInt1, paramInt2);
    t.a(this.b, this.a.getMeasuredHeight());
    t.a(this.b);
    this.b.j();
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.t.1
 * JD-Core Version:    0.7.0.1
 */