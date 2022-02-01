package com.tencent.luggage.wxa.pz;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;

public final class a
  implements LineHeightSpan
{
  private int a;
  private final int b;
  
  public a(float paramFloat, int paramInt)
  {
    this.b = (paramInt & 0x70);
    b(paramFloat);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public boolean a(float paramFloat)
  {
    return this.a != Math.round(paramFloat);
  }
  
  public void b(float paramFloat)
  {
    this.a = Math.round(paramFloat);
  }
  
  public void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramInt1 = -paramFontMetricsInt.ascent;
    paramInt2 = this.a;
    if (paramInt1 > paramInt2)
    {
      paramInt1 = -paramInt2;
      paramFontMetricsInt.ascent = paramInt1;
      paramFontMetricsInt.top = paramInt1;
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.bottom = 0;
      return;
    }
    if (-paramFontMetricsInt.ascent + paramFontMetricsInt.descent > this.a)
    {
      paramFontMetricsInt.descent = paramFontMetricsInt.bottom;
      paramInt1 = paramFontMetricsInt.descent - this.a;
      paramFontMetricsInt.ascent = paramInt1;
      paramFontMetricsInt.top = paramInt1;
      return;
    }
    if (-paramFontMetricsInt.ascent + paramFontMetricsInt.bottom > this.a)
    {
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = (paramFontMetricsInt.ascent + this.a);
      return;
    }
    paramInt1 = -paramFontMetricsInt.top;
    paramInt2 = paramFontMetricsInt.bottom;
    paramInt3 = this.a;
    if (paramInt1 + paramInt2 > paramInt3)
    {
      paramFontMetricsInt.top = (paramFontMetricsInt.bottom - this.a);
      return;
    }
    paramInt1 = paramInt3 - (-paramFontMetricsInt.ascent + paramFontMetricsInt.descent);
    paramInt2 = this.b;
    if (paramInt2 == 48)
    {
      paramFontMetricsInt.descent += paramInt1;
      paramFontMetricsInt.bottom += paramInt1;
      return;
    }
    if (paramInt2 == 80)
    {
      paramFontMetricsInt.top -= paramInt1;
      paramFontMetricsInt.ascent -= paramInt1;
      return;
    }
    if (paramInt2 == 16)
    {
      paramInt1 = Math.round(paramInt1 / 2.0F);
      paramFontMetricsInt.top -= paramInt1;
      paramFontMetricsInt.ascent -= paramInt1;
      paramFontMetricsInt.bottom += paramInt1;
      paramFontMetricsInt.descent += paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pz.a
 * JD-Core Version:    0.7.0.1
 */