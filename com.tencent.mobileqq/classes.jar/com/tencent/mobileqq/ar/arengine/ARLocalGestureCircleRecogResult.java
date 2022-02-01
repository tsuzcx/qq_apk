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
    return "ARLocalGestureCircleRecogResult{recogType = " + this.b + ", frameIdx = " + this.jdField_a_of_type_Long + ", gestureResult = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult + ", circleResult = " + this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult
 * JD-Core Version:    0.7.0.1
 */