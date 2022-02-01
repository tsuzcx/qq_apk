package com.tencent.luggage.wxa.a;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

class i$h
  extends i.i
{
  float a;
  float b;
  RectF c = new RectF();
  
  i$h(i parami, float paramFloat1, float paramFloat2)
  {
    super(parami, null);
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void a(String paramString)
  {
    if (i.a(this.d))
    {
      Object localObject = new Rect();
      i.b(this.d).d.getTextBounds(paramString, 0, paramString.length(), (Rect)localObject);
      localObject = new RectF((Rect)localObject);
      ((RectF)localObject).offset(this.a, this.b);
      this.c.union((RectF)localObject);
    }
    this.a += i.b(this.d).d.measureText(paramString);
  }
  
  public boolean a(h.ay paramay)
  {
    if ((paramay instanceof h.az))
    {
      Object localObject = (h.az)paramay;
      paramay = paramay.u.a(((h.az)localObject).a);
      if (paramay == null)
      {
        i.b("TextPath path reference '%s' not found", new Object[] { ((h.az)localObject).a });
        return false;
      }
      localObject = (h.v)paramay;
      paramay = new i.c(((h.v)localObject).a).a();
      if (((h.v)localObject).e != null) {
        paramay.transform(((h.v)localObject).e);
      }
      localObject = new RectF();
      paramay.computeBounds((RectF)localObject, true);
      this.c.union((RectF)localObject);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.i.h
 * JD-Core Version:    0.7.0.1
 */