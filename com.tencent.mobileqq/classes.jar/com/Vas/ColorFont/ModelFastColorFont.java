package com.Vas.ColorFont;

import android.text.style.CharacterStyle;

class ModelFastColorFont
{
  char jdField_a_of_type_Char;
  int jdField_a_of_type_Int;
  CharacterStyle jdField_a_of_type_AndroidTextStyleCharacterStyle;
  boolean jdField_a_of_type_Boolean;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FounderColorModel{type=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", charAt=");
    localStringBuilder.append(this.jdField_a_of_type_Char);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", left=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", top=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", lineIndex=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", isMissingWord=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.ModelFastColorFont
 * JD-Core Version:    0.7.0.1
 */