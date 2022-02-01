package com.tencent.luggage.wxa.rx;

import android.graphics.Paint;
import android.text.TextPaint;

final class b$c
  implements Runnable
{
  TextPaint a = new TextPaint();
  String b;
  float[] c;
  volatile boolean d = false;
  
  b$c(String paramString, TextPaint paramTextPaint)
  {
    this.a.set(paramTextPaint);
    this.b = paramString;
  }
  
  public float[] a(Paint paramPaint)
  {
    float f1 = paramPaint.getTextSize();
    float f2 = this.a.getTextSize();
    paramPaint = null;
    if (f1 != f2) {
      return null;
    }
    if (this.d) {
      paramPaint = this.c;
    }
    return paramPaint;
  }
  
  public void run()
  {
    this.c = new float[this.b.length()];
    this.a.getTextWidths(this.b, this.c);
    this.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rx.b.c
 * JD-Core Version:    0.7.0.1
 */