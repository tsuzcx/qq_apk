package com.tencent.luggage.wxa.a;

import android.graphics.Canvas;
import android.graphics.Paint;

class i$e
  extends i.i
{
  float b;
  float c;
  
  i$e(i parami, float paramFloat1, float paramFloat2)
  {
    super(parami, null);
    this.b = paramFloat1;
    this.c = paramFloat2;
  }
  
  public void a(String paramString)
  {
    i.a("TextSequence render", new Object[0]);
    if (i.a(this.d))
    {
      if (i.b(this.d).b) {
        i.c(this.d).drawText(paramString, this.b, this.c, i.b(this.d).d);
      }
      if (i.b(this.d).c) {
        i.c(this.d).drawText(paramString, this.b, this.c, i.b(this.d).e);
      }
    }
    this.b += i.b(this.d).d.measureText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.i.e
 * JD-Core Version:    0.7.0.1
 */