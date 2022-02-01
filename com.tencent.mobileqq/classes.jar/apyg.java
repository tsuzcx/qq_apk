import android.animation.TypeEvaluator;
import android.annotation.TargetApi;

@TargetApi(11)
public class apyg
  implements TypeEvaluator<apyf>
{
  public apyf a(float paramFloat, apyf paramapyf1, apyf paramapyf2)
  {
    float f1;
    float f2;
    if (paramapyf2.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramapyf1.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramapyf2.e + 3.0F * f1 * paramFloat * paramFloat * paramapyf2.g + paramFloat * paramFloat * paramFloat * paramapyf2.jdField_a_of_type_Float;
      float f3 = paramapyf1.b;
      float f4 = paramapyf2.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramapyf2.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramapyf2.b;
    }
    for (;;)
    {
      apyf localapyf = apyf.b(f2, f1);
      paramapyf1.d += (paramapyf2.d - paramapyf1.d) * paramFloat;
      paramapyf1.c += (paramapyf2.c - paramapyf1.c) * paramFloat;
      return localapyf;
      if (paramapyf2.jdField_a_of_type_Int == 1)
      {
        f1 = paramapyf1.jdField_a_of_type_Float;
        f2 = (paramapyf2.jdField_a_of_type_Float - paramapyf1.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramapyf1.b + (paramapyf2.b - paramapyf1.b) * paramFloat;
      }
      else
      {
        f2 = paramapyf2.jdField_a_of_type_Float;
        f1 = paramapyf2.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyg
 * JD-Core Version:    0.7.0.1
 */