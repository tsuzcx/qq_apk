import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGLContext;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

public final class bbkz
  implements SurfaceTexture.OnFrameAvailableListener, bbli
{
  private int jdField_a_of_type_Int;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private bblj jdField_a_of_type_Bblj;
  private bbma jdField_a_of_type_Bbma;
  private bbmb jdField_a_of_type_Bbmb;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int b;
  private int c;
  
  public bbkz(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Bbma = new bbma(paramEGLContext, 1);
    this.jdField_a_of_type_Bbmb = new bbmb(this.jdField_a_of_type_Bbma);
    this.jdField_a_of_type_Bbmb.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Bbmb.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.c = bblk.a(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.c);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_Bblj = new bblj(this.jdField_a_of_type_Int, this.b);
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
  }
  
  public Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbma != null)
    {
      this.jdField_a_of_type_Bbma.a();
      this.jdField_a_of_type_Bbma = null;
    }
    if (this.jdField_a_of_type_Bbmb != null)
    {
      this.jdField_a_of_type_Bbmb.a();
      this.jdField_a_of_type_Bbmb = null;
    }
    this.jdField_a_of_type_AndroidViewSurface.release();
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
    this.jdField_a_of_type_Bblj.b();
    this.jdField_a_of_type_Bblj = null;
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    this.jdField_a_of_type_AndroidViewSurface = null;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
  }
  
  public void a(@NonNull bbku parambbku, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
    parambbku.jdField_a_of_type_ArrayOfFloat = ((float[])this.jdField_a_of_type_ArrayOfFloat.clone());
    this.jdField_a_of_type_Bblj.a(parambbku.a());
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.c, null, null);
    this.jdField_a_of_type_Bblj.a();
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      for (;;)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {
          try
          {
            this.jdField_a_of_type_JavaLangObject.wait();
            if (!this.jdField_a_of_type_Boolean) {
              throw new RuntimeException("frame wait timed out");
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new RuntimeException(localInterruptedException);
          }
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    bblk.a("before updateTexImage");
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean) {
        throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
      }
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkz
 * JD-Core Version:    0.7.0.1
 */