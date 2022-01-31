import android.view.animation.Transformation;
import com.tencent.mobileqq.portal.ImageAlphaSwitchView;

public class awio
  implements bdjy<Float>
{
  public awio(ImageAlphaSwitchView paramImageAlphaSwitchView) {}
  
  public void a(bdjs<Float> parambdjs, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    this.a.jdField_a_of_type_Float = paramFloat1.floatValue();
    if (paramFloat1.floatValue() >= 255.0F)
    {
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = this.a.b;
      this.a.b = null;
      this.a.jdField_a_of_type_Float = 0.0F;
      if (this.a.jdField_a_of_type_Bdjs != null)
      {
        this.a.jdField_a_of_type_Bdjs.cancel();
        this.a.jdField_a_of_type_Bdjs = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awio
 * JD-Core Version:    0.7.0.1
 */