import android.annotation.TargetApi;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

@TargetApi(14)
public class avzb
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private avyy jdField_a_of_type_Avyy;
  private avyz jdField_a_of_type_Avyz;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_Avyz != null)
    {
      this.jdField_a_of_type_Avyz.a();
      this.jdField_a_of_type_Avyz = null;
    }
    if (this.jdField_a_of_type_Avyy != null)
    {
      this.jdField_a_of_type_Avyy.a();
      this.jdField_a_of_type_Avyy = null;
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
    this.jdField_a_of_type_Avyz.a(paramLong);
    this.jdField_a_of_type_Avyz.a();
  }
  
  public void a(avza paramavza, Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Avyy = new avyy(paramavza.a(), 1);
    this.jdField_a_of_type_Avyz = new avyz(this.jdField_a_of_type_Avyy);
    this.jdField_a_of_type_Avyz.a(paramSurface);
    this.jdField_a_of_type_Avyz.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avzb
 * JD-Core Version:    0.7.0.1
 */