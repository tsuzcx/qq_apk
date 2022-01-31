import android.view.animation.Transformation;
import com.tencent.mobileqq.portal.ImageAlphaSwitchView;

public class aura
  implements bbkq<Float>
{
  public aura(ImageAlphaSwitchView paramImageAlphaSwitchView) {}
  
  public void a(bbkk<Float> parambbkk, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    this.a.jdField_a_of_type_Float = paramFloat1.floatValue();
    if (paramFloat1.floatValue() >= 255.0F)
    {
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = this.a.b;
      this.a.b = null;
      this.a.jdField_a_of_type_Float = 0.0F;
      if (this.a.jdField_a_of_type_Bbkk != null)
      {
        this.a.jdField_a_of_type_Bbkk.cancel();
        this.a.jdField_a_of_type_Bbkk = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aura
 * JD-Core Version:    0.7.0.1
 */