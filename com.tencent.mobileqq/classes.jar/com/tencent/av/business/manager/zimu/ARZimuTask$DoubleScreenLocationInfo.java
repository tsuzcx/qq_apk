package com.tencent.av.business.manager.zimu;

import android.graphics.PointF;

public class ARZimuTask$DoubleScreenLocationInfo
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString = null;
  volatile boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString = null;
  int c = 0;
  int d = 0;
  int e = 0;
  int f = 0;
  int g = 0;
  
  public PointF a(PointF paramPointF)
  {
    if ((!a()) || (paramPointF == null)) {
      return null;
    }
    float f1 = paramPointF.x * this.d;
    float f2 = paramPointF.y * this.c;
    float f4 = this.jdField_a_of_type_Int;
    float f3 = this.jdField_b_of_type_Int;
    f4 = (f4 + f1) / this.f;
    f3 = (f3 + f2) / this.e;
    ARZimuTask.a("getSmallPointInBigScreen: " + f1 + "|" + f2 + "|" + f4 + "|" + f3 + "|" + this.jdField_a_of_type_Int + "|" + this.jdField_b_of_type_Int);
    return new PointF(f4, f3);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    int i;
    int j;
    if (this.jdField_b_of_type_JavaLangString != null)
    {
      i = 1;
      if ((this.e <= 0) || (this.f <= 0)) {
        break label60;
      }
      j = 1;
      label25:
      if ((this.c <= 0) || (this.d <= 0)) {
        break label65;
      }
    }
    label60:
    label65:
    for (int k = 1;; k = 0)
    {
      if ((i == 0) || (j == 0) || (k == 0)) {
        break label70;
      }
      return true;
      i = 0;
      break;
      j = 0;
      break label25;
    }
    label70:
    return false;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.zimu.ARZimuTask.DoubleScreenLocationInfo
 * JD-Core Version:    0.7.0.1
 */