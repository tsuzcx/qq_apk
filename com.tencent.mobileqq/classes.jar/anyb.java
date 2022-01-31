import android.animation.TypeEvaluator;
import android.annotation.TargetApi;

@TargetApi(11)
public class anyb
  implements TypeEvaluator<anya>
{
  public anya a(float paramFloat, anya paramanya1, anya paramanya2)
  {
    float f1;
    float f2;
    if (paramanya2.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramanya1.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramanya2.e + 3.0F * f1 * paramFloat * paramFloat * paramanya2.g + paramFloat * paramFloat * paramFloat * paramanya2.jdField_a_of_type_Float;
      float f3 = paramanya1.b;
      float f4 = paramanya2.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramanya2.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramanya2.b;
    }
    for (;;)
    {
      anya localanya = anya.b(f2, f1);
      paramanya1.d += (paramanya2.d - paramanya1.d) * paramFloat;
      paramanya1.c += (paramanya2.c - paramanya1.c) * paramFloat;
      return localanya;
      if (paramanya2.jdField_a_of_type_Int == 1)
      {
        f1 = paramanya1.jdField_a_of_type_Float;
        f2 = (paramanya2.jdField_a_of_type_Float - paramanya1.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramanya1.b + (paramanya2.b - paramanya1.b) * paramFloat;
      }
      else
      {
        f2 = paramanya2.jdField_a_of_type_Float;
        f1 = paramanya2.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyb
 * JD-Core Version:    0.7.0.1
 */