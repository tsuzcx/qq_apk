import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
public class apxe
  implements TypeEvaluator<apxb>
{
  public apxb a(float paramFloat, apxb paramapxb1, apxb paramapxb2)
  {
    long l = System.currentTimeMillis();
    float f1;
    float f2;
    apyf localapyf;
    apxb localapxb;
    if (paramapxb2.jdField_a_of_type_Apyf.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramapxb1.jdField_a_of_type_Apyf.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramapxb2.jdField_a_of_type_Apyf.e + 3.0F * f1 * paramFloat * paramFloat * paramapxb2.jdField_a_of_type_Apyf.g + paramFloat * paramFloat * paramFloat * paramapxb2.jdField_a_of_type_Apyf.jdField_a_of_type_Float;
      float f3 = paramapxb1.jdField_a_of_type_Apyf.b;
      float f4 = paramapxb2.jdField_a_of_type_Apyf.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramapxb2.jdField_a_of_type_Apyf.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramapxb2.jdField_a_of_type_Apyf.b;
      localapyf = apyf.b(f2, f1);
      localapxb = new apxb();
      localapyf.d = (paramapxb1.jdField_a_of_type_Apyf.d + (paramapxb2.jdField_a_of_type_Apyf.d - paramapxb1.jdField_a_of_type_Apyf.d) * paramFloat);
      localapxb.jdField_a_of_type_Apyf = localapyf;
      localapxb.jdField_a_of_type_Apxc = paramapxb2.jdField_a_of_type_Apxc;
      localapxb.jdField_a_of_type_AndroidGraphicsBitmap = paramapxb2.jdField_a_of_type_AndroidGraphicsBitmap;
      localapxb.jdField_a_of_type_JavaLangString = paramapxb2.jdField_a_of_type_JavaLangString;
      localapxb.jdField_b_of_type_JavaLangString = paramapxb2.jdField_b_of_type_JavaLangString;
      localapxb.jdField_a_of_type_JavaLangBoolean = paramapxb2.jdField_a_of_type_JavaLangBoolean;
      localapxb.jdField_a_of_type_Boolean = paramapxb2.jdField_a_of_type_Boolean;
      localapxb.jdField_a_of_type_AndroidGraphicsRect = paramapxb2.jdField_a_of_type_AndroidGraphicsRect;
      if (paramapxb1.jdField_b_of_type_Boolean) {
        if (paramFloat < 1.0D) {
          break label758;
        }
      }
    }
    label758:
    for (int i = 100;; i = (int)((paramFloat + 0.005D) * 100.0D))
    {
      localapxb.jdField_a_of_type_Int = i;
      if ((localapxb.jdField_a_of_type_Int - paramapxb2.jdField_a_of_type_Int >= 5) || (paramapxb2.jdField_a_of_type_Int == 0))
      {
        if ((paramapxb2.jdField_b_of_type_Int == 0) || (paramapxb2.c == 0))
        {
          paramapxb2.jdField_b_of_type_Int = ((int)paramapxb1.jdField_a_of_type_Apyf.jdField_a_of_type_Float);
          paramapxb2.c = ((int)paramapxb1.jdField_a_of_type_Apyf.b);
        }
        double d1 = Math.abs(f1 - paramapxb2.c);
        double d2 = Math.abs(f2 - paramapxb2.jdField_b_of_type_Int);
        double d3 = Math.pow(d1, 2.0D);
        d2 = Math.sqrt(Math.pow(d2, 2.0D) + d3);
        if ((d2 != 0.0D) && (d1 != 0.0D))
        {
          localapyf.c = ((float)Math.toDegrees(Math.asin(d1 / d2)));
          if (!paramapxb2.jdField_a_of_type_Boolean) {
            localapyf.c = (-localapyf.c);
          }
        }
        if (Math.abs(localapyf.c) > 90.0F)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "too large rotate " + localapyf.c + ", reset to 0!");
          }
          localapyf.c = 0.0F;
        }
        if (QLog.isColorLevel())
        {
          QLog.i("BubbleInterActiveAnim", 2, "rotate: " + localapyf.c + " yDistance: " + d1 + ", distance: " + d2 + ", t: " + paramFloat);
          QLog.i("BubbleInterActiveAnim", 2, "evaluate_path_and_rotate, cost=" + (System.currentTimeMillis() - l));
        }
        paramapxb2.jdField_a_of_type_Int = localapxb.jdField_a_of_type_Int;
      }
      if (paramFloat == 1.0F) {
        localapyf.c = 360.0F;
      }
      paramapxb2.jdField_b_of_type_Int = ((int)f2);
      paramapxb2.c = ((int)f1);
      return localapxb;
      if (paramapxb2.jdField_a_of_type_Apyf.jdField_a_of_type_Int == 1)
      {
        f1 = paramapxb1.jdField_a_of_type_Apyf.jdField_a_of_type_Float;
        f2 = (paramapxb2.jdField_a_of_type_Apyf.jdField_a_of_type_Float - paramapxb1.jdField_a_of_type_Apyf.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramapxb1.jdField_a_of_type_Apyf.b + (paramapxb2.jdField_a_of_type_Apyf.b - paramapxb1.jdField_a_of_type_Apyf.b) * paramFloat;
        break;
      }
      f2 = paramapxb2.jdField_a_of_type_Apyf.jdField_a_of_type_Float;
      f1 = paramapxb2.jdField_a_of_type_Apyf.b;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxe
 * JD-Core Version:    0.7.0.1
 */