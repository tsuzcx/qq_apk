package com.peterlmeng.animate_image.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import com.peterlmeng.animate_image.support.log.LogUtils;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class OpenGLRenderer
  implements Runnable
{
  private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
  private static final String LOG_TAG = "OpenGL.Worker";
  private EGL10 egl;
  private EGLContext eglContext;
  private EGLDisplay eglDisplay;
  private EGLSurface eglSurface;
  public boolean isRenderStart;
  private boolean running;
  protected final SurfaceTexture texture;
  private OpenGLRenderer.Worker worker;
  
  public OpenGLRenderer(SurfaceTexture paramSurfaceTexture, OpenGLRenderer.Worker paramWorker)
  {
    this.texture = paramSurfaceTexture;
    this.running = true;
    this.worker = paramWorker;
  }
  
  private EGLConfig chooseEglConfig()
  {
    Object localObject = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = getConfig();
    if (this.egl.eglChooseConfig(this.eglDisplay, arrayOfInt, arrayOfEGLConfig, 1, (int[])localObject))
    {
      if (localObject[0] > 0) {
        return arrayOfEGLConfig[0];
      }
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to choose config: ");
    ((StringBuilder)localObject).append(GLUtils.getEGLErrorString(this.egl.eglGetError()));
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
  }
  
  private void deinitGL()
  {
    this.egl.eglMakeCurrent(this.eglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
    this.egl.eglDestroySurface(this.eglDisplay, this.eglSurface);
    this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
    this.egl.eglTerminate(this.eglDisplay);
    LogUtils.a("OpenGL.Worker", "OpenGL deinit OK.");
  }
  
  private int[] getConfig()
  {
    return new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 0, 12338, 1, 12337, 4, 12344 };
  }
  
  private void initGL()
  {
    this.egl = ((EGL10)EGLContext.getEGL());
    this.eglDisplay = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.eglDisplay != EGL10.EGL_NO_DISPLAY)
    {
      Object localObject = new int[2];
      if (this.egl.eglInitialize(this.eglDisplay, (int[])localObject))
      {
        localObject = chooseEglConfig();
        this.eglContext = createContext(this.egl, this.eglDisplay, (EGLConfig)localObject);
        this.eglSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, (EGLConfig)localObject, this.texture, null);
        if ((this.eglSurface != null) && (this.eglSurface != EGL10.EGL_NO_SURFACE))
        {
          if (this.egl.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext)) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("GL make current error: ");
          ((StringBuilder)localObject).append(GLUtils.getEGLErrorString(this.egl.eglGetError()));
          throw new RuntimeException(((StringBuilder)localObject).toString());
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GL Error: ");
        ((StringBuilder)localObject).append(GLUtils.getEGLErrorString(this.egl.eglGetError()));
        throw new RuntimeException(((StringBuilder)localObject).toString());
      }
      throw new RuntimeException("eglInitialize failed");
    }
    throw new RuntimeException("eglGetDisplay failed");
  }
  
  protected void finalize()
  {
    super.finalize();
    this.running = false;
    this.isRenderStart = false;
  }
  
  public boolean getIsRunning()
  {
    return this.running;
  }
  
  public void onDispose()
  {
    this.running = false;
  }
  
  public void run()
  {
    this.worker.onCreate(this.texture);
    while (!this.worker.onResourceGet()) {}
    initGL();
    LogUtils.a("OpenGL.Worker", "OpenGL init OK.");
    while (this.running)
    {
      long l = System.currentTimeMillis();
      if ((this.worker.onDraw()) && (!this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface))) {
        LogUtils.a("OpenGL.Worker", String.valueOf(this.egl.eglGetError()));
      }
      l = 16L - (System.currentTimeMillis() - l);
      if (l > 0L) {
        try
        {
          Thread.sleep(l);
        }
        catch (InterruptedException localInterruptedException)
        {
          LogUtils.b("OpenGL.Worker", localInterruptedException.getMessage());
        }
      }
    }
    this.worker.onDispose();
    deinitGL();
  }
  
  public void startRender()
  {
    new Thread(this).start();
    this.isRenderStart = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.OpenGLRenderer
 * JD-Core Version:    0.7.0.1
 */