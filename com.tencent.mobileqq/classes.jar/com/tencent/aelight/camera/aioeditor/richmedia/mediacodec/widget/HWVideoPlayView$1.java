package com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class HWVideoPlayView$1
  implements GLSurfaceView.EGLContextFactory
{
  private int b = 12440;
  
  HWVideoPlayView$1(HWVideoPlayView paramHWVideoPlayView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int i = this.b;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createContext. display = ");
      localStringBuilder.append(paramEGLDisplay);
      localStringBuilder.append(" tid = ");
      localStringBuilder.append(Thread.currentThread().getId());
      QLog.d("HWVideoPlayView", 1, localStringBuilder.toString());
    }
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      paramEGL10 = new StringBuilder();
      paramEGL10.append("destroyContext. display = ");
      paramEGL10.append(paramEGLDisplay);
      paramEGL10.append(" context = ");
      paramEGL10.append(paramEGLContext);
      paramEGL10.append(" tid = ");
      paramEGL10.append(Thread.currentThread().getId());
      QLog.e("HWVideoPlayView", 1, paramEGL10.toString());
    }
    this.a.a();
    if (QLog.isColorLevel())
    {
      paramEGL10 = new StringBuilder();
      paramEGL10.append("destroyContext. display = ");
      paramEGL10.append(paramEGLDisplay);
      paramEGL10.append(" context = ");
      paramEGL10.append(paramEGLContext);
      paramEGL10.append(" tid = ");
      paramEGL10.append(Thread.currentThread().getId());
      QLog.d("HWVideoPlayView", 1, paramEGL10.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView.1
 * JD-Core Version:    0.7.0.1
 */