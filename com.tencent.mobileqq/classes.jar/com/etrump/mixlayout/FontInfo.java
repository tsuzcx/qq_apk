package com.etrump.mixlayout;

import android.graphics.Typeface;

public class FontInfo
{
  public int a;
  public String b;
  public int c;
  public Typeface d;
  public String e;
  public ETFont f;
  public boolean g;
  public int h;
  
  public FontInfo() {}
  
  public FontInfo(int paramInt1, int paramInt2, String paramString)
  {
    this.a = paramInt1;
    this.c = paramInt2;
    this.b = paramString;
  }
  
  public FontInfo(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",path=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontInfo
 * JD-Core Version:    0.7.0.1
 */