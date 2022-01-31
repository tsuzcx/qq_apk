import android.opengl.GLSurfaceView.EGLContextFactory;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class bijr
  implements GLSurfaceView.EGLContextFactory
{
  private int jdField_a_of_type_Int = 12440;
  
  public bijr(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int i = this.jdField_a_of_type_Int;
    paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
    bjah.b("AECameraGLSurfaceView", "[EGLContext] createContext finish");
    return paramEGL10;
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    AECameraGLSurfaceView.a(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    bjah.b("AECameraGLSurfaceView", "[EGLContext] destroyContext finish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bijr
 * JD-Core Version:    0.7.0.1
 */