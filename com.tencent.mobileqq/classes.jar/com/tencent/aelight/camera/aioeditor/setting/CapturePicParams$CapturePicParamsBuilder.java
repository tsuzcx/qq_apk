package com.tencent.aelight.camera.aioeditor.setting;

import com.tencent.aelight.camera.aioeditor.AIOShortVideoUtil;
import dov.com.qq.im.ae.current.SessionWrap;

public class CapturePicParams$CapturePicParamsBuilder
{
  public int a;
  private SessionWrap jdField_a_of_type_DovComQqImAeCurrentSessionWrap;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public CapturePicParams$CapturePicParamsBuilder(int paramInt)
  {
    int i = 1;
    this.c = 1;
    this.jdField_b_of_type_Boolean = true;
    this.d = 11;
    this.f = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    if (paramInt == 2) {
      i = 0;
    }
    this.jdField_b_of_type_Int = i;
  }
  
  public CapturePicParamsBuilder a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public CapturePicParamsBuilder a(SessionWrap paramSessionWrap)
  {
    this.jdField_a_of_type_DovComQqImAeCurrentSessionWrap = paramSessionWrap;
    if (paramSessionWrap != null) {
      this.d = AIOShortVideoUtil.a(paramSessionWrap.jdField_a_of_type_Int);
    }
    return this;
  }
  
  public CapturePicParamsBuilder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public CapturePicParams a()
  {
    return new CapturePicParams(this, null);
  }
  
  public CapturePicParamsBuilder b(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.setting.CapturePicParams.CapturePicParamsBuilder
 * JD-Core Version:    0.7.0.1
 */