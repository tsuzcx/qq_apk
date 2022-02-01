import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import java.lang.reflect.Method;

@TargetApi(18)
public class bqjo
{
  EGLContext jdField_a_of_type_AndroidOpenglEGLContext;
  EGLDisplay jdField_a_of_type_AndroidOpenglEGLDisplay;
  EGLSurface jdField_a_of_type_AndroidOpenglEGLSurface;
  Surface jdField_a_of_type_AndroidViewSurface;
  
  public bqjo(Surface paramSurface)
  {
    if (paramSurface == null) {
      throw new NullPointerException();
    }
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    a();
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.jdField_a_of_type_AndroidOpenglEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("unable to get EGL14 display");
    }
    Object localObject = new int[2];
    if (!EGL14.eglInitialize(this.jdField_a_of_type_AndroidOpenglEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
    {
      this.jdField_a_of_type_AndroidOpenglEGLDisplay = null;
      throw new RuntimeException("unable to initialize EGL14");
    }
    localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGLDisplay localEGLDisplay = this.jdField_a_of_type_AndroidOpenglEGLDisplay;
    int i = localObject.length;
    if (!EGL14.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344 }, 0, (EGLConfig[])localObject, 0, i, arrayOfInt, 0)) {
      throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
    }
    this.jdField_a_of_type_AndroidOpenglEGLContext = EGL14.eglCreateContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, localObject[0], EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    a("eglCreateContext");
    if (this.jdField_a_of_type_AndroidOpenglEGLContext == null) {
      throw new RuntimeException("null context");
    }
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.eglCreateWindowSurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, localObject[0], this.jdField_a_of_type_AndroidViewSurface, new int[] { 12344 }, 0);
    a("eglCreateWindowSurface");
    if (this.jdField_a_of_type_AndroidOpenglEGLSurface == null) {
      throw new RuntimeException("surface was null");
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      Class.forName("android.opengl.EGLExt").getDeclaredMethod("eglPresentationTimeANDROID", new Class[] { EGLDisplay.class, EGLSurface.class, Long.TYPE }).invoke(null, new Object[] { this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLSurface, Long.valueOf(paramLong) });
      return;
    }
    catch (Exception localException) {}
  }
  
  void a(String paramString)
  {
    for (int i = 0;; i = 1)
    {
      int j = EGL14.eglGetError();
      if (j == 12288) {
        break;
      }
      Log.e("InputSurface", paramString + ": EGL error: 0x" + Integer.toHexString(j));
    }
    if (i != 0) {
      throw new RuntimeException("EGL error encountered (see log)");
    }
  }
  
  public boolean a()
  {
    return EGL14.eglSwapBuffers(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLSurface);
  }
  
  public void b()
  {
    if (EGL14.eglGetCurrentContext().equals(this.jdField_a_of_type_AndroidOpenglEGLContext)) {
      EGL14.eglMakeCurrent(this.jdField_a_of_type_AndroidOpenglEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
    }
    EGL14.eglDestroySurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLSurface);
    EGL14.eglDestroyContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLContext);
    this.jdField_a_of_type_AndroidViewSurface.release();
    this.jdField_a_of_type_AndroidOpenglEGLDisplay = null;
    this.jdField_a_of_type_AndroidOpenglEGLContext = null;
    this.jdField_a_of_type_AndroidOpenglEGLSurface = null;
    this.jdField_a_of_type_AndroidViewSurface = null;
  }
  
  public void c()
  {
    if (!EGL14.eglMakeCurrent(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLSurface, this.jdField_a_of_type_AndroidOpenglEGLSurface, this.jdField_a_of_type_AndroidOpenglEGLContext)) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqjo
 * JD-Core Version:    0.7.0.1
 */