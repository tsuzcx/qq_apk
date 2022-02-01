package com.tencent.mobileqq.armap;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class ARGLSurfaceView$1
  implements GLSurfaceView.EGLContextFactory
{
  ARGLSurfaceView$1(ARGLSurfaceView paramARGLSurfaceView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    QLog.d("ARGLSurfaceView", 2, "createContext start");
    if (paramEGL10.eglGetError() == 12288)
    {
      ARGLSurfaceView.access$002(this.this$0, false);
      EGLContext localEGLContext = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
      if (paramEGL10.eglGetError() == 12288)
      {
        if (ARGLSurfaceView.access$100(this.this$0) != null) {
          ARGLSurfaceView.access$100(this.this$0).onEGLConfigCreated(paramEGL10, paramEGLDisplay, paramEGLConfig, localEGLContext, this.this$0.mEngineHandler);
        }
        return localEGLContext;
      }
      paramEGLDisplay = new StringBuilder();
      paramEGLDisplay.append("createContext error:");
      paramEGLDisplay.append(paramEGL10.eglGetError());
      throw new RuntimeException(paramEGLDisplay.toString());
    }
    paramEGLDisplay = new StringBuilder();
    paramEGLDisplay.append("createContext error:");
    paramEGLDisplay.append(paramEGL10.eglGetError());
    throw new RuntimeException(paramEGLDisplay.toString());
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    QLog.d("ARGLSurfaceView", 2, "destroyContext");
    ARGLSurfaceView.access$002(this.this$0, true);
    if (ARGLSurfaceView.access$100(this.this$0) != null) {
      ARGLSurfaceView.access$100(this.this$0).onEGLContextDestroyed(paramEGL10, paramEGLDisplay, paramEGLContext);
    }
    ARGLSurfaceView localARGLSurfaceView;
    if ((this.this$0.mIsDestroyed) && (this.this$0.mEngineHandler != 0L))
    {
      localARGLSurfaceView = this.this$0;
      ARGLSurfaceView.access$200(localARGLSurfaceView, localARGLSurfaceView.mEngineHandler);
      this.this$0.mEngineHandler = 0L;
    }
    if (this.this$0.mEngineHandler != 0L)
    {
      localARGLSurfaceView = this.this$0;
      ARGLSurfaceView.access$300(localARGLSurfaceView, localARGLSurfaceView.mEngineHandler);
    }
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARGLSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */