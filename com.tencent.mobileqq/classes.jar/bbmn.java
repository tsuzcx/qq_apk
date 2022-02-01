import android.annotation.TargetApi;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

@TargetApi(14)
public class bbmn
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private bbmk jdField_a_of_type_Bbmk;
  private bbml jdField_a_of_type_Bbml;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_Bbml != null)
    {
      this.jdField_a_of_type_Bbml.a();
      this.jdField_a_of_type_Bbml = null;
    }
    if (this.jdField_a_of_type_Bbmk != null)
    {
      this.jdField_a_of_type_Bbmk.a();
      this.jdField_a_of_type_Bbmk = null;
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
    this.jdField_a_of_type_Bbml.a(paramLong);
    this.jdField_a_of_type_Bbml.a();
  }
  
  public void a(bbmm parambbmm, Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Bbmk = new bbmk(parambbmm.a(), 1);
    this.jdField_a_of_type_Bbml = new bbml(this.jdField_a_of_type_Bbmk);
    this.jdField_a_of_type_Bbml.a(paramSurface);
    this.jdField_a_of_type_Bbml.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmn
 * JD-Core Version:    0.7.0.1
 */