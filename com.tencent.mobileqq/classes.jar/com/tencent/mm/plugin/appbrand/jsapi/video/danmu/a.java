package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;

public class a
  implements d
{
  private static int b;
  private static int c;
  private Context a;
  private SpannableString d;
  private int e;
  private int f;
  private StaticLayout g;
  private int h;
  private int i;
  private int j = -1;
  private int k;
  private int l;
  private int m = -1;
  private float n;
  
  public a(Context paramContext, SpannableString paramSpannableString, int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    this.a = paramContext;
    this.d = paramSpannableString;
    c(paramInt2);
    d(paramInt1);
    this.n = paramFloat;
    this.l = paramInt3;
    f();
  }
  
  public static int a(TextPaint paramTextPaint)
  {
    paramTextPaint = paramTextPaint.getFontMetrics();
    return (int)Math.ceil(paramTextPaint.descent - paramTextPaint.top) + 2;
  }
  
  private void c(int paramInt)
  {
    if (paramInt > 0)
    {
      this.k = b.a(this.a, paramInt);
      return;
    }
    this.k = b.a(this.a, b.a);
  }
  
  private void d(int paramInt)
  {
    this.m = paramInt;
  }
  
  private void f()
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setAntiAlias(true);
    localTextPaint.setColor(this.m);
    localTextPaint.setTextSize(this.k);
    this.i = a(localTextPaint);
    SpannableString localSpannableString = this.d;
    this.g = new StaticLayout(localSpannableString, localTextPaint, (int)Layout.getDesiredWidth(localSpannableString, 0, localSpannableString.length(), localTextPaint) + 1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.h = this.g.getWidth();
  }
  
  public float a()
  {
    return this.n;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    int i1 = paramCanvas.getWidth();
    int i2 = paramCanvas.getHeight();
    if ((i1 != b) || (i2 != c))
    {
      b = i1;
      c = i2;
    }
    paramCanvas.save();
    paramCanvas.translate(this.e, this.f);
    this.g.draw(paramCanvas);
    paramCanvas.restore();
    if (!paramBoolean) {
      this.e = ((int)(this.e - b.a() * this.n));
    }
  }
  
  public boolean a(int paramInt)
  {
    int i1 = this.l;
    if (paramInt < i1) {
      return false;
    }
    return paramInt - i1 <= b.b;
  }
  
  public boolean a(d paramd)
  {
    if (paramd.c() + paramd.d() > b) {
      return true;
    }
    if (this.j < 0) {
      this.j = b.a(this.a, 20);
    }
    if (paramd.a() >= this.n) {
      return (paramd.a() == this.n) && (b - (paramd.d() + paramd.c()) < this.j);
    }
    double d1 = (paramd.d() + paramd.c()) / (paramd.a() * b.a()) * this.n * b.a();
    double d2 = b;
    double d3 = this.j;
    Double.isNaN(d3);
    Double.isNaN(d2);
    return d1 > d2 - d3 * 1.5D;
  }
  
  public boolean b()
  {
    int i1 = this.e;
    return (i1 < 0) && (Math.abs(i1) > this.h);
  }
  
  public boolean b(int paramInt)
  {
    return paramInt - this.l > b.b;
  }
  
  public int c()
  {
    return this.h;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public int e()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a
 * JD-Core Version:    0.7.0.1
 */