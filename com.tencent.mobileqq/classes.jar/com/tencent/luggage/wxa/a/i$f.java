package com.tencent.luggage.wxa.a;

import android.graphics.Paint;
import android.graphics.Path;

class i$f
  extends i.i
{
  float a;
  float b;
  Path c;
  
  i$f(i parami, float paramFloat1, float paramFloat2, Path paramPath)
  {
    super(parami, null);
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramPath;
  }
  
  public void a(String paramString)
  {
    if (i.a(this.d))
    {
      Path localPath = new Path();
      i.b(this.d).d.getTextPath(paramString, 0, paramString.length(), this.a, this.b, localPath);
      this.c.addPath(localPath);
    }
    this.a += i.b(this.d).d.measureText(paramString);
  }
  
  public boolean a(h.ay paramay)
  {
    if ((paramay instanceof h.az))
    {
      i.c("Using <textPath> elements in a clip path is not supported.", new Object[0]);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.i.f
 * JD-Core Version:    0.7.0.1
 */