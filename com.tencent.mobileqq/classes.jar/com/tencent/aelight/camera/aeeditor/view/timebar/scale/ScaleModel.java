package com.tencent.aelight.camera.aeeditor.view.timebar.scale;

public class ScaleModel
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScaleModel{mStartValue=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", mEndValue=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", mCurrSizeParamIndex=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mMaxSpace=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mMinSpace=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mPixelsPerScaler=");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", mCoursePosition=");
    localStringBuilder.append(this.jdField_b_of_type_Float);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleModel
 * JD-Core Version:    0.7.0.1
 */