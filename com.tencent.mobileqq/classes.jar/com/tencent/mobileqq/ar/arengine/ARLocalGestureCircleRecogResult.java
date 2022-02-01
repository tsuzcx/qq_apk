package com.tencent.mobileqq.ar.arengine;

import com.tencent.qphone.base.util.QLog;

public class ARLocalGestureCircleRecogResult
  extends ARLocalRecogResultBase
{
  public long a;
  public ARLocalGestureCircleRecogResult.ARCircleResult a;
  public ARLocalGestureCircleRecogResult.ARGestureResult a;
  
  public ARLocalGestureCircleRecogResult()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult = new ARLocalGestureCircleRecogResult.ARGestureResult();
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult = new ARLocalGestureCircleRecogResult.ARCircleResult();
    a();
  }
  
  public void a()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecogResult.reset");
    this.b = 4096L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.a();
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARLocalGestureCircleRecogResult{recogType = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", frameIdx = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", gestureResult = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult);
    localStringBuilder.append(", circleResult = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult
 * JD-Core Version:    0.7.0.1
 */