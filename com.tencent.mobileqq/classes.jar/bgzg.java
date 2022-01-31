import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.view.RendererUtils;

public class bgzg
  extends bgzf
{
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private RenderBuffer b;
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (this.b == null) {
        this.b = new RenderBuffer(this.e, this.f, 33984);
      }
      this.b.bind();
      Object localObject = new float[16];
      Matrix.setIdentityM((float[])localObject, 0);
      Matrix.scaleM((float[])localObject, 0, 1.0F, -1.0F, 1.0F);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt1, null, (float[])localObject);
      this.b.unbind();
      localObject = RendererUtils.saveTexture(this.b.getTexId(), paramInt2, paramInt3);
      if (this.jdField_a_of_type_Bgyz != null) {
        this.jdField_a_of_type_Bgyz.a((Bitmap)localObject);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (this.jdField_a_of_type_Bgyz == null) {}
      this.jdField_a_of_type_Bgyz.b(103);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
  }
  
  public void a(float paramFloat) {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    GLES20.glClearColor(0.92F, 0.93F, 0.96F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt1, null, null);
    GLES20.glDisable(3042);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.g, this.h, 33984);
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.g, this.h, this.e, this.f);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.k, this.jdField_a_of_type_ArrayOfFloat, arrayOfFloat);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    int i = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
    a(i, paramInt1, paramInt2);
    if (bool)
    {
      b(i, this.e, this.f);
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ArrayOfInt[0] = i;
    this.jdField_a_of_type_ArrayOfInt[1] = i;
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    }
    if (this.b != null) {
      this.b.destroy();
    }
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgzg
 * JD-Core Version:    0.7.0.1
 */