import android.animation.TypeEvaluator;
import android.annotation.TargetApi;

@TargetApi(11)
public class amcs
  implements TypeEvaluator<amcr>
{
  public amcr a(float paramFloat, amcr paramamcr1, amcr paramamcr2)
  {
    float f1;
    float f2;
    if (paramamcr2.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramamcr1.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramamcr2.e + 3.0F * f1 * paramFloat * paramFloat * paramamcr2.g + paramFloat * paramFloat * paramFloat * paramamcr2.jdField_a_of_type_Float;
      float f3 = paramamcr1.b;
      float f4 = paramamcr2.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramamcr2.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramamcr2.b;
    }
    for (;;)
    {
      amcr localamcr = amcr.b(f2, f1);
      paramamcr1.d += (paramamcr2.d - paramamcr1.d) * paramFloat;
      paramamcr1.c += (paramamcr2.c - paramamcr1.c) * paramFloat;
      return localamcr;
      if (paramamcr2.jdField_a_of_type_Int == 1)
      {
        f1 = paramamcr1.jdField_a_of_type_Float;
        f2 = (paramamcr2.jdField_a_of_type_Float - paramamcr1.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramamcr1.b + (paramamcr2.b - paramamcr1.b) * paramFloat;
      }
      else
      {
        f2 = paramamcr2.jdField_a_of_type_Float;
        f1 = paramamcr2.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amcs
 * JD-Core Version:    0.7.0.1
 */