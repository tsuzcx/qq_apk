import android.annotation.TargetApi;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

@TargetApi(14)
public class batk
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private bath jdField_a_of_type_Bath;
  private bati jdField_a_of_type_Bati;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_Bati != null)
    {
      this.jdField_a_of_type_Bati.a();
      this.jdField_a_of_type_Bati = null;
    }
    if (this.jdField_a_of_type_Bath != null)
    {
      this.jdField_a_of_type_Bath.a();
      this.jdField_a_of_type_Bath = null;
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
    this.jdField_a_of_type_Bati.a(paramLong);
    this.jdField_a_of_type_Bati.a();
  }
  
  public void a(batj parambatj, Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Bath = new bath(parambatj.a(), 1);
    this.jdField_a_of_type_Bati = new bati(this.jdField_a_of_type_Bath);
    this.jdField_a_of_type_Bati.a(paramSurface);
    this.jdField_a_of_type_Bati.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batk
 * JD-Core Version:    0.7.0.1
 */