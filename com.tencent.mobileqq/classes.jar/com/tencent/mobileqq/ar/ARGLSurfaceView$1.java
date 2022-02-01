package com.tencent.mobileqq.ar;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class ARGLSurfaceView$1
  implements GLSurfaceView.EGLContextFactory
{
  private int jdField_a_of_type_Int = 12440;
  
  ARGLSurfaceView$1(ARGLSurfaceView paramARGLSurfaceView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createContext. display = ");
    localStringBuilder.append(paramEGLDisplay);
    QLog.i("AREngine_ARGLSurfaceView", 1, localStringBuilder.toString());
    int i = this.jdField_a_of_type_Int;
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (ARGLSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView) != null) {
      ARGLSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView).a();
    }
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      paramEGL10 = new StringBuilder();
      paramEGL10.append("destroyContext. display = ");
      paramEGL10.append(paramEGLDisplay);
      paramEGL10.append(" context = ");
      paramEGL10.append(paramEGLContext);
      paramEGL10.append(" tid = ");
      paramEGL10.append(Thread.currentThread().getId());
      QLog.e("AREngine_ARGLSurfaceView", 1, paramEGL10.toString());
    }
    paramEGL10 = new StringBuilder();
    paramEGL10.append("destroyContext. display = ");
    paramEGL10.append(paramEGLDisplay);
    paramEGL10.append(" context = ");
    paramEGL10.append(paramEGLContext);
    paramEGL10.append(" tid = ");
    paramEGL10.append(Thread.currentThread().getId());
    QLog.i("AREngine_ARGLSurfaceView", 1, paramEGL10.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARGLSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */