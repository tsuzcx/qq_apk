import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
public class apep
  implements TypeEvaluator<apem>
{
  public apem a(float paramFloat, apem paramapem1, apem paramapem2)
  {
    long l = System.currentTimeMillis();
    float f1;
    float f2;
    apfq localapfq;
    apem localapem;
    if (paramapem2.jdField_a_of_type_Apfq.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramapem1.jdField_a_of_type_Apfq.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramapem2.jdField_a_of_type_Apfq.e + 3.0F * f1 * paramFloat * paramFloat * paramapem2.jdField_a_of_type_Apfq.g + paramFloat * paramFloat * paramFloat * paramapem2.jdField_a_of_type_Apfq.jdField_a_of_type_Float;
      float f3 = paramapem1.jdField_a_of_type_Apfq.b;
      float f4 = paramapem2.jdField_a_of_type_Apfq.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramapem2.jdField_a_of_type_Apfq.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramapem2.jdField_a_of_type_Apfq.b;
      localapfq = apfq.b(f2, f1);
      localapem = new apem();
      localapfq.d = (paramapem1.jdField_a_of_type_Apfq.d + (paramapem2.jdField_a_of_type_Apfq.d - paramapem1.jdField_a_of_type_Apfq.d) * paramFloat);
      localapem.jdField_a_of_type_Apfq = localapfq;
      localapem.jdField_a_of_type_Apen = paramapem2.jdField_a_of_type_Apen;
      localapem.jdField_a_of_type_AndroidGraphicsBitmap = paramapem2.jdField_a_of_type_AndroidGraphicsBitmap;
      localapem.jdField_a_of_type_JavaLangString = paramapem2.jdField_a_of_type_JavaLangString;
      localapem.jdField_b_of_type_JavaLangString = paramapem2.jdField_b_of_type_JavaLangString;
      localapem.jdField_a_of_type_JavaLangBoolean = paramapem2.jdField_a_of_type_JavaLangBoolean;
      localapem.jdField_a_of_type_Boolean = paramapem2.jdField_a_of_type_Boolean;
      localapem.jdField_a_of_type_AndroidGraphicsRect = paramapem2.jdField_a_of_type_AndroidGraphicsRect;
      if (paramapem1.jdField_b_of_type_Boolean) {
        if (paramFloat < 1.0D) {
          break label758;
        }
      }
    }
    label758:
    for (int i = 100;; i = (int)((paramFloat + 0.005D) * 100.0D))
    {
      localapem.jdField_a_of_type_Int = i;
      if ((localapem.jdField_a_of_type_Int - paramapem2.jdField_a_of_type_Int >= 5) || (paramapem2.jdField_a_of_type_Int == 0))
      {
        if ((paramapem2.jdField_b_of_type_Int == 0) || (paramapem2.c == 0))
        {
          paramapem2.jdField_b_of_type_Int = ((int)paramapem1.jdField_a_of_type_Apfq.jdField_a_of_type_Float);
          paramapem2.c = ((int)paramapem1.jdField_a_of_type_Apfq.b);
        }
        double d1 = Math.abs(f1 - paramapem2.c);
        double d2 = Math.abs(f2 - paramapem2.jdField_b_of_type_Int);
        double d3 = Math.pow(d1, 2.0D);
        d2 = Math.sqrt(Math.pow(d2, 2.0D) + d3);
        if ((d2 != 0.0D) && (d1 != 0.0D))
        {
          localapfq.c = ((float)Math.toDegrees(Math.asin(d1 / d2)));
          if (!paramapem2.jdField_a_of_type_Boolean) {
            localapfq.c = (-localapfq.c);
          }
        }
        if (Math.abs(localapfq.c) > 90.0F)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "too large rotate " + localapfq.c + ", reset to 0!");
          }
          localapfq.c = 0.0F;
        }
        if (QLog.isColorLevel())
        {
          QLog.i("BubbleInterActiveAnim", 2, "rotate: " + localapfq.c + " yDistance: " + d1 + ", distance: " + d2 + ", t: " + paramFloat);
          QLog.i("BubbleInterActiveAnim", 2, "evaluate_path_and_rotate, cost=" + (System.currentTimeMillis() - l));
        }
        paramapem2.jdField_a_of_type_Int = localapem.jdField_a_of_type_Int;
      }
      if (paramFloat == 1.0F) {
        localapfq.c = 360.0F;
      }
      paramapem2.jdField_b_of_type_Int = ((int)f2);
      paramapem2.c = ((int)f1);
      return localapem;
      if (paramapem2.jdField_a_of_type_Apfq.jdField_a_of_type_Int == 1)
      {
        f1 = paramapem1.jdField_a_of_type_Apfq.jdField_a_of_type_Float;
        f2 = (paramapem2.jdField_a_of_type_Apfq.jdField_a_of_type_Float - paramapem1.jdField_a_of_type_Apfq.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramapem1.jdField_a_of_type_Apfq.b + (paramapem2.jdField_a_of_type_Apfq.b - paramapem1.jdField_a_of_type_Apfq.b) * paramFloat;
        break;
      }
      f2 = paramapem2.jdField_a_of_type_Apfq.jdField_a_of_type_Float;
      f1 = paramapem2.jdField_a_of_type_Apfq.b;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apep
 * JD-Core Version:    0.7.0.1
 */