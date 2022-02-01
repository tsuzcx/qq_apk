package com.tencent.luggage.wxa.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

class i$d
  extends i.e
{
  private Path f;
  
  i$d(i parami, Path paramPath, float paramFloat1, float paramFloat2)
  {
    super(parami, paramFloat1, paramFloat2);
    this.f = paramPath;
  }
  
  public void a(String paramString)
  {
    if (i.a(this.a))
    {
      if (i.b(this.a).b) {
        i.c(this.a).drawTextOnPath(paramString, this.f, this.b, this.c, i.b(this.a).d);
      }
      if (i.b(this.a).c) {
        i.c(this.a).drawTextOnPath(paramString, this.f, this.b, this.c, i.b(this.a).e);
      }
    }
    this.b += i.b(this.a).d.measureText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.i.d
 * JD-Core Version:    0.7.0.1
 */