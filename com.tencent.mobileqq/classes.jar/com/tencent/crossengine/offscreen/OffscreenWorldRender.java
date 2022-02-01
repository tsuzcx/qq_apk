package com.tencent.crossengine.offscreen;

import android.opengl.GLSurfaceView.Renderer;
import com.tencent.crossengine.log.Logger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OffscreenWorldRender
  implements GLSurfaceView.Renderer
{
  private long a;
  private String b;
  private boolean c;
  
  private native void nGLESDestory();
  
  private native void nGLESInit();
  
  private native void nGLESRender(long paramLong, String paramString);
  
  private native void nGLESResize(int paramInt1, int paramInt2);
  
  public void a()
  {
    this.c = true;
  }
  
  public void b()
  {
    this.c = false;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.c)
    {
      paramGL10 = new StringBuilder();
      paramGL10.append("onDrawFrame return ");
      paramGL10.append(this.c);
      Logger.a("OffscreenWorldRender", paramGL10.toString());
      return;
    }
    nGLESRender(this.a, this.b);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (this.c)
    {
      paramGL10 = new StringBuilder();
      paramGL10.append("onSurfaceChanged return ");
      paramGL10.append(this.c);
      Logger.a("OffscreenWorldRender", paramGL10.toString());
      return;
    }
    nGLESResize(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    nGLESInit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.offscreen.OffscreenWorldRender
 * JD-Core Version:    0.7.0.1
 */