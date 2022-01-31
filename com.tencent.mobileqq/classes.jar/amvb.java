import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class amvb
{
  private axvh jdField_a_of_type_Axvh;
  private EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = (EGL10)EGLContext.getEGL();
  private EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetCurrentContext();
  private EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetCurrentDisplay();
  private EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetCurrentSurface(12377);
  
  public amvb(axvg paramaxvg, Surface paramSurface)
  {
    this.jdField_a_of_type_Axvh = new axvh(paramaxvg);
    this.jdField_a_of_type_Axvh.a(paramSurface);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Axvh.a(paramLong);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Axvh.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Axvh.a();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Axvh != null)
    {
      this.jdField_a_of_type_Axvh.a();
      this.jdField_a_of_type_Axvh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvb
 * JD-Core Version:    0.7.0.1
 */