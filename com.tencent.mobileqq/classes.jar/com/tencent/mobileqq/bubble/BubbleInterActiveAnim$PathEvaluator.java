package com.tencent.mobileqq.bubble;

import android.animation.TypeEvaluator;
import android.annotation.TargetApi;

@TargetApi(11)
public class BubbleInterActiveAnim$PathEvaluator
  implements TypeEvaluator<BubbleInterActiveAnim.AnimFrameData>
{
  public BubbleInterActiveAnim.AnimFrameData a(float paramFloat, BubbleInterActiveAnim.AnimFrameData paramAnimFrameData1, BubbleInterActiveAnim.AnimFrameData paramAnimFrameData2)
  {
    long l = System.currentTimeMillis();
    float f2;
    float f1;
    if (paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Int == 2)
    {
      float f4 = 1.0F - paramFloat;
      f2 = f4 * f4 * f4;
      float f3 = paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Float;
      f1 = 3.0F * f4;
      f4 = f4 * f1 * paramFloat;
      float f5 = paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.e;
      float f6 = f1 * paramFloat * paramFloat;
      float f7 = paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.g;
      float f8 = paramFloat * paramFloat * paramFloat;
      float f9 = paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Float;
      f1 = f2 * paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.b + f4 * paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.f + f6 * paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.h + f8 * paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.b;
      f2 = f3 * f2 + f5 * f4 + f7 * f6 + f9 * f8;
    }
    else if (paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Int == 1)
    {
      f2 = paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Float + (paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Float - paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Float) * paramFloat;
      f1 = paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.b + (paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.b - paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.b) * paramFloat;
    }
    else
    {
      f2 = paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.jdField_a_of_type_Float;
      f1 = paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.b;
    }
    PathPoint localPathPoint = PathPoint.b(f2, f1);
    BubbleInterActiveAnim.AnimFrameData localAnimFrameData = new BubbleInterActiveAnim.AnimFrameData();
    localPathPoint.d = (paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.d + (paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.d - paramAnimFrameData1.jdField_a_of_type_ComTencentMobileqqBubblePathPoint.d) * paramFloat);
    localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubblePathPoint = localPathPoint;
    localAnimFrameData.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder = paramAnimFrameData2.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInterActiveAnim$AnimHolder;
    localAnimFrameData.jdField_a_of_type_AndroidGraphicsBitmap = paramAnimFrameData2.jdField_a_of_type_AndroidGraphicsBitmap;
    localAnimFrameData.jdField_a_of_type_JavaLangString = paramAnimFrameData2.jdField_a_of_type_JavaLangString;
    localAnimFrameData.b = paramAnimFrameData2.b;
    localAnimFrameData.jdField_a_of_type_JavaLangBoolean = paramAnimFrameData2.jdField_a_of_type_JavaLangBoolean;
    localAnimFrameData.jdField_a_of_type_Boolean = paramAnimFrameData2.jdField_a_of_type_Boolean;
    localAnimFrameData.jdField_a_of_type_AndroidGraphicsRect = paramAnimFrameData2.jdField_a_of_type_AndroidGraphicsRect;
    return BubbleInterActiveAnim.a(paramFloat, paramAnimFrameData1, paramAnimFrameData2, l, f2, f1, localPathPoint, localAnimFrameData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.PathEvaluator
 * JD-Core Version:    0.7.0.1
 */