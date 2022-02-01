package com.tencent.aelight.camera.ae.camera.core;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.aelight.camera.log.AEQLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class AECameraGLSurfaceView$3
  implements GLSurfaceView.EGLContextFactory
{
  AECameraGLSurfaceView$3(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    AECameraGLSurfaceView.access$202(this.this$0, paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }));
    AEQLog.d("AECameraGLSurfaceView", "[EGLContext] createContext finish");
    return AECameraGLSurfaceView.access$200(this.this$0);
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    AEQLog.d("AECameraGLSurfaceView", "[EGLContext] destroyContext start");
    if (paramEGLDisplay == null) {
      AEQLog.d("AECameraGLSurfaceView", "EGLDisplay is null.");
    }
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    AEQLog.d("AECameraGLSurfaceView", "[EGLContext] destroyContext finish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.3
 * JD-Core Version:    0.7.0.1
 */