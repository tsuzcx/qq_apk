import android.annotation.TargetApi;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

@TargetApi(14)
public class bbmd
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private bbma jdField_a_of_type_Bbma;
  private bbmb jdField_a_of_type_Bbmb;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_Bbmb != null)
    {
      this.jdField_a_of_type_Bbmb.a();
      this.jdField_a_of_type_Bbmb = null;
    }
    if (this.jdField_a_of_type_Bbma != null)
    {
      this.jdField_a_of_type_Bbma.a();
      this.jdField_a_of_type_Bbma = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
    this.jdField_a_of_type_Bbmb.a(paramLong);
    this.jdField_a_of_type_Bbmb.a();
  }
  
  public void a(bbmc parambbmc, Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Bbma = new bbma(parambbmc.a(), 1);
    this.jdField_a_of_type_Bbmb = new bbmb(this.jdField_a_of_type_Bbma);
    this.jdField_a_of_type_Bbmb.a(paramSurface);
    this.jdField_a_of_type_Bbmb.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmd
 * JD-Core Version:    0.7.0.1
 */