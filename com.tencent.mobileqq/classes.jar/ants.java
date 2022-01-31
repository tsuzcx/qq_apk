import android.animation.TypeEvaluator;
import android.annotation.TargetApi;

@TargetApi(11)
public class ants
  implements TypeEvaluator<antr>
{
  public antr a(float paramFloat, antr paramantr1, antr paramantr2)
  {
    float f1;
    float f2;
    if (paramantr2.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramantr1.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramantr2.e + 3.0F * f1 * paramFloat * paramFloat * paramantr2.g + paramFloat * paramFloat * paramFloat * paramantr2.jdField_a_of_type_Float;
      float f3 = paramantr1.b;
      float f4 = paramantr2.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramantr2.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramantr2.b;
    }
    for (;;)
    {
      antr localantr = antr.b(f2, f1);
      paramantr1.d += (paramantr2.d - paramantr1.d) * paramFloat;
      paramantr1.c += (paramantr2.c - paramantr1.c) * paramFloat;
      return localantr;
      if (paramantr2.jdField_a_of_type_Int == 1)
      {
        f1 = paramantr1.jdField_a_of_type_Float;
        f2 = (paramantr2.jdField_a_of_type_Float - paramantr1.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramantr1.b + (paramantr2.b - paramantr1.b) * paramFloat;
      }
      else
      {
        f2 = paramantr2.jdField_a_of_type_Float;
        f1 = paramantr2.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ants
 * JD-Core Version:    0.7.0.1
 */