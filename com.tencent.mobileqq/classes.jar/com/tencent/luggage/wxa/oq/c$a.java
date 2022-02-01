package com.tencent.luggage.wxa.oq;

import android.graphics.Bitmap;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;

public class c$a
{
  private final String a;
  private final Bitmap b;
  @DrawableRes
  private final int c;
  @ColorInt
  private final int d;
  
  public c$a(String paramString)
  {
    this(paramString, null, 0);
  }
  
  public c$a(String paramString, Bitmap paramBitmap, int paramInt)
  {
    this.a = paramString;
    this.b = paramBitmap;
    this.c = -1;
    this.d = paramInt;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public Bitmap b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oq.c.a
 * JD-Core Version:    0.7.0.1
 */