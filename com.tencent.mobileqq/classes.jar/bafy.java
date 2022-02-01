import android.annotation.TargetApi;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

@TargetApi(14)
public class bafy
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private bafv jdField_a_of_type_Bafv;
  private bafw jdField_a_of_type_Bafw;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_Bafw != null)
    {
      this.jdField_a_of_type_Bafw.a();
      this.jdField_a_of_type_Bafw = null;
    }
    if (this.jdField_a_of_type_Bafv != null)
    {
      this.jdField_a_of_type_Bafv.a();
      this.jdField_a_of_type_Bafv = null;
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
    this.jdField_a_of_type_Bafw.a(paramLong);
    this.jdField_a_of_type_Bafw.a();
  }
  
  public void a(bafx parambafx, Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Bafv = new bafv(parambafx.a(), 1);
    this.jdField_a_of_type_Bafw = new bafw(this.jdField_a_of_type_Bafv);
    this.jdField_a_of_type_Bafw.a(paramSurface);
    this.jdField_a_of_type_Bafw.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafy
 * JD-Core Version:    0.7.0.1
 */