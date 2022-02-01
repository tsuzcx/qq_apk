import android.view.animation.Transformation;
import com.tencent.mobileqq.portal.ImageAlphaSwitchView;

public class azua
  implements bhtj<Float>
{
  public azua(ImageAlphaSwitchView paramImageAlphaSwitchView) {}
  
  public void a(bhtd<Float> parambhtd, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    this.a.jdField_a_of_type_Float = paramFloat1.floatValue();
    if (paramFloat1.floatValue() >= 255.0F)
    {
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = this.a.b;
      this.a.b = null;
      this.a.jdField_a_of_type_Float = 0.0F;
      if (this.a.jdField_a_of_type_Bhtd != null)
      {
        this.a.jdField_a_of_type_Bhtd.cancel();
        this.a.jdField_a_of_type_Bhtd = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azua
 * JD-Core Version:    0.7.0.1
 */