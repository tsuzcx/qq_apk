package com.tencent.mobileqq.activity.home.impl;

public class FrameInfoBean
{
  private int jdField_a_of_type_Int;
  private Class jdField_a_of_type_JavaLangClass;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public FrameInfoBean(Class paramClass, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this(paramClass, false, paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public FrameInfoBean(Class paramClass, boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Class a()
  {
    return this.jdField_a_of_type_JavaLangClass;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.FrameInfoBean
 * JD-Core Version:    0.7.0.1
 */