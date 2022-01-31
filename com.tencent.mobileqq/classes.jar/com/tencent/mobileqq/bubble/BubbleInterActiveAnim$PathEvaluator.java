package com.tencent.mobileqq.bubble;

import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
public class BubbleInterActiveAnim$PathEvaluator
  implements TypeEvaluator
{
  public BubbleInterActiveAnim.AnimFrameData a(float paramFloat, BubbleInterActiveAnim.AnimFrameData paramAnimFrameData1, BubbleInterActiveAnim.AnimFrameData paramAnimFrameData2)
  {
    long l = System.currentTimeMillis();
    float f1;
    float f2;
    PathPoint localPathPoint;
    BubbleInterActiveAnim.AnimFrameData localAnimFrameData;
    if (paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Float + 3.0F * f1 * f1 * paramFloat * paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.e + 3.0F * f1 * paramFloat * paramFloat * paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.g + paramFloat * paramFloat * paramFloat * paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Float;
      float f3 = paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.b;
      float f4 = paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.b;
      localPathPoint = PathPoint.b(f2, f1);
      localAnimFrameData = new BubbleInterActiveAnim.AnimFrameData();
      localPathPoint.d = (paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.d + (paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.d - paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.d) * paramFloat);
      localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint = localPathPoint;
      localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder = paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder;
      localAnimFrameData.jdField_a_of_type_AndroidGraphicsBitmap = paramAnimFrameData2.jdField_a_of_type_AndroidGraphicsBitmap;
      localAnimFrameData.jdField_a_of_type_JavaLangString = paramAnimFrameData2.jdField_a_of_type_JavaLangString;
      localAnimFrameData.jdField_b_of_type_JavaLangString = paramAnimFrameData2.jdField_b_of_type_JavaLangString;
      localAnimFrameData.jdField_a_of_type_JavaLangBoolean = paramAnimFrameData2.jdField_a_of_type_JavaLangBoolean;
      localAnimFrameData.jdField_a_of_type_Boolean = paramAnimFrameData2.jdField_a_of_type_Boolean;
      localAnimFrameData.jdField_a_of_type_AndroidGraphicsRect = paramAnimFrameData2.jdField_a_of_type_AndroidGraphicsRect;
      if (paramAnimFrameData1.jdField_b_of_type_Boolean) {
        if (paramFloat < 1.0D) {
          break label758;
        }
      }
    }
    label758:
    for (int i = 100;; i = (int)((paramFloat + 0.005D) * 100.0D))
    {
      localAnimFrameData.jdField_a_of_type_Int = i;
      if ((localAnimFrameData.jdField_a_of_type_Int - paramAnimFrameData2.jdField_a_of_type_Int >= 5) || (paramAnimFrameData2.jdField_a_of_type_Int == 0))
      {
        if ((paramAnimFrameData2.jdField_b_of_type_Int == 0) || (paramAnimFrameData2.c == 0))
        {
          paramAnimFrameData2.jdField_b_of_type_Int = ((int)paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Float);
          paramAnimFrameData2.c = ((int)paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.b);
        }
        double d1 = Math.abs(f1 - paramAnimFrameData2.c);
        double d2 = Math.abs(f2 - paramAnimFrameData2.jdField_b_of_type_Int);
        double d3 = Math.pow(d1, 2.0D);
        d2 = Math.sqrt(Math.pow(d2, 2.0D) + d3);
        if ((d2 != 0.0D) && (d1 != 0.0D))
        {
          localPathPoint.c = ((float)Math.toDegrees(Math.asin(d1 / d2)));
          if (!paramAnimFrameData2.jdField_a_of_type_Boolean) {
            localPathPoint.c = (-localPathPoint.c);
          }
        }
        if (Math.abs(localPathPoint.c) > 90.0F)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleInterActiveAnim", 2, "too large rotate " + localPathPoint.c + ", reset to 0!");
          }
          localPathPoint.c = 0.0F;
        }
        if (QLog.isColorLevel())
        {
          QLog.i("BubbleInterActiveAnim", 2, "rotate: " + localPathPoint.c + " yDistance: " + d1 + ", distance: " + d2 + ", t: " + paramFloat);
          QLog.i("BubbleInterActiveAnim", 2, "evaluate_path_and_rotate, cost=" + (System.currentTimeMillis() - l));
        }
        paramAnimFrameData2.jdField_a_of_type_Int = localAnimFrameData.jdField_a_of_type_Int;
      }
      if (paramFloat == 1.0F) {
        localPathPoint.c = 360.0F;
      }
      paramAnimFrameData2.jdField_b_of_type_Int = ((int)f2);
      paramAnimFrameData2.c = ((int)f1);
      return localAnimFrameData;
      if (paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Int == 1)
      {
        f1 = paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Float;
        f2 = (paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Float - paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Float) * paramFloat + f1;
        f1 = paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.b + (paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.b - paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.b) * paramFloat;
        break;
      }
      f2 = paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Float;
      f1 = paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.b;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.PathEvaluator
 * JD-Core Version:    0.7.0.1
 */