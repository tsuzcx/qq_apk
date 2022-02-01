package com.tencent.luggage.wxa.pz;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class b
  extends ReplacementSpan
{
  private final String a;
  private final float b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  
  public b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.b = paramInt3;
    this.a = paramString;
    this.c = paramInt4;
    this.d = paramInt5;
    this.e = paramInt6;
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  public int a(Paint paramPaint)
  {
    Paint localPaint = paramPaint;
    if (paramPaint == null) {
      localPaint = new Paint();
    }
    localPaint.setTextSize(this.b);
    return (int)localPaint.measureText(this.a) + this.f + this.g + this.e * 2;
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    paramPaint.setTextSize(this.b);
    paramPaint.setAntiAlias(true);
    paramCharSequence = new RectF();
    paramCharSequence.left = ((int)paramFloat + this.f);
    Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
    paramInt1 = Math.max(0, (paramInt5 - paramInt3 - localFontMetricsInt.descent + localFontMetricsInt.top) / 2 - this.e);
    paramCharSequence.top = (paramInt3 + paramInt1);
    paramCharSequence.bottom = (paramInt5 - paramInt1);
    paramCharSequence.right = (paramCharSequence.left + (int)paramPaint.measureText(this.a) + this.e * 2);
    paramPaint.setColor(this.d);
    paramInt1 = this.e;
    paramCanvas.drawRoundRect(paramCharSequence, paramInt1, paramInt1, paramPaint);
    paramPaint.setColor(this.c);
    paramCanvas.drawText(this.a, paramCharSequence.left + this.e, paramCharSequence.top + this.e - localFontMetricsInt.top, paramPaint);
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    return a(paramPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pz.b
 * JD-Core Version:    0.7.0.1
 */