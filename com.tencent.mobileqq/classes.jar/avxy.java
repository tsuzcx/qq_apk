import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase;
import com.tencent.ttpic.openapi.filter.TextureRender;
import javax.microedition.khronos.egl.EGLContext;

public class avxy
  extends FlowDecodeScreenSurfaceBase
  implements SurfaceTexture.OnFrameAvailableListener, avyg
{
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private avyh jdField_a_of_type_Avyh;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int c;
  
  public avxy(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    super(paramEGLContext, paramInt1, paramInt2);
    c();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.c = avyi.a(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.c);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_Avyh = new avyh(paramInt1, paramInt2);
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
  }
  
  public Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(@NonNull avxs paramavxs, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      for (;;)
      {
        paramBoolean = this.jdField_a_of_type_Boolean;
        if (!paramBoolean) {
          try
          {
            this.jdField_a_of_type_JavaLangObject.wait();
            if (!this.jdField_a_of_type_Boolean) {
              throw new RuntimeException("frame wait timed out");
            }
          }
          catch (InterruptedException paramavxs)
          {
            throw new RuntimeException(paramavxs);
          }
        }
      }
    }
    avyi.a("before updateTexImage");
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
    paramavxs.jdField_a_of_type_ArrayOfFloat = ((float[])this.jdField_a_of_type_ArrayOfFloat.clone());
    this.jdField_a_of_type_Avyh.a(paramavxs.a());
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.c, null, null);
    this.jdField_a_of_type_Avyh.a();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b()
  {
    ved.b("FlowEdit_FlowDecodeScreenSurface", "awaitNewImage");
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    ved.b("FlowEdit_FlowDecodeScreenSurface", "onFrameAvailable");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean) {
        ved.d("FlowEdit_FlowDecodeScreenSurface", "mFrameAvailable already set, frame could be dropped");
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avxy
 * JD-Core Version:    0.7.0.1
 */