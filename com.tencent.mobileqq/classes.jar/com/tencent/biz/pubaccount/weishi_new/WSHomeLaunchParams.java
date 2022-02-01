package com.tencent.biz.pubaccount.weishi_new;

import android.content.Context;

public class WSHomeLaunchParams
{
  private final int jdField_a_of_type_Int;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  
  public WSHomeLaunchParams(Context paramContext, int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public WSHomeLaunchParams a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public WSHomeLaunchParams a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public WSHomeLaunchParams b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public WSHomeLaunchParams b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public WSHomeLaunchParams c(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public String c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeLaunchParams
 * JD-Core Version:    0.7.0.1
 */