package com.tencent.luggage.wxa.a;

import android.graphics.Path;

public class i$c
  implements h.x
{
  Path a = new Path();
  float b;
  float c;
  
  i$c(h.w paramw)
  {
    if (paramw == null) {
      return;
    }
    paramw.a(this);
  }
  
  Path a()
  {
    return this.a;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.a.moveTo(paramFloat1, paramFloat2);
    this.b = paramFloat1;
    this.c = paramFloat2;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a.quadTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.b = paramFloat3;
    this.c = paramFloat4;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.a.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    this.b = paramFloat5;
    this.c = paramFloat6;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
  {
    i.a(this.b, this.c, paramFloat1, paramFloat2, paramFloat3, paramBoolean1, paramBoolean2, paramFloat4, paramFloat5, this);
    this.b = paramFloat4;
    this.c = paramFloat5;
  }
  
  public void b()
  {
    this.a.close();
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    this.a.lineTo(paramFloat1, paramFloat2);
    this.b = paramFloat1;
    this.c = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.i.c
 * JD-Core Version:    0.7.0.1
 */