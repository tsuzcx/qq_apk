package com.Vas.ColorFont;

import android.text.style.CharacterStyle;

class ModelFastColorFont
{
  int a;
  char b;
  int c;
  int d;
  int e;
  int f;
  int g;
  boolean h;
  CharacterStyle i;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FounderColorModel{type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", charAt=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", left=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", top=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", lineIndex=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", isMissingWord=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.ModelFastColorFont
 * JD-Core Version:    0.7.0.1
 */