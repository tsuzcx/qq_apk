import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
public class anwz
  implements TypeEvaluator<anww>
{
  public anww a(float paramFloat, anww paramanww1, anww paramanww2)
  {
    long l = System.currentTimeMillis();
    float f1;
    float f2;
    anya localanya;
    anww localanww;
    if (paramanww2.jdField_a_of_type_Anya.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramanww1.jdField_a_of_type_Anya.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramanww2.jdField_a_of_type_Anya.e + 3.0F * f1 * paramFloat * paramFloat * paramanww2.jdField_a_of_type_Anya.g + paramFloat * paramFloat * paramFloat * paramanww2.jdField_a_of_type_Anya.jdField_a_of_type_Float;
      float f3 = paramanww1.jdField_a_of_type_Anya.b;
      float f4 = paramanww2.jdField_a_of_type_Anya.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramanww2.jdField_a_of_type_Anya.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramanww2.jdField_a_of_type_Anya.b;
      localanya = anya.b(f2, f1);
      localanww = new anww();
      localanya.d = (paramanww1.jdField_a_of_type_Anya.d + (paramanww2.jdField_a_of_type_Anya.d - paramanww1.jdField_a_of_type_Anya.d) * paramFloat);
      localanww.jdField_a_of_type_Anya = localanya;
      localanww.jdField_a_of_type_Anwx = paramanww2.jdField_a_of_type_Anwx;
      localanww.jdField_a_of_type_AndroidGraphicsBitmap = paramanww2.jdField_a_of_type_AndroidGraphicsBitmap;
      localanww.jdField_a_of_type_JavaLangString = paramanww2.jdField_a_of_type_JavaLangString;
      localanww.jdField_b_of_type_JavaLangString = paramanww2.jdField_b_of_type_JavaLangString;
      localanww.jdField_a_of_type_JavaLangBoolean = paramanww2.jdField_a_of_type_JavaLangBoolean;
      localanww.jdField_a_of_type_Boolean = paramanww2.jdField_a_of_type_Boolean;
      localanww.jdField_a_of_type_AndroidGraphicsRect = paramanww2.jdField_a_of_type_AndroidGraphicsRect;
      if (paramanww1.jdField_b_of_type_Boolean) {
        if (paramFloat < 1.0D) {
          break label758;
        }
      }
    }
    label758:
    for (int i = 100;; i = (int)((paramFloat + 0.005D) * 100.0D))
    {
      localanww.jdField_a_of_type_Int = i;
      if ((localanww.jdField_a_of_type_Int - paramanww2.jdField_a_of_type_Int >= 5) || (paramanww2.jdField_a_of_type_Int == 0))
      {
        if ((paramanww2.jdField_b_of_type_Int == 0) || (paramanww2.c == 0))
        {
          paramanww2.jdField_b_of_type_Int = ((int)paramanww1.jdField_a_of_type_Anya.jdField_a_of_type_Float);
          paramanww2.c = ((int)paramanww1.jdField_a_of_type_Anya.b);
        }
        double d1 = Math.abs(f1 - paramanww2.c);
        double d2 = Math.abs(f2 - paramanww2.jdField_b_of_type_Int);
        double d3 = Math.pow(d1, 2.0D);
        d2 = Math.sqrt(Math.pow(d2, 2.0D) + d3);
        if ((d2 != 0.0D) && (d1 != 0.0D))
        {
          localanya.c = ((float)Math.toDegrees(Math.asin(d1 / d2)));
          if (!paramanww2.jdField_a_of_type_Boolean) {
            localanya.c = (-localanya.c);
          }
        }
        if (Math.abs(localanya.c) > 90.0F)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "too large rotate " + localanya.c + ", reset to 0!");
          }
          localanya.c = 0.0F;
        }
        if (QLog.isColorLevel())
        {
          QLog.i("BubbleInterActiveAnim", 2, "rotate: " + localanya.c + " yDistance: " + d1 + ", distance: " + d2 + ", t: " + paramFloat);
          QLog.i("BubbleInterActiveAnim", 2, "evaluate_path_and_rotate, cost=" + (System.currentTimeMillis() - l));
        }
        paramanww2.jdField_a_of_type_Int = localanww.jdField_a_of_type_Int;
      }
      if (paramFloat == 1.0F) {
        localanya.c = 360.0F;
      }
      paramanww2.jdField_b_of_type_Int = ((int)f2);
      paramanww2.c = ((int)f1);
      return localanww;
      if (paramanww2.jdField_a_of_type_Anya.jdField_a_of_type_Int == 1)
      {
        f1 = paramanww1.jdField_a_of_type_Anya.jdField_a_of_type_Float;
        f2 = (paramanww2.jdField_a_of_type_Anya.jdField_a_of_type_Float - paramanww1.jdField_a_of_type_Anya.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramanww1.jdField_a_of_type_Anya.b + (paramanww2.jdField_a_of_type_Anya.b - paramanww1.jdField_a_of_type_Anya.b) * paramFloat;
        break;
      }
      f2 = paramanww2.jdField_a_of_type_Anya.jdField_a_of_type_Float;
      f1 = paramanww2.jdField_a_of_type_Anya.b;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwz
 * JD-Core Version:    0.7.0.1
 */