package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mobileqq.apollo.GLTextureView;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import xby;
import xcu;
import xdd;

@TargetApi(14)
public class DoodleTextureView
  extends GLTextureView
  implements GLSurfaceView.Renderer, xby
{
  int jdField_a_of_type_Int = 320;
  xcu jdField_a_of_type_Xcu;
  int b = 480;
  
  public DoodleTextureView(Context paramContext)
  {
    super(paramContext);
    super.setEGLContextClientVersion(2);
    super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    super.setOpaque(false);
    super.setRenderer(this);
    super.setRenderMode(0);
  }
  
  public void a()
  {
    requestRender();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Xcu != null) {
      this.jdField_a_of_type_Xcu.c(paramInt);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    queueEvent(paramRunnable);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleTextureView", 2, "onDestroy start");
    }
    queueEvent(new DoodleTextureView.2(this));
  }
  
  public String getRenderThreadName()
  {
    return "DoodleTextureThread";
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.jdField_a_of_type_Xcu != null) {
      this.jdField_a_of_type_Xcu.e();
    }
  }
  
  @TargetApi(17)
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    if (this.jdField_a_of_type_Xcu != null)
    {
      paramGL10 = (xdd)this.jdField_a_of_type_Xcu.a(102);
      if (paramGL10 != null) {
        paramGL10.a(paramInt1, paramInt2);
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (this.jdField_a_of_type_Xcu != null) {
      this.jdField_a_of_type_Xcu.d();
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    return true;
  }
  
  public void setOpController(xcu paramxcu)
  {
    this.jdField_a_of_type_Xcu = paramxcu;
    this.jdField_a_of_type_Xcu.a(this);
    super.queueEvent(new DoodleTextureView.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView
 * JD-Core Version:    0.7.0.1
 */