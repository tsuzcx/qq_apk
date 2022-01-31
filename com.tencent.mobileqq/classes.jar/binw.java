import android.opengl.GLDebugHelper;
import android.util.Log;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.GLTextureView;
import java.io.Writer;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public class binw
{
  private WeakReference<GLTextureView> jdField_a_of_type_JavaLangRefWeakReference;
  EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
  public EGLConfig a;
  EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
  EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
  
  public binw(WeakReference<GLTextureView> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b(paramInt);
    case 12288: 
      return "EGL_SUCCESS";
    case 12289: 
      return "EGL_NOT_INITIALIZED";
    case 12290: 
      return "EGL_BAD_ACCESS";
    case 12291: 
      return "EGL_BAD_ALLOC";
    case 12292: 
      return "EGL_BAD_ATTRIBUTE";
    case 12293: 
      return "EGL_BAD_CONFIG";
    case 12294: 
      return "EGL_BAD_CONTEXT";
    case 12295: 
      return "EGL_BAD_CURRENT_SURFACE";
    case 12296: 
      return "EGL_BAD_DISPLAY";
    case 12297: 
      return "EGL_BAD_MATCH";
    case 12298: 
      return "EGL_BAD_NATIVE_PIXMAP";
    case 12299: 
      return "EGL_BAD_NATIVE_WINDOW";
    case 12300: 
      return "EGL_BAD_PARAMETER";
    case 12301: 
      return "EGL_BAD_SURFACE";
    }
    return "EGL_CONTEXT_LOST";
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + " failed: " + a(paramInt);
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
    return "0x" + Integer.toHexString(paramInt);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface != null) && (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface != EGL10.EGL_NO_SURFACE))
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      GLTextureView localGLTextureView = (GLTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localGLTextureView != null) {
        GLTextureView.a(localGLTextureView).a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
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
  
  public GL a()
  {
    GL localGL2 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext.getGL();
    GLTextureView localGLTextureView = (GLTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = localGL2;
    GL localGL1;
    int i;
    if (localGLTextureView != null)
    {
      localGL1 = localGL2;
      if (GLTextureView.a(localGLTextureView) != null) {
        localGL1 = GLTextureView.a(localGLTextureView).a(localGL2);
      }
      localObject = localGL1;
      if ((GLTextureView.b(localGLTextureView) & 0x3) != 0)
      {
        i = 0;
        if ((GLTextureView.b(localGLTextureView) & 0x1) != 0) {
          i = 1;
        }
        if ((GLTextureView.b(localGLTextureView) & 0x2) == 0) {
          break label106;
        }
      }
    }
    label106:
    for (localObject = new binz();; localObject = null)
    {
      localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
      return localObject;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = ((EGL10)EGLContext.getEGL());
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay == EGL10.EGL_NO_DISPLAY) {
      throw new RuntimeException("eglGetDisplay failed");
    }
    Object localObject = new int[2];
    if (!this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglInitialize(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (int[])localObject)) {
      throw new RuntimeException("eglInitialize failed");
    }
    localObject = (GLTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = null;
    }
    for (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;; this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = GLTextureView.a((GLTextureView)localObject).a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig))
    {
      if ((this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext == null) || (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext == EGL10.EGL_NO_CONTEXT))
      {
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
        a("createContext");
      }
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = null;
      return;
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = GLTextureView.a((GLTextureView)localObject).a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 == null) {
      throw new RuntimeException("egl not initialized");
    }
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay == null) {
      throw new RuntimeException("eglDisplay not initialized");
    }
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig == null) {
      throw new RuntimeException("mEglConfig not initialized");
    }
    d();
    GLTextureView localGLTextureView = (GLTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localGLTextureView != null) {}
    for (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = GLTextureView.a(localGLTextureView).a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, localGLTextureView.getSurfaceTexture()); (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface == null) || (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface == EGL10.EGL_NO_SURFACE); this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = null)
    {
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError() == 12299) {
        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
      }
      return false;
    }
    if (!this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext))
    {
      a("EGLHelper", "eglMakeCurrent", this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError());
      return false;
    }
    return true;
  }
  
  public void b()
  {
    d();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != null)
    {
      GLTextureView localGLTextureView = (GLTextureView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localGLTextureView != null) {
        GLTextureView.a(localGLTextureView).a(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
      }
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
    }
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay != null)
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglTerminate(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     binw
 * JD-Core Version:    0.7.0.1
 */