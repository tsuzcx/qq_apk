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
    ARLocalGestureCircleRecogResult.ARCircle localARCircle = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle;
    localARCircle.b = 0.0F;
    localARCircle.c = 0.0F;
    localARCircle.jdField_a_of_type_Float = 0.0F;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARCircleResult{, state = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", lastState = ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", pointCnt = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", lastPointCnt = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", genIdx = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", gesturePointCnt = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", stillPointCnt = ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", goodPointCnt = ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", circle(r,x,y,c) = (");
    localStringBuilder.append((int)this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.jdField_a_of_type_Float);
    localStringBuilder.append(",");
    localStringBuilder.append((int)this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.b);
    localStringBuilder.append(",");
    localStringBuilder.append((int)this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.jdField_a_of_type_Boolean);
    localStringBuilder.append(")");
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARCircleResult
 * JD-Core Version:    0.7.0.1
 */