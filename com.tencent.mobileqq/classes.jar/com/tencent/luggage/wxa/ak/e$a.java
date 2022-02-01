package com.tencent.luggage.wxa.ak;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.util.Log;

public final class e$a
{
  private long a;
  private long b;
  private SpannableStringBuilder c;
  private Layout.Alignment d;
  private float e;
  private int f;
  private int g;
  private float h;
  private int i;
  private float j;
  
  public e$a()
  {
    a();
  }
  
  private a c()
  {
    if (this.d == null)
    {
      this.i = -2147483648;
      return this;
    }
    int k = e.1.a[this.d.ordinal()];
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unrecognized alignment: ");
          localStringBuilder.append(this.d);
          Log.w("WebvttCueBuilder", localStringBuilder.toString());
          this.i = 0;
          return this;
        }
        this.i = 2;
        return this;
      }
      this.i = 1;
      return this;
    }
    this.i = 0;
    return this;
  }
  
  public a a(float paramFloat)
  {
    this.e = paramFloat;
    return this;
  }
  
  public a a(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public a a(long paramLong)
  {
    this.a = paramLong;
    return this;
  }
  
  public a a(Layout.Alignment paramAlignment)
  {
    this.d = paramAlignment;
    return this;
  }
  
  public a a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    this.c = paramSpannableStringBuilder;
    return this;
  }
  
  public void a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = null;
    this.d = null;
    this.e = 1.4E-45F;
    this.f = -2147483648;
    this.g = -2147483648;
    this.h = 1.4E-45F;
    this.i = -2147483648;
    this.j = 1.4E-45F;
  }
  
  public a b(float paramFloat)
  {
    this.h = paramFloat;
    return this;
  }
  
  public a b(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public a b(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public e b()
  {
    if ((this.h != 1.4E-45F) && (this.i == -2147483648)) {
      c();
    }
    return new e(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
  }
  
  public a c(float paramFloat)
  {
    this.j = paramFloat;
    return this;
  }
  
  public a c(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ak.e.a
 * JD-Core Version:    0.7.0.1
 */