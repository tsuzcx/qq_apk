package com.tencent.mobileqq.ar.arengine;

import android.graphics.PointF;

public class ARLocalGestureCircleRecogResult$ARCircleResult
{
  public int a;
  public ARLocalGestureCircleRecogResult.ARCircle a;
  public int[] a;
  public PointF[] a;
  public int b;
  public PointF[] b;
  public int c = 0;
  public int d = 0;
  public int e = 80;
  public int f = 8;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  
  public ARLocalGestureCircleRecogResult$ARCircleResult()
  {
    this.jdField_a_of_type_Int = -2;
    this.jdField_b_of_type_Int = -2;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle = new ARLocalGestureCircleRecogResult.ARCircle();
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF = new PointF[1000];
    this.jdField_b_of_type_ArrayOfAndroidGraphicsPointF = new PointF[1000];
    this.jdField_a_of_type_ArrayOfInt = new int[1000];
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -2;
    this.jdField_b_of_type_Int = -2;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.b = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.c = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.jdField_a_of_type_Float = 0.0F;
    this.c = 0;
    this.d = 0;
    this.f = 10;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
  }
  
  public String toString()
  {
    return "ARCircleResult{, state = " + this.jdField_a_of_type_Int + ", lastState = " + this.jdField_b_of_type_Int + ", pointCnt = " + this.c + ", lastPointCnt = " + this.d + ", genIdx = " + this.g + ", gesturePointCnt = " + this.h + ", stillPointCnt = " + this.i + ", goodPointCnt = " + this.j + ", circle(r,x,y,c) = (" + (int)this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.jdField_a_of_type_Float + "," + (int)this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.b + "," + (int)this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.c + "," + this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.jdField_a_of_type_Boolean + ")" + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARCircleResult
 * JD-Core Version:    0.7.0.1
 */