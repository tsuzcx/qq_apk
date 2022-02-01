import android.animation.TypeEvaluator;
import android.annotation.TargetApi;

@TargetApi(11)
public class aqmg
  implements TypeEvaluator<aqmf>
{
  public aqmf a(float paramFloat, aqmf paramaqmf1, aqmf paramaqmf2)
  {
    float f1;
    float f2;
    if (paramaqmf2.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramaqmf1.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramaqmf2.e + 3.0F * f1 * paramFloat * paramFloat * paramaqmf2.g + paramFloat * paramFloat * paramFloat * paramaqmf2.jdField_a_of_type_Float;
      float f3 = paramaqmf1.b;
      float f4 = paramaqmf2.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramaqmf2.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramaqmf2.b;
    }
    for (;;)
    {
      aqmf localaqmf = aqmf.b(f2, f1);
      paramaqmf1.d += (paramaqmf2.d - paramaqmf1.d) * paramFloat;
      paramaqmf1.c += (paramaqmf2.c - paramaqmf1.c) * paramFloat;
      return localaqmf;
      if (paramaqmf2.jdField_a_of_type_Int == 1)
      {
        f1 = paramaqmf1.jdField_a_of_type_Float;
        f2 = (paramaqmf2.jdField_a_of_type_Float - paramaqmf1.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramaqmf1.b + (paramaqmf2.b - paramaqmf1.b) * paramFloat;
      }
      else
      {
        f2 = paramaqmf2.jdField_a_of_type_Float;
        f1 = paramaqmf2.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqmg
 * JD-Core Version:    0.7.0.1
 */