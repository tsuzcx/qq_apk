package com.tencent.magicbrush.handler.glfont;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class h
{
  private g a;
  private e b;
  private Canvas c;
  private j d;
  private Paint e;
  private c f;
  private char[] g = new char[1];
  private Rect h = new Rect();
  private Rect i = new Rect();
  private List<k> j = new ArrayList();
  private Paint.FontMetrics k = new Paint.FontMetrics();
  
  h(e parame, g paramg)
  {
    a(parame, paramg);
  }
  
  private float a(char paramChar)
  {
    char[] arrayOfChar = this.g;
    arrayOfChar[0] = paramChar;
    this.e.getTextBounds(arrayOfChar, 0, 1, this.h);
    float f1 = this.e.measureText(this.g, 0, 1);
    return Math.max(this.h.width(), f1) + 1.0F;
  }
  
  private void a(char paramChar, Rect paramRect, k paramk, Paint paramPaint)
  {
    if ((paramPaint != null) && (paramk != null))
    {
      if (paramRect == null) {
        return;
      }
      this.g[0] = paramChar;
      this.c.save();
      this.c.clipRect(paramRect);
      this.c.drawText(this.g, 0, 1, paramRect.left - paramk.c, paramRect.top + paramk.e - this.k.bottom - 1.0F, paramPaint);
      this.c.restore();
    }
  }
  
  private void a(e parame, g paramg)
  {
    this.b = parame;
    this.c = new Canvas(this.b.d());
    this.a = paramg;
    c();
  }
  
  private void a(k paramk, int paramInt1, int paramInt2)
  {
    if (paramk == null) {
      return;
    }
    float f1 = paramInt1;
    paramk.b = f1;
    paramk.c = 0.0F;
    paramk.a(f1, paramInt2);
    if (f())
    {
      f1 = (float)Math.ceil(f1 * 0.5F);
      paramk.c -= f1 / 2.0F;
      paramk.d += f1;
    }
    if (d())
    {
      paramk.c -= this.d.e / 2.0F;
      paramk.d += this.d.e;
    }
    if (e())
    {
      paramk.c -= 1.0F;
      paramk.d += 2.0F;
    }
  }
  
  private void a(k paramk, Rect paramRect)
  {
    paramk.a(paramRect.left / this.b.e(), paramRect.top / this.b.f(), paramRect.right / this.b.e(), paramRect.bottom / this.b.f());
  }
  
  private void c()
  {
    this.e = new Paint(1);
    this.e.setTextAlign(Paint.Align.LEFT);
    this.e.setColor(-1);
  }
  
  private boolean d()
  {
    j localj = this.d;
    if (localj == null) {
      return false;
    }
    return localj.d;
  }
  
  private boolean e()
  {
    j localj = this.d;
    if (localj == null) {
      return false;
    }
    return localj.f.b();
  }
  
  private boolean f()
  {
    j localj = this.d;
    if (localj == null) {
      return false;
    }
    return localj.f.a();
  }
  
  float a(String paramString)
  {
    paramString = this.k;
    if (paramString == null) {
      return 0.0F;
    }
    return paramString.bottom - this.k.ascent + 1.0F;
  }
  
  float a(List<k> paramList)
  {
    float f2 = 0.0F;
    float f1 = 0.0F;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return 0.0F;
      }
      paramList = paramList.iterator();
      for (;;)
      {
        f2 = f1;
        if (!paramList.hasNext()) {
          break;
        }
        k localk = (k)paramList.next();
        if (localk != null) {
          f1 += localk.b;
        }
      }
    }
    return f2;
  }
  
  Paint.FontMetrics a()
  {
    return this.k;
  }
  
  k a(char paramChar, int paramInt)
  {
    k localk = this.a.a.a();
    localk.a(false);
    paramInt = (int)Math.ceil(this.k.bottom - this.k.ascent);
    a(localk, (int)Math.ceil(a(paramChar)), paramInt);
    if (!this.b.a((int)Math.ceil(localk.d), (int)Math.ceil(localk.e), this.h)) {
      return null;
    }
    a(localk, this.h);
    a(paramChar, this.h, localk, this.e);
    return localk;
  }
  
  k a(@NonNull Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      k localk = this.a.a.a();
      float f1 = paramInt1;
      localk.b = f1;
      localk.c = 0.0F;
      this.b.a(paramInt1, paramInt2, this.h);
      Rect localRect = this.h;
      if ((localRect.left >= 0) && (localRect.right >= 0) && (localRect.width() > 0) && (localRect.height() > 0))
      {
        localk.a(f1, paramInt2);
        localk.a(localRect.left / this.b.e(), localRect.top / this.b.f(), localRect.right / this.b.e(), localRect.bottom / this.b.f());
        localk.a(true);
        this.c.save();
        this.c.clipRect(localRect);
        paramDrawable.setBounds(localRect);
        paramDrawable.draw(this.c);
        this.c.restore();
        return localk;
      }
      return null;
    }
    throw new IllegalArgumentException("width or height unexpected");
  }
  
  public void a(c paramc)
  {
    this.f = paramc;
  }
  
  void a(j paramj)
  {
    this.d = paramj;
    this.e.setTypeface(paramj.a);
    this.e.setTextSize(paramj.c);
    if (paramj.d)
    {
      this.e.setStyle(Paint.Style.STROKE);
      this.e.setStrokeWidth(paramj.e);
    }
    else
    {
      this.e.setStyle(Paint.Style.FILL);
    }
    this.e.setTextSkewX(0.0F);
    this.e.setFakeBoldText(false);
    if (paramj.f != null)
    {
      if ((paramj.a == null) || (paramj.a.getStyle() != paramj.f.e))
      {
        if ((paramj.f == j.a.c) || (paramj.f == j.a.d)) {
          this.e.setTextSkewX(-0.25F);
        }
        if ((paramj.f == j.a.b) || (paramj.f == j.a.d)) {
          this.e.setFakeBoldText(true);
        }
      }
      if (paramj.f.b()) {
        this.e.setFakeBoldText(true);
      }
    }
    c localc = this.f;
    if (localc != null) {
      localc.a(this.e, paramj.a, paramj.b, paramj.c, paramj.d, paramj.e, paramj.f.b(), paramj.f.a());
    }
    this.e.getFontMetrics(this.k);
  }
  
  void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.h
 * JD-Core Version:    0.7.0.1
 */