import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.mobileqq.ar.ARGLSurfaceView;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class apeo
  implements GLSurfaceView.EGLContextFactory
{
  private int jdField_a_of_type_Int = 12440;
  
  public apeo(ARGLSurfaceView paramARGLSurfaceView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    QLog.i("AREngine_ARGLSurfaceView", 1, "createContext. display = " + paramEGLDisplay);
    int i = this.jdField_a_of_type_Int;
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (ARGLSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView) != null) {
      ARGLSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView).a();
    }
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext)) {
      QLog.e("AREngine_ARGLSurfaceView", 1, "destroyContext. display = " + paramEGLDisplay + " context = " + paramEGLContext + " tid = " + Thread.currentThread().getId());
    }
    QLog.i("AREngine_ARGLSurfaceView", 1, "destroyContext. display = " + paramEGLDisplay + " context = " + paramEGLContext + " tid = " + Thread.currentThread().getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apeo
 * JD-Core Version:    0.7.0.1
 */