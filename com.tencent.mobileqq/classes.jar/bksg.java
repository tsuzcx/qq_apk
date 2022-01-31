import android.opengl.GLSurfaceView.EGLContextFactory;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class bksg
  implements GLSurfaceView.EGLContextFactory
{
  private int jdField_a_of_type_Int = 12440;
  
  public bksg(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int i = this.jdField_a_of_type_Int;
    paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { i, 2, 12344 });
    bljn.d("AECameraGLSurfaceView", "[EGLContext] createContext finish");
    return paramEGL10;
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (paramEGLDisplay == null) {
      bljn.d("AECameraGLSurfaceView", "EGLDisplay is null.");
    }
    AECameraGLSurfaceView.a(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    bljn.d("AECameraGLSurfaceView", "[EGLContext] destroyContext finish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksg
 * JD-Core Version:    0.7.0.1
 */