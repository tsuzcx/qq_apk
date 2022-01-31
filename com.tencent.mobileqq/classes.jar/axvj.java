import android.annotation.TargetApi;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

@TargetApi(14)
public class axvj
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private axvg jdField_a_of_type_Axvg;
  private axvh jdField_a_of_type_Axvh;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_Axvh != null)
    {
      this.jdField_a_of_type_Axvh.a();
      this.jdField_a_of_type_Axvh = null;
    }
    if (this.jdField_a_of_type_Axvg != null)
    {
      this.jdField_a_of_type_Axvg.a();
      this.jdField_a_of_type_Axvg = null;
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
    this.jdField_a_of_type_Axvh.a(paramLong);
    this.jdField_a_of_type_Axvh.a();
  }
  
  public void a(axvi paramaxvi, Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Axvg = new axvg(paramaxvi.a(), 1);
    this.jdField_a_of_type_Axvh = new axvh(this.jdField_a_of_type_Axvg);
    this.jdField_a_of_type_Axvh.a(paramSurface);
    this.jdField_a_of_type_Axvh.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axvj
 * JD-Core Version:    0.7.0.1
 */