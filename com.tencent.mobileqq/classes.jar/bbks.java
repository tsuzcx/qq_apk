import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder;
import com.tencent.ttpic.video.AEDecoder;

public class bbks
  implements SurfaceTexture.OnFrameAvailableListener, bblb, AEDecoder
{
  private final int jdField_a_of_type_Int = 1;
  private bbky jdField_a_of_type_Bbky;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private SurfaceTextureFilter jdField_a_of_type_ComTencentFilterSurfaceTextureFilter;
  private HWVideoDecoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder = new HWVideoDecoder();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private final int b = 2;
  private final int c = 3;
  private final int d = 4;
  private final int e = 5;
  private final int f = 6;
  private int g = 1;
  private int h = -1;
  private int i = -1;
  private int j;
  private int k;
  
  public bbks(String paramString)
  {
    this.jdField_a_of_type_Bbky = new bbky(paramString, 0, false, false);
  }
  
  private void a()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.k = arrayOfInt[0];
    this.jdField_a_of_type_ComTencentFilterSurfaceTextureFilter = new SurfaceTextureFilter();
    this.jdField_a_of_type_ComTencentFilterSurfaceTextureFilter.apply();
  }
  
  private void b()
  {
    GLES20.glDeleteTextures(1, new int[] { this.k }, 0);
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_a_of_type_ComTencentFilterSurfaceTextureFilter.clearGLSLSelf();
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    this.g = 6;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
  }
  
  public void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.g != 2) {
        this.jdField_a_of_type_JavaLangObject.wait();
      }
    }
    this.g = 3;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
  }
  
  public void b(long paramLong) {}
  
  public void g() {}
  
  public int getNextFrameTexture()
  {
    int m = -1;
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.g == 4) || (this.g == 5) || (this.g == 6)) {
          break label152;
        }
        this.jdField_a_of_type_JavaLangObject.wait();
      }
      if (this.g != 4) {}
    }
    catch (InterruptedException localInterruptedException) {}
    label152:
    for (;;)
    {
      if ((this.h == -1) || (this.i == -1))
      {
        this.h = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.a();
        this.i = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.b();
      }
      this.jdField_a_of_type_ComTencentFilterSurfaceTextureFilter.updateMatrix(this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_ComTencentFilterSurfaceTextureFilter.RenderProcess(this.k, this.h, this.i, this.j, 0.0D, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      this.g = 2;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      m = 0;
      return m;
    }
  }
  
  public void j()
  {
    this.g = 5;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
  }
  
  public void k() {}
  
  public void l() {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture.updateTexImage();
    paramSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
    this.g = 4;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
  }
  
  public void release()
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.a();
  }
  
  public void setTexture(int paramInt)
  {
    a();
    this.j = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.a(this.jdField_a_of_type_Bbky, this.k, this, this);
    this.g = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbks
 * JD-Core Version:    0.7.0.1
 */