package com.tencent.crossengine.offscreen;

import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;

public class CEOffscreenGLSurfaceView
  extends GLSurfaceView
{
  private OffscreenWorldRender a;
  
  public void onPause()
  {
    OffscreenWorldRender localOffscreenWorldRender = this.a;
    if (localOffscreenWorldRender != null) {
      localOffscreenWorldRender.a();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    OffscreenWorldRender localOffscreenWorldRender = this.a;
    if (localOffscreenWorldRender != null) {
      localOffscreenWorldRender.b();
    }
    super.onResume();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.offscreen.CEOffscreenGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */