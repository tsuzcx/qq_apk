import android.annotation.TargetApi;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

@TargetApi(14)
public class auzg
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private auzd jdField_a_of_type_Auzd;
  private auze jdField_a_of_type_Auze;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_Auze != null)
    {
      this.jdField_a_of_type_Auze.a();
      this.jdField_a_of_type_Auze = null;
    }
    if (this.jdField_a_of_type_Auzd != null)
    {
      this.jdField_a_of_type_Auzd.a();
      this.jdField_a_of_type_Auzd = null;
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
    this.jdField_a_of_type_Auze.a(paramLong);
    this.jdField_a_of_type_Auze.a();
  }
  
  public void a(auzf paramauzf, Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Auzd = new auzd(paramauzf.a(), 1);
    this.jdField_a_of_type_Auze = new auze(this.jdField_a_of_type_Auzd);
    this.jdField_a_of_type_Auze.a(paramSurface);
    this.jdField_a_of_type_Auze.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auzg
 * JD-Core Version:    0.7.0.1
 */