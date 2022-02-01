import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class bblm
  implements GLSurfaceView.EGLContextFactory
{
  private int jdField_a_of_type_Int = 12440;
  
  bblm(bbll parambbll) {}
  
  public EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.jdField_a_of_type_Int;
    arrayOfInt[1] = FlowDecodeScreenSurfaceBase.a(this.jdField_a_of_type_Bbll.a);
    arrayOfInt[2] = 12344;
    ykq.d("FlowEdit_FlowDecodeScreenSurfaceBase", "createContext, display=%s, config=%s, shaContext=%s", new Object[] { paramEGLDisplay, paramEGLConfig, FlowDecodeScreenSurfaceBase.a(this.jdField_a_of_type_Bbll.a) });
    EGLContext localEGLContext = FlowDecodeScreenSurfaceBase.a(this.jdField_a_of_type_Bbll.a);
    if (FlowDecodeScreenSurfaceBase.a(this.jdField_a_of_type_Bbll.a) != 0) {}
    for (;;)
    {
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
      arrayOfInt = null;
    }
  }
  
  public void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      ykq.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext);
      ykq.c("DefaultContextFactory", "tid=" + Thread.currentThread().getId());
      bblp.a("eglDestroyContex", paramEGL10.eglGetError());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblm
 * JD-Core Version:    0.7.0.1
 */