import android.animation.TypeEvaluator;
import android.annotation.TargetApi;

@TargetApi(11)
public class amct
  implements TypeEvaluator<amcs>
{
  public amcs a(float paramFloat, amcs paramamcs1, amcs paramamcs2)
  {
    float f1;
    float f2;
    if (paramamcs2.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramamcs1.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramamcs2.e + 3.0F * f1 * paramFloat * paramFloat * paramamcs2.g + paramFloat * paramFloat * paramFloat * paramamcs2.jdField_a_of_type_Float;
      float f3 = paramamcs1.b;
      float f4 = paramamcs2.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramamcs2.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramamcs2.b;
    }
    for (;;)
    {
      amcs localamcs = amcs.b(f2, f1);
      paramamcs1.d += (paramamcs2.d - paramamcs1.d) * paramFloat;
      paramamcs1.c += (paramamcs2.c - paramamcs1.c) * paramFloat;
      return localamcs;
      if (paramamcs2.jdField_a_of_type_Int == 1)
      {
        f1 = paramamcs1.jdField_a_of_type_Float;
        f2 = (paramamcs2.jdField_a_of_type_Float - paramamcs1.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramamcs1.b + (paramamcs2.b - paramamcs1.b) * paramFloat;
      }
      else
      {
        f2 = paramamcs2.jdField_a_of_type_Float;
        f1 = paramamcs2.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amct
 * JD-Core Version:    0.7.0.1
 */