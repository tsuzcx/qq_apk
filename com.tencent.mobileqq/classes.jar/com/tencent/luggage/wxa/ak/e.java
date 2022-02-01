package com.tencent.luggage.wxa.ak;

import android.text.Layout.Alignment;
import com.tencent.luggage.wxa.ad.a;

final class e
  extends a
{
  public final long m;
  public final long n;
  
  public e(long paramLong1, long paramLong2, CharSequence paramCharSequence)
  {
    this(paramLong1, paramLong2, paramCharSequence, null, 1.4E-45F, -2147483648, -2147483648, 1.4E-45F, -2147483648, 1.4E-45F);
  }
  
  public e(long paramLong1, long paramLong2, CharSequence paramCharSequence, Layout.Alignment paramAlignment, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3)
  {
    super(paramCharSequence, paramAlignment, paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramFloat3);
    this.m = paramLong1;
    this.n = paramLong2;
  }
  
  public e(CharSequence paramCharSequence)
  {
    this(0L, 0L, paramCharSequence);
  }
  
  public boolean a()
  {
    return (this.d == 1.4E-45F) && (this.g == 1.4E-45F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ak.e
 * JD-Core Version:    0.7.0.1
 */