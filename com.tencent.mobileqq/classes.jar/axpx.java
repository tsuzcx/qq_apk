import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.FlowDecodeScreenSurfaceBase;
import com.tencent.ttpic.openapi.filter.TextureRender;
import javax.microedition.khronos.egl.EGLContext;

public class axpx
  extends FlowDecodeScreenSurfaceBase
  implements SurfaceTexture.OnFrameAvailableListener, axqf
{
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private axqg jdField_a_of_type_Axqg;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int c;
  
  public axpx(EGLContext paramEGLContext, int paramInt1, int paramInt2)
  {
    super(paramEGLContext, paramInt1, paramInt2);
    c();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.c = axqh.a(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.c);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_Axqg = new axqg(paramInt1, paramInt2);
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
  
  public void a(@NonNull axpr paramaxpr, boolean paramBoolean)
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
          catch (InterruptedException paramaxpr)
          {
            throw new RuntimeException(paramaxpr);
          }
        }
      }
    }
    axqh.a("before updateTexImage");
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
    paramaxpr.jdField_a_of_type_ArrayOfFloat = ((float[])this.jdField_a_of_type_ArrayOfFloat.clone());
    this.jdField_a_of_type_Axqg.a(paramaxpr.a());
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.c, null, null);
    this.jdField_a_of_type_Axqg.a();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b()
  {
    wsv.b("FlowEdit_FlowDecodeScreenSurface", "awaitNewImage");
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    wsv.b("FlowEdit_FlowDecodeScreenSurface", "onFrameAvailable");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean) {
        wsv.d("FlowEdit_FlowDecodeScreenSurface", "mFrameAvailable already set, frame could be dropped");
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axpx
 * JD-Core Version:    0.7.0.1
 */