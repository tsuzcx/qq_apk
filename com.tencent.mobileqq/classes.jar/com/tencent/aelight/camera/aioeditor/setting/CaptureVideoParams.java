package com.tencent.aelight.camera.aioeditor.setting;

public class CaptureVideoParams
{
  public int a;
  public boolean a;
  private int b;
  public boolean b;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  private CaptureVideoParams(CaptureVideoParams.CaptureVideoParamsBuilder paramCaptureVideoParamsBuilder)
  {
    this.jdField_c_of_type_Boolean = CaptureVideoParams.CaptureVideoParamsBuilder.a(paramCaptureVideoParamsBuilder);
    this.d = CaptureVideoParams.CaptureVideoParamsBuilder.b(paramCaptureVideoParamsBuilder);
    this.jdField_b_of_type_Int = CaptureVideoParams.CaptureVideoParamsBuilder.a(paramCaptureVideoParamsBuilder);
    this.jdField_c_of_type_Int = CaptureVideoParams.CaptureVideoParamsBuilder.b(paramCaptureVideoParamsBuilder);
    this.jdField_a_of_type_Boolean = CaptureVideoParams.CaptureVideoParamsBuilder.c(paramCaptureVideoParamsBuilder);
    this.jdField_b_of_type_Boolean = paramCaptureVideoParamsBuilder.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Int = paramCaptureVideoParamsBuilder.jdField_a_of_type_Int;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public boolean b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.setting.CaptureVideoParams
 * JD-Core Version:    0.7.0.1
 */