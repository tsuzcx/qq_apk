import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(14)
public class awmv
  implements SurfaceTexture.OnFrameAvailableListener
{
  SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  public Surface a;
  awmw jdField_a_of_type_Awmw;
  Object jdField_a_of_type_JavaLangObject = new Object();
  EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
  EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
  EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
  boolean jdField_a_of_type_Boolean;
  
  public awmv()
  {
    a();
  }
  
  void a()
  {
    this.jdField_a_of_type_Awmw = new awmw();
    this.jdField_a_of_type_Awmw.a();
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_Awmw.a());
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 != null)
    {
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetCurrentContext().equals(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)) {
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      }
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroySurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroyContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    }
    this.jdField_a_of_type_AndroidViewSurface.release();
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = null;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = null;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = null;
    this.jdField_a_of_type_Awmw = null;
    this.jdField_a_of_type_AndroidViewSurface = null;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
  }
  
  @SuppressLint({"NewApi"})
  public void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      for (;;)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {
          try
          {
            this.jdField_a_of_type_JavaLangObject.wait(5000L);
            if (!this.jdField_a_of_type_Boolean) {
              throw new RuntimeException("Surface frame wait timed out");
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Awmw.a("before updateTexImage");
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Awmw.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean) {
        throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
      }
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awmv
 * JD-Core Version:    0.7.0.1
 */