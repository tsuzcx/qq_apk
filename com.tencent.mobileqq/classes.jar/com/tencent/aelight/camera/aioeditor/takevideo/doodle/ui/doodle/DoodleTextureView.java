package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(14)
public class DoodleTextureView
  extends GLTextureView
  implements GLSurfaceView.Renderer, DoodleGLCallback
{
  int a = 320;
  int b = 480;
  DoodleOpController c;
  
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
    c();
  }
  
  public void a(int paramInt)
  {
    DoodleOpController localDoodleOpController = this.c;
    if (localDoodleOpController != null) {
      localDoodleOpController.d(paramInt);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    b(paramRunnable);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleTextureView", 2, "onDestroy start");
    }
    b(new DoodleTextureView.2(this));
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    paramGL10 = this.c;
    if (paramGL10 != null) {
      paramGL10.i();
    }
  }
  
  @TargetApi(17)
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    paramGL10 = this.c;
    if (paramGL10 != null)
    {
      paramGL10 = (PersonalityOperator)paramGL10.a(102);
      if (paramGL10 != null) {
        paramGL10.a(paramInt1, paramInt2);
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    paramGL10 = this.c;
    if (paramGL10 != null) {
      paramGL10.f();
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    return true;
  }
  
  public void setOpController(DoodleOpController paramDoodleOpController)
  {
    this.c = paramDoodleOpController;
    this.c.a(this);
    super.b(new DoodleTextureView.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleTextureView
 * JD-Core Version:    0.7.0.1
 */