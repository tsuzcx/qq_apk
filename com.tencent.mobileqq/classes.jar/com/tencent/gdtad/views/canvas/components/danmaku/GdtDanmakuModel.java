package com.tencent.gdtad.views.canvas.components.danmaku;

import java.util.Random;

class GdtDanmakuModel
{
  private int jdField_a_of_type_Int = 0;
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public GdtDanmakuModel a(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    return this;
  }
  
  public final String a()
  {
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    if ((arrayOfString != null) && (arrayOfString.length != 0))
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      String str = arrayOfString[i];
      i = this.jdField_a_of_type_Int;
      if (i == arrayOfString.length) {
        this.jdField_a_of_type_Int = (i % arrayOfString.length);
      }
      return str;
    }
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
  }
  
  public boolean a()
  {
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    return (arrayOfString == null) || (arrayOfString.length == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.danmaku.GdtDanmakuModel
 * JD-Core Version:    0.7.0.1
 */