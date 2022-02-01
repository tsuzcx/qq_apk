package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;

public class j
{
  public Typeface a;
  public String b = "normal";
  public float c;
  public boolean d;
  public float e;
  public j.a f;
  
  j(Typeface paramTypeface, String paramString, float paramFloat1, boolean paramBoolean, float paramFloat2, j.a parama)
  {
    this.a = paramTypeface;
    this.b = paramString;
    this.c = paramFloat1;
    this.d = paramBoolean;
    this.e = paramFloat2;
    this.f = parama;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MBFontStyle[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("][");
    localStringBuilder.append(this.c);
    localStringBuilder.append("][");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.j
 * JD-Core Version:    0.7.0.1
 */