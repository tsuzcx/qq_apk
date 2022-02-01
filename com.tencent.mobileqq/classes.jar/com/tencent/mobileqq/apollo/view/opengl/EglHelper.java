package com.tencent.mobileqq.apollo.view.opengl;

import android.opengl.GLDebugHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.Writer;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public class EglHelper
{
  EGL10 a;
  EGLDisplay b;
  EGLSurface c;
  EGLConfig d;
  EGLContext e;
  private WeakReference<GLRenderView> f;
  
  public EglHelper(WeakReference<GLRenderView> paramWeakReference)
  {
    this.f = paramWeakReference;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 12302: 
      return "EGL_CONTEXT_LOST";
    case 12301: 
      return "EGL_BAD_SURFACE";
    case 12300: 
      return "EGL_BAD_PARAMETER";
    case 12299: 
      return "EGL_BAD_NATIVE_WINDOW";
    case 12298: 
      return "EGL_BAD_NATIVE_PIXMAP";
    case 12297: 
      return "EGL_BAD_MATCH";
    case 12296: 
      return "EGL_BAD_DISPLAY";
    case 12295: 
      return "EGL_BAD_CURRENT_SURFACE";
    case 12294: 
      return "EGL_BAD_CONTEXT";
    case 12293: 
      return "EGL_BAD_CONFIG";
    case 12292: 
      return "EGL_BAD_ATTRIBUTE";
    case 12291: 
      return "EGL_BAD_ALLOC";
    case 12290: 
      return "EGL_BAD_ACCESS";
    case 12289: 
      return "EGL_NOT_INITIALIZED";
    }
    return "EGL_SUCCESS";
  }
  
  private void a(String paramString)
  {
    a(paramString, this.a.eglGetError());
  }
  
  public static void a(String paramString, int paramInt)
  {
    throw new EglHelper.EGLException(b(paramString, paramInt));
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    QLog.w(paramString1, 1, b(paramString2, paramInt));
  }
  
  private static String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("0x");
    localStringBuilder.append(Integer.toHexString(paramInt));
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" failed: ");
    localStringBuilder.append(a(paramInt));
    return localStringBuilder.toString();
  }
  
  private void g()
  {
    Object localObject = this.c;
    if ((localObject != null) && (localObject != EGL10.EGL_NO_SURFACE))
    {
      this.a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      localObject = (GLRenderView)this.f.get();
      if (localObject != null) {
        ((GLRenderView)localObject).getEGLWindowSurfaceFactory().a(this.a, this.b, this.c);
      }
      this.c = null;
    }
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start() tid=");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    QLog.w("[ApolloGL][EglHelper]", 1, ((StringBuilder)localObject).toString());
    this.a = ((EGL10)EGLContext.getEGL());
    this.b = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.b != EGL10.EGL_NO_DISPLAY)
    {
      localObject = new int[2];
      if (this.a.eglInitialize(this.b, (int[])localObject))
      {
        localObject = (GLRenderView)this.f.get();
        if (localObject == null)
        {
          this.d = null;
          this.e = null;
        }
        else
        {
          this.d = ((GLRenderView)localObject).getEGLConfigChooser().a(this.a, this.b);
          this.e = ((GLRenderView)localObject).getEGLContextFactory().a(this.a, this.b, this.d);
        }
        localObject = this.e;
        if ((localObject == null) || (localObject == EGL10.EGL_NO_CONTEXT))
        {
          this.e = null;
          a("createContext");
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("createContext ");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append(" tid=");
        ((StringBuilder)localObject).append(Thread.currentThread().getId());
        QLog.w("[ApolloGL][EglHelper]", 1, ((StringBuilder)localObject).toString());
        this.c = null;
        return;
      }
      throw new RuntimeException("eglInitialize failed");
    }
    throw new RuntimeException("eglGetDisplay failed");
  }
  
  public boolean b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createSurface()  tid=");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    QLog.w("[ApolloGL][EglHelper]", 1, ((StringBuilder)localObject).toString());
    if (this.a != null)
    {
      if (this.b != null)
      {
        if (this.d != null)
        {
          g();
          localObject = (GLRenderView)this.f.get();
          if (localObject != null) {
            this.c = ((GLRenderView)localObject).getEGLWindowSurfaceFactory().a(this.a, this.b, this.d, ((GLRenderView)localObject).getNativeWindow());
          } else {
            this.c = null;
          }
          localObject = this.c;
          if ((localObject != null) && (localObject != EGL10.EGL_NO_SURFACE))
          {
            localObject = this.a;
            EGLDisplay localEGLDisplay = this.b;
            EGLSurface localEGLSurface = this.c;
            if (!((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.e))
            {
              a("[ApolloGL][EglHelper]", "eglMakeCurrent", this.a.eglGetError());
              return false;
            }
            return true;
          }
          int i = this.a.eglGetError();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("createWindowSurface returned error:");
          ((StringBuilder)localObject).append(a(i));
          QLog.e("[ApolloGL][EglHelper]", 1, ((StringBuilder)localObject).toString());
          return false;
        }
        throw new RuntimeException("mEglConfig not initialized");
      }
      throw new RuntimeException("eglDisplay not initialized");
    }
    throw new RuntimeException("egl not initialized");
  }
  
  GL c()
  {
    GL localGL2 = this.e.getGL();
    GLRenderView localGLRenderView = (GLRenderView)this.f.get();
    Object localObject = localGL2;
    if (localGLRenderView != null)
    {
      GL localGL1 = localGL2;
      if (localGLRenderView.getGLWrapper() != null) {
        localGL1 = localGLRenderView.getGLWrapper().a(localGL2);
      }
      localObject = localGL1;
      if ((localGLRenderView.getDebugFlags() & 0x3) != 0)
      {
        int i = 0;
        localObject = null;
        if ((localGLRenderView.getDebugFlags() & 0x1) != 0) {
          i = 1;
        }
        if ((localGLRenderView.getDebugFlags() & 0x2) != 0) {
          localObject = new LogWriter();
        }
        localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
      }
    }
    return localObject;
  }
  
  public int d()
  {
    if (!this.a.eglSwapBuffers(this.b, this.c)) {
      return this.a.eglGetError();
    }
    return 12288;
  }
  
  public void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroySurface()  tid=");
    localStringBuilder.append(Thread.currentThread().getId());
    QLog.w("[ApolloGL][EglHelper]", 1, localStringBuilder.toString());
    g();
  }
  
  public void f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("finish() tid=");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    QLog.w("[ApolloGL][EglHelper]", 1, ((StringBuilder)localObject).toString());
    if (this.e != null)
    {
      localObject = (GLRenderView)this.f.get();
      if (localObject != null) {
        ((GLRenderView)localObject).getEGLContextFactory().a(this.a, this.b, this.e);
      }
      this.e = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      this.a.eglTerminate((EGLDisplay)localObject);
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.EglHelper
 * JD-Core Version:    0.7.0.1
 */