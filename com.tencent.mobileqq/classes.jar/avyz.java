import android.annotation.TargetApi;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

@TargetApi(14)
public class avyz
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private avyw jdField_a_of_type_Avyw;
  private avyx jdField_a_of_type_Avyx;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_Avyx != null)
    {
      this.jdField_a_of_type_Avyx.a();
      this.jdField_a_of_type_Avyx = null;
    }
    if (this.jdField_a_of_type_Avyw != null)
    {
      this.jdField_a_of_type_Avyw.a();
      this.jdField_a_of_type_Avyw = null;
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
    this.jdField_a_of_type_Avyx.a(paramLong);
    this.jdField_a_of_type_Avyx.a();
  }
  
  public void a(avyy paramavyy, Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Avyw = new avyw(paramavyy.a(), 1);
    this.jdField_a_of_type_Avyx = new avyx(this.jdField_a_of_type_Avyw);
    this.jdField_a_of_type_Avyx.a(paramSurface);
    this.jdField_a_of_type_Avyx.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avyz
 * JD-Core Version:    0.7.0.1
 */