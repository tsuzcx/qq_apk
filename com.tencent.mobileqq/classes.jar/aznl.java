import android.view.animation.Transformation;
import com.tencent.mobileqq.portal.ImageShakeAnimView;

public class aznl
  implements bhir<Float>
{
  public aznl(ImageShakeAnimView paramImageShakeAnimView) {}
  
  public void a(bhil<Float> parambhil, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    if (this.a.jdField_a_of_type_Boolean)
    {
      if (paramFloat1.floatValue() < 180.0F)
      {
        this.a.jdField_a_of_type_Float = (1.0F - paramFloat1.floatValue() * 0.01F / 180.0F);
        this.a.b = (0.02F * paramFloat1.floatValue() / 180.0F + 1.0F);
        return;
      }
      if (paramFloat1.floatValue() < 360.0F)
      {
        parambhil = Float.valueOf(paramFloat1.floatValue() - 180.0F);
        this.a.jdField_a_of_type_Float = (0.99F + 0.03F * parambhil.floatValue() / 180.0F);
        this.a.b = (1.02F - parambhil.floatValue() * 0.04F / 180.0F);
        return;
      }
      if (paramFloat1.floatValue() < 540.0F)
      {
        parambhil = Float.valueOf(paramFloat1.floatValue() - 360.0F);
        this.a.jdField_a_of_type_Float = (1.02F - 0.03F * parambhil.floatValue() / 180.0F);
        this.a.b = (parambhil.floatValue() * 0.03F / 180.0F + 0.98F);
        return;
      }
      parambhil = Float.valueOf(paramFloat1.floatValue() - 540.0F);
      this.a.jdField_a_of_type_Float = (0.99F + parambhil.floatValue() * 0.01F / 180.0F);
      this.a.b = (1.01F - parambhil.floatValue() * 0.01F / 180.0F);
      return;
    }
    if (paramFloat1.floatValue() < 120.0F)
    {
      this.a.jdField_a_of_type_Float = (1.0F - 0.02F * paramFloat1.floatValue() / 120.0F);
      this.a.b = (paramFloat1.floatValue() * 0.04F / 120.0F + 1.0F);
      return;
    }
    if (paramFloat1.floatValue() < 380.0F)
    {
      parambhil = Float.valueOf(paramFloat1.floatValue() - 120.0F);
      this.a.jdField_a_of_type_Float = (0.98F + parambhil.floatValue() * 0.04F / 260.0F);
      this.a.b = (1.04F - parambhil.floatValue() * 0.08F / 260.0F);
      return;
    }
    parambhil = Float.valueOf(paramFloat1.floatValue() - 380.0F);
    this.a.jdField_a_of_type_Float = (1.02F - 0.02F * parambhil.floatValue() / 120.0F);
    this.a.b = (parambhil.floatValue() * 0.04F / 120.0F + 0.96F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aznl
 * JD-Core Version:    0.7.0.1
 */