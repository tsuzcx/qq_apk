package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.opengl.GLDebugHelper;
import android.util.Log;
import java.io.Writer;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

class GLTextureView$EglHelper
{
  private WeakReference<GLTextureView> jdField_a_of_type_JavaLangRefWeakReference;
  EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
  EGLConfig jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig;
  EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
  EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
  
  public GLTextureView$EglHelper(WeakReference<GLTextureView> paramWeakReference)
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
    throw new RuntimeException(a(paramString, paramInt));
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    Log.w(paramString1, a(paramString2, paramInt));
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
      localObject = (GLTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        GLTextureView.a((GLTextureView)localObject).a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
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
    GLTextureView localGLTextureView = (GLTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = localGL2;
    if (localGLTextureView != null)
    {
      GL localGL1 = localGL2;
      if (GLTextureView.a(localGLTextureView) != null) {
        localGL1 = GLTextureView.a(localGLTextureView).a(localGL2);
      }
      localObject = localGL1;
      if ((GLTextureView.b(localGLTextureView) & 0x3) != 0)
      {
        int i = 0;
        localObject = null;
        if ((GLTextureView.b(localGLTextureView) & 0x1) != 0) {
          i = 1;
        }
        if ((GLTextureView.b(localGLTextureView) & 0x2) != 0) {
          localObject = new GLTextureView.LogWriter();
        }
        localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
      }
    }
    return localObject;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = ((EGL10)EGLContext.getEGL());
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay != EGL10.EGL_NO_DISPLAY)
    {
      Object localObject = new int[2];
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglInitialize(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (int[])localObject))
      {
        localObject = (GLTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject == null)
        {
          this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = null;
          this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
        }
        else
        {
          this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = GLTextureView.a((GLTextureView)localObject).a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay);
          this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = GLTextureView.a((GLTextureView)localObject).a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig);
        }
        localObject = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
        if ((localObject == null) || (localObject == EGL10.EGL_NO_CONTEXT))
        {
          this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
          a("createContext");
        }
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = null;
        return;
      }
      throw new RuntimeException("eglInitialize failed");
    }
    throw new RuntimeException("eglGetDisplay failed");
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 != null)
    {
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay != null)
      {
        if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig != null)
        {
          d();
          Object localObject = (GLTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject != null) {
            this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = GLTextureView.a((GLTextureView)localObject).a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, ((GLTextureView)localObject).getSurfaceTexture());
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
              a("EGLHelper", "eglMakeCurrent", this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError());
              return false;
            }
            return true;
          }
          if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError() == 12299) {
            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
          }
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
    d();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != null)
    {
      localObject = (GLTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {
        GLTextureView.a((GLTextureView)localObject).a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
      }
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
    }
    Object localObject = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
    if (localObject != null)
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglTerminate((EGLDisplay)localObject);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.GLTextureView.EglHelper
 * JD-Core Version:    0.7.0.1
 */