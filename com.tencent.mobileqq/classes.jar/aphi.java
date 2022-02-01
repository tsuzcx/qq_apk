import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class aphi
{
  private bbmb jdField_a_of_type_Bbmb;
  private EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = (EGL10)EGLContext.getEGL();
  private EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetCurrentContext();
  private EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetCurrentDisplay();
  private EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetCurrentSurface(12377);
  
  public aphi(bbma parambbma, Surface paramSurface)
  {
    this.jdField_a_of_type_Bbmb = new bbmb(parambbma);
    this.jdField_a_of_type_Bbmb.a(paramSurface);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Bbmb.a(paramLong);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bbmb.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bbmb.a();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bbmb != null)
    {
      this.jdField_a_of_type_Bbmb.a();
      this.jdField_a_of_type_Bbmb = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphi
 * JD-Core Version:    0.7.0.1
 */