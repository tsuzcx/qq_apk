import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGLContext;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

public final class auyc
  implements SurfaceTexture.OnFrameAvailableListener, auyl
{
  private int jdField_a_of_type_Int;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private auym jdField_a_of_type_Auym;
  private auzd jdField_a_of_type_Auzd;
  private auze jdField_a_of_type_Auze;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int b;
  private int c;
  
  public auyc(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Auzd = new auzd(paramEGLContext, 1);
    this.jdField_a_of_type_Auze = new auze(this.jdField_a_of_type_Auzd);
    this.jdField_a_of_type_Auze.a(paramInt1, paramInt2);
    this.jdField_a_of_type_Auze.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.c = auyn.a(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.c);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_Auym = new auym(this.jdField_a_of_type_Int, this.b);
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
  }
  
  public Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Auzd != null)
    {
      this.jdField_a_of_type_Auzd.a();
      this.jdField_a_of_type_Auzd = null;
    }
    if (this.jdField_a_of_type_Auze != null)
    {
      this.jdField_a_of_type_Auze.a();
      this.jdField_a_of_type_Auze = null;
    }
    this.jdField_a_of_type_AndroidViewSurface.release();
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
    this.jdField_a_of_type_Auym.b();
    this.jdField_a_of_type_Auym = null;
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    this.jdField_a_of_type_AndroidViewSurface = null;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
  }
  
  public void a(@NonNull auxx paramauxx, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
    paramauxx.jdField_a_of_type_ArrayOfFloat = ((float[])this.jdField_a_of_type_ArrayOfFloat.clone());
    this.jdField_a_of_type_Auym.a(paramauxx.a());
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.c, null, null);
    this.jdField_a_of_type_Auym.a();
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
    auyn.a("before updateTexImage");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auyc
 * JD-Core Version:    0.7.0.1
 */