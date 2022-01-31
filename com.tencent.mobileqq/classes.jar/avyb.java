import android.opengl.GLSurfaceView.EGLConfigChooser;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public abstract class avyb
  implements GLSurfaceView.EGLConfigChooser
{
  protected int[] a;
  
  public avyb(FlowDecodeScreenSurfaceBase paramFlowDecodeScreenSurfaceBase, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ArrayOfInt = a(paramArrayOfInt);
  }
  
  private int[] a(int[] paramArrayOfInt)
  {
    if ((FlowDecodeScreenSurfaceBase.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase) != 2) && (FlowDecodeScreenSurfaceBase.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase) != 3)) {
      return paramArrayOfInt;
    }
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i + 2];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i - 1);
    arrayOfInt[(i - 1)] = 12352;
    if (FlowDecodeScreenSurfaceBase.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeScreenSurfaceBase) == 2) {
      arrayOfInt[i] = 4;
    }
    for (;;)
    {
      arrayOfInt[(i + 1)] = 12344;
      return arrayOfInt;
      arrayOfInt[i] = 64;
    }
  }
  
  abstract EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
  
  public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.jdField_a_of_type_ArrayOfInt, null, 0, arrayOfInt)) {
      throw new IllegalArgumentException("eglChooseConfig failed");
    }
    int i = arrayOfInt[0];
    if (i <= 0) {
      throw new IllegalArgumentException("No configs match configSpec");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.jdField_a_of_type_ArrayOfInt, arrayOfEGLConfig, i, arrayOfInt)) {
      throw new IllegalArgumentException("eglChooseConfig#2 failed");
    }
    paramEGL10 = a(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    if (paramEGL10 == null) {
      throw new IllegalArgumentException("No config chosen");
    }
    return paramEGL10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avyb
 * JD-Core Version:    0.7.0.1
 */