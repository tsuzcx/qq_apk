import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
public class ansq
  implements TypeEvaluator<ansn>
{
  public ansn a(float paramFloat, ansn paramansn1, ansn paramansn2)
  {
    long l = System.currentTimeMillis();
    float f1;
    float f2;
    antr localantr;
    ansn localansn;
    if (paramansn2.jdField_a_of_type_Antr.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramansn1.jdField_a_of_type_Antr.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramansn2.jdField_a_of_type_Antr.e + 3.0F * f1 * paramFloat * paramFloat * paramansn2.jdField_a_of_type_Antr.g + paramFloat * paramFloat * paramFloat * paramansn2.jdField_a_of_type_Antr.jdField_a_of_type_Float;
      float f3 = paramansn1.jdField_a_of_type_Antr.b;
      float f4 = paramansn2.jdField_a_of_type_Antr.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramansn2.jdField_a_of_type_Antr.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramansn2.jdField_a_of_type_Antr.b;
      localantr = antr.b(f2, f1);
      localansn = new ansn();
      localantr.d = (paramansn1.jdField_a_of_type_Antr.d + (paramansn2.jdField_a_of_type_Antr.d - paramansn1.jdField_a_of_type_Antr.d) * paramFloat);
      localansn.jdField_a_of_type_Antr = localantr;
      localansn.jdField_a_of_type_Anso = paramansn2.jdField_a_of_type_Anso;
      localansn.jdField_a_of_type_AndroidGraphicsBitmap = paramansn2.jdField_a_of_type_AndroidGraphicsBitmap;
      localansn.jdField_a_of_type_JavaLangString = paramansn2.jdField_a_of_type_JavaLangString;
      localansn.jdField_b_of_type_JavaLangString = paramansn2.jdField_b_of_type_JavaLangString;
      localansn.jdField_a_of_type_JavaLangBoolean = paramansn2.jdField_a_of_type_JavaLangBoolean;
      localansn.jdField_a_of_type_Boolean = paramansn2.jdField_a_of_type_Boolean;
      localansn.jdField_a_of_type_AndroidGraphicsRect = paramansn2.jdField_a_of_type_AndroidGraphicsRect;
      if (paramansn1.jdField_b_of_type_Boolean) {
        if (paramFloat < 1.0D) {
          break label758;
        }
      }
    }
    label758:
    for (int i = 100;; i = (int)((paramFloat + 0.005D) * 100.0D))
    {
      localansn.jdField_a_of_type_Int = i;
      if ((localansn.jdField_a_of_type_Int - paramansn2.jdField_a_of_type_Int >= 5) || (paramansn2.jdField_a_of_type_Int == 0))
      {
        if ((paramansn2.jdField_b_of_type_Int == 0) || (paramansn2.c == 0))
        {
          paramansn2.jdField_b_of_type_Int = ((int)paramansn1.jdField_a_of_type_Antr.jdField_a_of_type_Float);
          paramansn2.c = ((int)paramansn1.jdField_a_of_type_Antr.b);
        }
        double d1 = Math.abs(f1 - paramansn2.c);
        double d2 = Math.abs(f2 - paramansn2.jdField_b_of_type_Int);
        double d3 = Math.pow(d1, 2.0D);
        d2 = Math.sqrt(Math.pow(d2, 2.0D) + d3);
        if ((d2 != 0.0D) && (d1 != 0.0D))
        {
          localantr.c = ((float)Math.toDegrees(Math.asin(d1 / d2)));
          if (!paramansn2.jdField_a_of_type_Boolean) {
            localantr.c = (-localantr.c);
          }
        }
        if (Math.abs(localantr.c) > 90.0F)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "too large rotate " + localantr.c + ", reset to 0!");
          }
          localantr.c = 0.0F;
        }
        if (QLog.isColorLevel())
        {
          QLog.i("BubbleInterActiveAnim", 2, "rotate: " + localantr.c + " yDistance: " + d1 + ", distance: " + d2 + ", t: " + paramFloat);
          QLog.i("BubbleInterActiveAnim", 2, "evaluate_path_and_rotate, cost=" + (System.currentTimeMillis() - l));
        }
        paramansn2.jdField_a_of_type_Int = localansn.jdField_a_of_type_Int;
      }
      if (paramFloat == 1.0F) {
        localantr.c = 360.0F;
      }
      paramansn2.jdField_b_of_type_Int = ((int)f2);
      paramansn2.c = ((int)f1);
      return localansn;
      if (paramansn2.jdField_a_of_type_Antr.jdField_a_of_type_Int == 1)
      {
        f1 = paramansn1.jdField_a_of_type_Antr.jdField_a_of_type_Float;
        f2 = (paramansn2.jdField_a_of_type_Antr.jdField_a_of_type_Float - paramansn1.jdField_a_of_type_Antr.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramansn1.jdField_a_of_type_Antr.b + (paramansn2.jdField_a_of_type_Antr.b - paramansn1.jdField_a_of_type_Antr.b) * paramFloat;
        break;
      }
      f2 = paramansn2.jdField_a_of_type_Antr.jdField_a_of_type_Float;
      f1 = paramansn2.jdField_a_of_type_Antr.b;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansq
 * JD-Core Version:    0.7.0.1
 */