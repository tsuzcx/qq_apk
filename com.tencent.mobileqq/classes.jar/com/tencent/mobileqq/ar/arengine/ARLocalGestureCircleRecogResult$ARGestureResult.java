package com.tencent.mobileqq.ar.arengine;

import android.graphics.PointF;

public class ARLocalGestureCircleRecogResult$ARGestureResult
{
  public int a;
  public String a;
  public boolean a;
  public PointF[] a;
  public int b = 0;
  public int c = 0;
  public int d = -1;
  
  public ARLocalGestureCircleRecogResult$ARGestureResult()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF = null;
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF = new PointF[1000];
    a();
  }
  
  public ARLocalGestureCircleRecogResult$ARGestureResult(int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF = null;
    this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF = new PointF[paramInt];
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 0;
    this.c = 0;
    this.d = -1;
  }
  
  public String toString()
  {
    Object localObject;
    if (this.b > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append((int)this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.b - 1)].x);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append((int)this.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[(this.b - 1)].y);
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "(-1,-1)";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARGestureResult{, state = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", type = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", pointCnt = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", newPoint(x,y) = ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", mode = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARGestureResult
 * JD-Core Version:    0.7.0.1
 */