package com.tencent.aelight.camera.aioeditor.takevideo.localmedia.opengl;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.TimeoutException;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(14)
public class CodecOutputSurface
  implements SurfaceTexture.OnFrameAvailableListener
{
  int a;
  int b;
  private STextureRender c;
  private SurfaceTexture d;
  private Surface e;
  private EGL10 f;
  private EGLDisplay g = EGL10.EGL_NO_DISPLAY;
  private EGLContext h = EGL10.EGL_NO_CONTEXT;
  private EGLSurface i = EGL10.EGL_NO_SURFACE;
  private Object j = new Object();
  private boolean k;
  private ByteBuffer l;
  
  public CodecOutputSurface(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.f = ((EGL10)EGLContext.getEGL());
      this.a = paramInt1;
      this.b = paramInt2;
      h();
      b();
      g();
      return;
    }
    throw new IllegalArgumentException();
  }
  
  private void a(String paramString)
  {
    int m = this.f.eglGetError();
    if (m == 12288) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": EGL error: 0x");
    localStringBuilder.append(Integer.toHexString(m));
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  private void g()
  {
    this.c = new STextureRender();
    this.c.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("textureID=");
    localStringBuilder.append(this.c.a());
    Log.d("CodecOutputSurface", localStringBuilder.toString());
    this.d = new SurfaceTexture(this.c.a());
    this.d.setOnFrameAvailableListener(this);
    this.e = new Surface(this.d);
    this.l = ByteBuffer.allocateDirect(this.a * this.b * 4);
    this.l.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private void h()
  {
    this.g = this.f.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.g != EGL10.EGL_NO_DISPLAY)
    {
      Object localObject = new int[2];
      if (this.f.eglInitialize(this.g, (int[])localObject))
      {
        localObject = new EGLConfig[1];
        int[] arrayOfInt = new int[1];
        EGL10 localEGL10 = this.f;
        EGLDisplay localEGLDisplay = this.g;
        int m = localObject.length;
        if (localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 }, (EGLConfig[])localObject, m, arrayOfInt))
        {
          this.h = this.f.eglCreateContext(this.g, localObject[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
          a("eglCreateContext");
          if (this.h != null)
          {
            m = this.a;
            int n = this.b;
            this.i = this.f.eglCreatePbufferSurface(this.g, localObject[0], new int[] { 12375, m, 12374, n, 12344 });
            a("eglCreatePbufferSurface");
            if (this.i != null) {
              return;
            }
            throw new RuntimeException("surface was null");
          }
          throw new RuntimeException("null context");
        }
        throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
      }
      this.g = null;
      throw new RuntimeException("unable to initialize EGL14");
    }
    throw new RuntimeException("unable to get EGL14 display");
  }
  
  public void a()
  {
    if (this.g != EGL10.EGL_NO_DISPLAY)
    {
      this.f.eglDestroySurface(this.g, this.i);
      this.f.eglDestroyContext(this.g, this.h);
      this.f.eglMakeCurrent(this.g, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.f.eglTerminate(this.g);
    }
    this.g = EGL10.EGL_NO_DISPLAY;
    this.h = EGL10.EGL_NO_CONTEXT;
    this.i = EGL10.EGL_NO_SURFACE;
    this.e.release();
    this.c = null;
    this.e = null;
    this.d = null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.a(this.d, paramBoolean);
  }
  
  public void b()
  {
    EGL10 localEGL10 = this.f;
    EGLDisplay localEGLDisplay = this.g;
    EGLSurface localEGLSurface = this.i;
    if (localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.h)) {
      return;
    }
    throw new RuntimeException("eglMakeCurrent failed");
  }
  
  public Surface c()
  {
    return this.e;
  }
  
  public void d()
  {
    Log.e("CodecOutputSurface", "awaitNewImage");
    synchronized (this.j)
    {
      for (;;)
      {
        boolean bool = this.k;
        if (!bool) {
          try
          {
            this.j.wait(1L);
            if (!this.k) {
              throw new TimeoutException("frame wait timed out");
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new RuntimeException(localInterruptedException);
          }
        }
      }
      this.k = false;
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void e()
  {
    this.c.a("before updateTexImage");
    this.d.updateTexImage();
  }
  
  public Bitmap f()
  {
    this.l.rewind();
    GLES20.glReadPixels(0, 0, this.a, this.b, 6408, 5121, this.l);
    Bitmap localBitmap = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.ARGB_8888);
    this.l.rewind();
    localBitmap.copyPixelsFromBuffer(this.l);
    Log.d("CodecOutputSurface", "getFrameBitmap() finish...");
    return localBitmap;
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    Log.e("CodecOutputSurface", "onFrameAvailable new frame available");
    synchronized (this.j)
    {
      if (!this.k)
      {
        this.k = true;
        this.j.notifyAll();
        return;
      }
      throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.localmedia.opengl.CodecOutputSurface
 * JD-Core Version:    0.7.0.1
 */