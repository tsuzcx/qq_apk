import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class ampm
  implements ampp
{
  public EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
  {
    EGLSurface localEGLSurface = null;
    if (paramObject != null) {}
    try
    {
      localEGLSurface = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
      return localEGLSurface;
    }
    catch (Throwable paramEGL10)
    {
      Log.e("GLTextureView", "eglCreateWindowSurface", paramEGL10);
    }
    return null;
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampm
 * JD-Core Version:    0.7.0.1
 */