package com.etrump.mixlayout;

import android.graphics.Typeface;

public class FontInfo
{
  public int a;
  public Typeface a;
  public ETFont a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  
  public FontInfo() {}
  
  public FontInfo(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public FontInfo(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",path=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontInfo
 * JD-Core Version:    0.7.0.1
 */