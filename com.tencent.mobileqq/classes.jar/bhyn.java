import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class bhyn
  implements GLSurfaceView.EGLContextFactory
{
  private int jdField_a_of_type_Int = 12440;
  
  private bhyn(bhyi parambhyi) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int i = this.jdField_a_of_type_Int;
    bhyi.a(this.jdField_a_of_type_Bhyi, paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 }));
    return bhyi.a(this.jdField_a_of_type_Bhyi);
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext)) {
      QLog.e("VipARCameraController", 2, new Object[] { "DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhyn
 * JD-Core Version:    0.7.0.1
 */