package com.tencent.crossengine.offscreen;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import com.tencent.crossengine.CEApplication;

public class CEOffscreenGLSurfaceView
  extends GLSurfaceView
{
  private OffscreenWorldRender a;
  
  public CEOffscreenGLSurfaceView(Context paramContext, CEApplication paramCEApplication, String paramString)
  {
    super(paramContext);
    super.setZOrderOnTop(true);
    super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    super.getHolder().setFormat(-2);
    a(paramContext, paramCEApplication, paramString);
  }
  
  private void a(Context paramContext, CEApplication paramCEApplication, String paramString)
  {
    setEGLContextClientVersion(3);
    setDebugFlags(1);
    this.a = new OffscreenWorldRender(paramContext, paramCEApplication.getNativeHandle(), paramString);
    setRenderer(this.a);
    setRenderMode(1);
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.offscreen.CEOffscreenGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */