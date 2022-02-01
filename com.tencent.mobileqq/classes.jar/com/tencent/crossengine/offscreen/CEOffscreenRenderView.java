package com.tencent.crossengine.offscreen;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.crossengine.CEApplication;
import com.tencent.crossengine.log.Logger;

public class CEOffscreenRenderView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private CEOffscreenEGLRender a;
  
  public CEOffscreenRenderView(Context paramContext, CEApplication paramCEApplication, String paramString)
  {
    super(paramContext);
    setSurfaceTextureListener(this);
    setOpaque(false);
    this.a = new CEOffscreenEGLRender(paramCEApplication, paramString);
  }
  
  public void a()
  {
    Logger.a("CEOffscreenRenderView", "onResume ");
    this.a.c();
  }
  
  public void b()
  {
    Logger.a("CEOffscreenRenderView", "onPause ");
    this.a.d();
  }
  
  public void c()
  {
    this.a.b();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Logger.a("CEOffscreenRenderView", "onSurfaceTextureAvailable ");
    this.a.a(new Surface(paramSurfaceTexture), paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    Logger.a("CEOffscreenRenderView", "onSurfaceTextureDestroyed ");
    this.a.e();
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Logger.a("CEOffscreenRenderView", "onSurfaceTextureSizeChanged ");
    this.a.b(new Surface(paramSurfaceTexture), paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.offscreen.CEOffscreenRenderView
 * JD-Core Version:    0.7.0.1
 */