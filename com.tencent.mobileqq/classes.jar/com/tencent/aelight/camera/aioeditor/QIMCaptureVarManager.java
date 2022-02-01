package com.tencent.aelight.camera.aioeditor;

import com.tencent.aelight.camera.aioeditor.capture.IQIMManager;

public class QIMCaptureVarManager
  extends IQIMManager
{
  public int a;
  private boolean jdField_a_of_type_Boolean = false;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[2];
  private int jdField_b_of_type_Int = 1;
  private String[] jdField_b_of_type_ArrayOfJavaLangString = new String[2];
  private int c = 0;
  
  public QIMCaptureVarManager()
  {
    this.jdField_a_of_type_Int = 2;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString[this.c] = paramString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 14;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1)
    {
      if ((paramInt & this.jdField_b_of_type_Int) != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_ArrayOfJavaLangString[this.c] = paramString;
  }
  
  public String[] b()
  {
    return this.jdField_b_of_type_ArrayOfJavaLangString;
  }
  
  public void c(int paramInt)
  {
    if ((paramInt > -1) && (paramInt < 2)) {
      this.c = paramInt;
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = null;
    this.jdField_b_of_type_ArrayOfJavaLangString[paramInt] = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.QIMCaptureVarManager
 * JD-Core Version:    0.7.0.1
 */