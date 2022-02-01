package com.tencent.crossengine.offscreen;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OffscreenWorldRender
  implements GLSurfaceView.Renderer
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  
  public OffscreenWorldRender(Context paramContext, long paramLong, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private native void nGLESDestory();
  
  private native void nGLESInit();
  
  private native void nGLESRender(long paramLong, String paramString);
  
  private native void nGLESResize(int paramInt1, int paramInt2);
  
  public void a()
  {
    nGLESDestory();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    nGLESRender(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    nGLESResize(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    nGLESInit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.offscreen.OffscreenWorldRender
 * JD-Core Version:    0.7.0.1
 */