import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.view.RendererUtils;

public class bktg
  extends bktf
{
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private RenderBuffer b;
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) {
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.e, this.f, 33984);
      }
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      Object localObject = new float[16];
      Matrix.setIdentityM((float[])localObject, 0);
      Matrix.scaleM((float[])localObject, 0, 1.0F, -1.0F, 1.0F);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt1, null, (float[])localObject);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      localObject = RendererUtils.saveTexture(this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), paramInt2, paramInt3);
      if (this.jdField_a_of_type_Bkte != null) {
        this.jdField_a_of_type_Bkte.a((Bitmap)localObject);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (this.jdField_a_of_type_Bkte == null) {}
      this.jdField_a_of_type_Bkte.b(103);
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
  
  public void a(boolean paramBoolean) {}
  
  public int[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.g == 0) || (this.h == 0)) {
      return this.jdField_a_of_type_ArrayOfInt;
    }
    paramBoolean = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.g, this.h, 33984);
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    int i = this.e;
    int j = (int)(this.e / this.jdField_b_of_type_Double);
    float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.g, this.h, i, j);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.k, this.jdField_a_of_type_ArrayOfFloat, arrayOfFloat);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    int k = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
    a(k, paramInt1, paramInt2);
    if (paramBoolean)
    {
      b(k, i, j);
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ArrayOfInt[0] = k;
    this.jdField_a_of_type_ArrayOfInt[1] = k;
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
    if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    }
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
    }
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktg
 * JD-Core Version:    0.7.0.1
 */