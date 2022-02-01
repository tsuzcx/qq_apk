package com.tencent.luggage.wxa.my;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.xweb.skia_canvas.SkiaCanvasView;

class d$2
  implements TextureView.SurfaceTextureListener
{
  d$2(d paramd) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    o.d("Luggage.SkiaCanvasTextureView", "surface:%s width:%d height:%d viewId%d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(d.c(this.a)) });
    if (d.a(this.a) == null)
    {
      d locald = this.a;
      d.a(locald, new SkiaCanvasView(d.d(locald), paramSurfaceTexture, d.e(this.a), d.c(this.a)));
      if (d.b(this.a) != null) {
        d.b(this.a).a();
      }
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    o.d("Luggage.SkiaCanvasTextureView", "onSurfaceTextureDestroyed:%s", new Object[] { paramSurfaceTexture });
    if (d.a(this.a) != null) {
      d.a(this.a).recycle();
    }
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    o.d("Luggage.SkiaCanvasTextureView", "onSurfaceTextureSizeChanged:%s width:%d height:%d viewId%d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(d.c(this.a)) });
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.my.d.2
 * JD-Core Version:    0.7.0.1
 */