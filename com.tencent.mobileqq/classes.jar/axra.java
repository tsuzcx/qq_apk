import android.annotation.TargetApi;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

@TargetApi(14)
public class axra
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private axqx jdField_a_of_type_Axqx;
  private axqy jdField_a_of_type_Axqy;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_Axqy != null)
    {
      this.jdField_a_of_type_Axqy.a();
      this.jdField_a_of_type_Axqy = null;
    }
    if (this.jdField_a_of_type_Axqx != null)
    {
      this.jdField_a_of_type_Axqx.a();
      this.jdField_a_of_type_Axqx = null;
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
    this.jdField_a_of_type_Axqy.a(paramLong);
    this.jdField_a_of_type_Axqy.a();
  }
  
  public void a(axqz paramaxqz, Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Axqx = new axqx(paramaxqz.a(), 1);
    this.jdField_a_of_type_Axqy = new axqy(this.jdField_a_of_type_Axqx);
    this.jdField_a_of_type_Axqy.a(paramSurface);
    this.jdField_a_of_type_Axqy.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axra
 * JD-Core Version:    0.7.0.1
 */