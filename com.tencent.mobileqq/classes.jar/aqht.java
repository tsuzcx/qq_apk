import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
public class aqht
  implements TypeEvaluator<aqhq>
{
  public aqhq a(float paramFloat, aqhq paramaqhq1, aqhq paramaqhq2)
  {
    long l = System.currentTimeMillis();
    float f1;
    float f2;
    aqiu localaqiu;
    aqhq localaqhq;
    if (paramaqhq2.jdField_a_of_type_Aqiu.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramaqhq1.jdField_a_of_type_Aqiu.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramaqhq2.jdField_a_of_type_Aqiu.e + 3.0F * f1 * paramFloat * paramFloat * paramaqhq2.jdField_a_of_type_Aqiu.g + paramFloat * paramFloat * paramFloat * paramaqhq2.jdField_a_of_type_Aqiu.jdField_a_of_type_Float;
      float f3 = paramaqhq1.jdField_a_of_type_Aqiu.b;
      float f4 = paramaqhq2.jdField_a_of_type_Aqiu.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramaqhq2.jdField_a_of_type_Aqiu.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramaqhq2.jdField_a_of_type_Aqiu.b;
      localaqiu = aqiu.b(f2, f1);
      localaqhq = new aqhq();
      localaqiu.d = (paramaqhq1.jdField_a_of_type_Aqiu.d + (paramaqhq2.jdField_a_of_type_Aqiu.d - paramaqhq1.jdField_a_of_type_Aqiu.d) * paramFloat);
      localaqhq.jdField_a_of_type_Aqiu = localaqiu;
      localaqhq.jdField_a_of_type_Aqhr = paramaqhq2.jdField_a_of_type_Aqhr;
      localaqhq.jdField_a_of_type_AndroidGraphicsBitmap = paramaqhq2.jdField_a_of_type_AndroidGraphicsBitmap;
      localaqhq.jdField_a_of_type_JavaLangString = paramaqhq2.jdField_a_of_type_JavaLangString;
      localaqhq.jdField_b_of_type_JavaLangString = paramaqhq2.jdField_b_of_type_JavaLangString;
      localaqhq.jdField_a_of_type_JavaLangBoolean = paramaqhq2.jdField_a_of_type_JavaLangBoolean;
      localaqhq.jdField_a_of_type_Boolean = paramaqhq2.jdField_a_of_type_Boolean;
      localaqhq.jdField_a_of_type_AndroidGraphicsRect = paramaqhq2.jdField_a_of_type_AndroidGraphicsRect;
      if (paramaqhq1.jdField_b_of_type_Boolean) {
        if (paramFloat < 1.0D) {
          break label758;
        }
      }
    }
    label758:
    for (int i = 100;; i = (int)((paramFloat + 0.005D) * 100.0D))
    {
      localaqhq.jdField_a_of_type_Int = i;
      if ((localaqhq.jdField_a_of_type_Int - paramaqhq2.jdField_a_of_type_Int >= 5) || (paramaqhq2.jdField_a_of_type_Int == 0))
      {
        if ((paramaqhq2.jdField_b_of_type_Int == 0) || (paramaqhq2.c == 0))
        {
          paramaqhq2.jdField_b_of_type_Int = ((int)paramaqhq1.jdField_a_of_type_Aqiu.jdField_a_of_type_Float);
          paramaqhq2.c = ((int)paramaqhq1.jdField_a_of_type_Aqiu.b);
        }
        double d1 = Math.abs(f1 - paramaqhq2.c);
        double d2 = Math.abs(f2 - paramaqhq2.jdField_b_of_type_Int);
        double d3 = Math.pow(d1, 2.0D);
        d2 = Math.sqrt(Math.pow(d2, 2.0D) + d3);
        if ((d2 != 0.0D) && (d1 != 0.0D))
        {
          localaqiu.c = ((float)Math.toDegrees(Math.asin(d1 / d2)));
          if (!paramaqhq2.jdField_a_of_type_Boolean) {
            localaqiu.c = (-localaqiu.c);
          }
        }
        if (Math.abs(localaqiu.c) > 90.0F)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "too large rotate " + localaqiu.c + ", reset to 0!");
          }
          localaqiu.c = 0.0F;
        }
        if (QLog.isColorLevel())
        {
          QLog.i("BubbleInterActiveAnim", 2, "rotate: " + localaqiu.c + " yDistance: " + d1 + ", distance: " + d2 + ", t: " + paramFloat);
          QLog.i("BubbleInterActiveAnim", 2, "evaluate_path_and_rotate, cost=" + (System.currentTimeMillis() - l));
        }
        paramaqhq2.jdField_a_of_type_Int = localaqhq.jdField_a_of_type_Int;
      }
      if (paramFloat == 1.0F) {
        localaqiu.c = 360.0F;
      }
      paramaqhq2.jdField_b_of_type_Int = ((int)f2);
      paramaqhq2.c = ((int)f1);
      return localaqhq;
      if (paramaqhq2.jdField_a_of_type_Aqiu.jdField_a_of_type_Int == 1)
      {
        f1 = paramaqhq1.jdField_a_of_type_Aqiu.jdField_a_of_type_Float;
        f2 = (paramaqhq2.jdField_a_of_type_Aqiu.jdField_a_of_type_Float - paramaqhq1.jdField_a_of_type_Aqiu.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramaqhq1.jdField_a_of_type_Aqiu.b + (paramaqhq2.jdField_a_of_type_Aqiu.b - paramaqhq1.jdField_a_of_type_Aqiu.b) * paramFloat;
        break;
      }
      f2 = paramaqhq2.jdField_a_of_type_Aqiu.jdField_a_of_type_Float;
      f1 = paramaqhq2.jdField_a_of_type_Aqiu.b;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqht
 * JD-Core Version:    0.7.0.1
 */