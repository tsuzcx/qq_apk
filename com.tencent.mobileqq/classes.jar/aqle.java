import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
public class aqle
  implements TypeEvaluator<aqlb>
{
  public aqlb a(float paramFloat, aqlb paramaqlb1, aqlb paramaqlb2)
  {
    long l = System.currentTimeMillis();
    float f1;
    float f2;
    aqmf localaqmf;
    aqlb localaqlb;
    if (paramaqlb2.jdField_a_of_type_Aqmf.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramaqlb1.jdField_a_of_type_Aqmf.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramaqlb2.jdField_a_of_type_Aqmf.e + 3.0F * f1 * paramFloat * paramFloat * paramaqlb2.jdField_a_of_type_Aqmf.g + paramFloat * paramFloat * paramFloat * paramaqlb2.jdField_a_of_type_Aqmf.jdField_a_of_type_Float;
      float f3 = paramaqlb1.jdField_a_of_type_Aqmf.b;
      float f4 = paramaqlb2.jdField_a_of_type_Aqmf.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramaqlb2.jdField_a_of_type_Aqmf.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramaqlb2.jdField_a_of_type_Aqmf.b;
      localaqmf = aqmf.b(f2, f1);
      localaqlb = new aqlb();
      localaqmf.d = (paramaqlb1.jdField_a_of_type_Aqmf.d + (paramaqlb2.jdField_a_of_type_Aqmf.d - paramaqlb1.jdField_a_of_type_Aqmf.d) * paramFloat);
      localaqlb.jdField_a_of_type_Aqmf = localaqmf;
      localaqlb.jdField_a_of_type_Aqlc = paramaqlb2.jdField_a_of_type_Aqlc;
      localaqlb.jdField_a_of_type_AndroidGraphicsBitmap = paramaqlb2.jdField_a_of_type_AndroidGraphicsBitmap;
      localaqlb.jdField_a_of_type_JavaLangString = paramaqlb2.jdField_a_of_type_JavaLangString;
      localaqlb.jdField_b_of_type_JavaLangString = paramaqlb2.jdField_b_of_type_JavaLangString;
      localaqlb.jdField_a_of_type_JavaLangBoolean = paramaqlb2.jdField_a_of_type_JavaLangBoolean;
      localaqlb.jdField_a_of_type_Boolean = paramaqlb2.jdField_a_of_type_Boolean;
      localaqlb.jdField_a_of_type_AndroidGraphicsRect = paramaqlb2.jdField_a_of_type_AndroidGraphicsRect;
      if (paramaqlb1.jdField_b_of_type_Boolean) {
        if (paramFloat < 1.0D) {
          break label758;
        }
      }
    }
    label758:
    for (int i = 100;; i = (int)((paramFloat + 0.005D) * 100.0D))
    {
      localaqlb.jdField_a_of_type_Int = i;
      if ((localaqlb.jdField_a_of_type_Int - paramaqlb2.jdField_a_of_type_Int >= 5) || (paramaqlb2.jdField_a_of_type_Int == 0))
      {
        if ((paramaqlb2.jdField_b_of_type_Int == 0) || (paramaqlb2.c == 0))
        {
          paramaqlb2.jdField_b_of_type_Int = ((int)paramaqlb1.jdField_a_of_type_Aqmf.jdField_a_of_type_Float);
          paramaqlb2.c = ((int)paramaqlb1.jdField_a_of_type_Aqmf.b);
        }
        double d1 = Math.abs(f1 - paramaqlb2.c);
        double d2 = Math.abs(f2 - paramaqlb2.jdField_b_of_type_Int);
        double d3 = Math.pow(d1, 2.0D);
        d2 = Math.sqrt(Math.pow(d2, 2.0D) + d3);
        if ((d2 != 0.0D) && (d1 != 0.0D))
        {
          localaqmf.c = ((float)Math.toDegrees(Math.asin(d1 / d2)));
          if (!paramaqlb2.jdField_a_of_type_Boolean) {
            localaqmf.c = (-localaqmf.c);
          }
        }
        if (Math.abs(localaqmf.c) > 90.0F)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "too large rotate " + localaqmf.c + ", reset to 0!");
          }
          localaqmf.c = 0.0F;
        }
        if (QLog.isColorLevel())
        {
          QLog.i("BubbleInterActiveAnim", 2, "rotate: " + localaqmf.c + " yDistance: " + d1 + ", distance: " + d2 + ", t: " + paramFloat);
          QLog.i("BubbleInterActiveAnim", 2, "evaluate_path_and_rotate, cost=" + (System.currentTimeMillis() - l));
        }
        paramaqlb2.jdField_a_of_type_Int = localaqlb.jdField_a_of_type_Int;
      }
      if (paramFloat == 1.0F) {
        localaqmf.c = 360.0F;
      }
      paramaqlb2.jdField_b_of_type_Int = ((int)f2);
      paramaqlb2.c = ((int)f1);
      return localaqlb;
      if (paramaqlb2.jdField_a_of_type_Aqmf.jdField_a_of_type_Int == 1)
      {
        f1 = paramaqlb1.jdField_a_of_type_Aqmf.jdField_a_of_type_Float;
        f2 = (paramaqlb2.jdField_a_of_type_Aqmf.jdField_a_of_type_Float - paramaqlb1.jdField_a_of_type_Aqmf.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramaqlb1.jdField_a_of_type_Aqmf.b + (paramaqlb2.jdField_a_of_type_Aqmf.b - paramaqlb1.jdField_a_of_type_Aqmf.b) * paramFloat;
        break;
      }
      f2 = paramaqlb2.jdField_a_of_type_Aqmf.jdField_a_of_type_Float;
      f1 = paramaqlb2.jdField_a_of_type_Aqmf.b;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqle
 * JD-Core Version:    0.7.0.1
 */