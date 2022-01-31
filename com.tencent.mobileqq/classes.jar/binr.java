import android.util.Log;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.GLTextureView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class binr
  implements binu
{
  private int jdField_a_of_type_Int = 12440;
  
  private binr(GLTextureView paramGLTextureView) {}
  
  public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.jdField_a_of_type_Int;
    arrayOfInt[1] = GLTextureView.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView);
    arrayOfInt[2] = 12344;
    EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
    if (GLTextureView.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView) != 0) {}
    for (;;)
    {
      return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
      arrayOfInt = null;
    }
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      Log.e("DefaultContextFactory", "display:" + paramEGLDisplay + " context: " + paramEGLContext);
      binw.a("eglDestroyContex", paramEGL10.eglGetError());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     binr
 * JD-Core Version:    0.7.0.1
 */