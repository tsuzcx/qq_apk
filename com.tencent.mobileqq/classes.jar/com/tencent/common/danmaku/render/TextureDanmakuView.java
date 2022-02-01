package com.tencent.common.danmaku.render;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnTouchListener;
import com.tencent.common.danmaku.util.Logger;

public class TextureDanmakuView
  implements TextureView.SurfaceTextureListener, IDanmakuView
{
  private TextureView a;
  private IDanmakuView.CallBack b;
  private boolean c = false;
  private boolean d = false;
  
  public TextureDanmakuView(TextureView paramTextureView)
  {
    this.a = paramTextureView;
    this.a.setOpaque(false);
    this.a.setSurfaceTextureListener(this);
  }
  
  public Canvas a()
  {
    return this.a.lockCanvas();
  }
  
  public void a(Canvas paramCanvas)
  {
    this.a.unlockCanvasAndPost(paramCanvas);
  }
  
  public void a(View.OnTouchListener paramOnTouchListener)
  {
    this.a.setOnTouchListener(paramOnTouchListener);
  }
  
  public void a(IDanmakuView.CallBack paramCallBack)
  {
    this.b = paramCallBack;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public float b()
  {
    return this.a.getY();
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void c() {}
  
  public void d()
  {
    this.b = null;
    TextureView localTextureView = this.a;
    if (localTextureView != null)
    {
      localTextureView.setOnTouchListener(null);
      this.a = null;
    }
  }
  
  public boolean e()
  {
    return this.c;
  }
  
  public boolean f()
  {
    return this.d;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Logger.b("TextureDanmakuView", "[onSurfaceTextureAvailable] surface texture available...");
    this.a.setOpaque(false);
    paramSurfaceTexture = this.b;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.t();
      this.b.u();
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = this.b;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.v();
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Logger.b("TextureDanmakuView", "[onSurfaceTextureSizeChanged] surface texture size changed...");
    paramSurfaceTexture = this.b;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.u();
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.render.TextureDanmakuView
 * JD-Core Version:    0.7.0.1
 */