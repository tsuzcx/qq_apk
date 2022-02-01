import android.animation.TypeEvaluator;
import android.annotation.TargetApi;

@TargetApi(11)
public class apfr
  implements TypeEvaluator<apfq>
{
  public apfq a(float paramFloat, apfq paramapfq1, apfq paramapfq2)
  {
    float f1;
    float f2;
    if (paramapfq2.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramapfq1.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramapfq2.e + 3.0F * f1 * paramFloat * paramFloat * paramapfq2.g + paramFloat * paramFloat * paramFloat * paramapfq2.jdField_a_of_type_Float;
      float f3 = paramapfq1.b;
      float f4 = paramapfq2.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramapfq2.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramapfq2.b;
    }
    for (;;)
    {
      apfq localapfq = apfq.b(f2, f1);
      paramapfq1.d += (paramapfq2.d - paramapfq1.d) * paramFloat;
      paramapfq1.c += (paramapfq2.c - paramapfq1.c) * paramFloat;
      return localapfq;
      if (paramapfq2.jdField_a_of_type_Int == 1)
      {
        f1 = paramapfq1.jdField_a_of_type_Float;
        f2 = (paramapfq2.jdField_a_of_type_Float - paramapfq1.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramapfq1.b + (paramapfq2.b - paramapfq1.b) * paramFloat;
      }
      else
      {
        f2 = paramapfq2.jdField_a_of_type_Float;
        f1 = paramapfq2.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfr
 * JD-Core Version:    0.7.0.1
 */