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
  private WeakReference<GLRenderView> jdField_a_of_type_JavaLangRefWeakReference;
  EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
  EGLConfig jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig;
  EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
  EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
  
  public EglHelper(WeakReference<GLRenderView> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
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
  
  public static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" failed: ");
    localStringBuilder.append(a(paramInt));
    return localStringBuilder.toString();
  }
  
  private void a(String paramString)
  {
    a(paramString, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError());
  }
  
  public static void a(String paramString, int paramInt)
  {
    throw new EglHelper.EGLException(a(paramString, paramInt));
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    QLog.w(paramString1, 1, a(paramString2, paramInt));
  }
  
  private static String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("0x");
    localStringBuilder.append(Integer.toHexString(paramInt));
    return localStringBuilder.toString();
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
    if ((localObject != null) && (localObject != EGL10.EGL_NO_SURFACE))
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      localObject = (GLRenderView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        ((GLRenderView)localObject).getEGLWindowSurfaceFactory().a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
      }
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = null;
    }
  }
  
  public int a()
  {
    if (!this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglSwapBuffers(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface)) {
      return this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError();
    }
    return 12288;
  }
  
  GL a()
  {
    GL localGL2 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext.getGL();
    GLRenderView localGLRenderView = (GLRenderView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start() tid=");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    QLog.w("[ApolloGL][EglHelper]", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = ((EGL10)EGLContext.getEGL());
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay != EGL10.EGL_NO_DISPLAY)
    {
      localObject = new int[2];
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglInitialize(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (int[])localObject))
      {
        localObject = (GLRenderView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject == null)
        {
          this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = null;
          this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
        }
        else
        {
          this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = ((GLRenderView)localObject).getEGLConfigChooser().a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay);
          this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = ((GLRenderView)localObject).getEGLContextFactory().a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig);
        }
        localObject = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
        if ((localObject == null) || (localObject == EGL10.EGL_NO_CONTEXT))
        {
          this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
          a("createContext");
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("createContext ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
        ((StringBuilder)localObject).append(" tid=");
        ((StringBuilder)localObject).append(Thread.currentThread().getId());
        QLog.w("[ApolloGL][EglHelper]", 1, ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = null;
        return;
      }
      throw new RuntimeException("eglInitialize failed");
    }
    throw new RuntimeException("eglGetDisplay failed");
  }
  
  public boolean a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createSurface()  tid=");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    QLog.w("[ApolloGL][EglHelper]", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 != null)
    {
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay != null)
      {
        if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig != null)
        {
          d();
          localObject = (GLRenderView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject != null) {
            this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = ((GLRenderView)localObject).getEGLWindowSurfaceFactory().a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, ((GLRenderView)localObject).getNativeWindow());
          } else {
            this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = null;
          }
          localObject = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
          if ((localObject != null) && (localObject != EGL10.EGL_NO_SURFACE))
          {
            localObject = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
            EGLDisplay localEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
            EGLSurface localEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
            if (!((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext))
            {
              a("[ApolloGL][EglHelper]", "eglMakeCurrent", this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError());
              return false;
            }
            return true;
          }
          int i = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError();
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
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroySurface()  tid=");
    localStringBuilder.append(Thread.currentThread().getId());
    QLog.w("[ApolloGL][EglHelper]", 1, localStringBuilder.toString());
    d();
  }
  
  public void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("finish() tid=");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    QLog.w("[ApolloGL][EglHelper]", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != null)
    {
      localObject = (GLRenderView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        ((GLRenderView)localObject).getEGLContextFactory().a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
      }
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
    }
    localObject = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
    if (localObject != null)
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglTerminate((EGLDisplay)localObject);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.EglHelper
 * JD-Core Version:    0.7.0.1
 */