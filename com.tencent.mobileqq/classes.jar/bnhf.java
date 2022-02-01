import android.opengl.GLSurfaceView.EGLContextFactory;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class bnhf
  implements GLSurfaceView.EGLContextFactory
{
  private final int jdField_a_of_type_Int = 12440;
  
  public bnhf(AECameraGLSurfaceView paramAECameraGLSurfaceView) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    bnzb.d("AECameraGLSurfaceView", "[EGLContext] createContext finish");
    return paramEGL10;
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    bnzb.d("AECameraGLSurfaceView", "[EGLContext] destroyContext start");
    if (paramEGLDisplay == null) {
      bnzb.d("AECameraGLSurfaceView", "EGLDisplay is null.");
    }
    AECameraGLSurfaceView.a(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    bnzb.d("AECameraGLSurfaceView", "[EGLContext] destroyContext finish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhf
 * JD-Core Version:    0.7.0.1
 */