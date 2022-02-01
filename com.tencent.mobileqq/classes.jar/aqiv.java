import android.animation.TypeEvaluator;
import android.annotation.TargetApi;

@TargetApi(11)
public class aqiv
  implements TypeEvaluator<aqiu>
{
  public aqiu a(float paramFloat, aqiu paramaqiu1, aqiu paramaqiu2)
  {
    float f1;
    float f2;
    if (paramaqiu2.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramaqiu1.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramaqiu2.e + 3.0F * f1 * paramFloat * paramFloat * paramaqiu2.g + paramFloat * paramFloat * paramFloat * paramaqiu2.jdField_a_of_type_Float;
      float f3 = paramaqiu1.b;
      float f4 = paramaqiu2.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramaqiu2.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramaqiu2.b;
    }
    for (;;)
    {
      aqiu localaqiu = aqiu.b(f2, f1);
      paramaqiu1.d += (paramaqiu2.d - paramaqiu1.d) * paramFloat;
      paramaqiu1.c += (paramaqiu2.c - paramaqiu1.c) * paramFloat;
      return localaqiu;
      if (paramaqiu2.jdField_a_of_type_Int == 1)
      {
        f1 = paramaqiu1.jdField_a_of_type_Float;
        f2 = (paramaqiu2.jdField_a_of_type_Float - paramaqiu1.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramaqiu1.b + (paramaqiu2.b - paramaqiu1.b) * paramFloat;
      }
      else
      {
        f2 = paramaqiu2.jdField_a_of_type_Float;
        f1 = paramaqiu2.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqiv
 * JD-Core Version:    0.7.0.1
 */