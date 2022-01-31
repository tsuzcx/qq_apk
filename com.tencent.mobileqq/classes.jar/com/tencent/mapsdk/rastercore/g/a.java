package com.tencent.mapsdk.rastercore.g;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.mapsdk.rastercore.d.a.1;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.c;
import com.tencent.mapsdk.rastercore.d.e;

public final class a
  extends View
{
  private e a;
  private final int[] b = { 12000000, 6000000, 3000000, 1500000, 800000, 400000, 200000, 100000, 50000, 25000, 12000, 6000, 3000, 1500, 800, 400, 200, 100, 50, 25, 17, 8, 4 };
  private int c = 0;
  private String d = "";
  private int e = 0;
  private int f = 0;
  private Paint g;
  private Paint h;
  private Paint i;
  private Rect j;
  private String k;
  private int l = 10;
  private int m = 0;
  private int n = 10;
  private int o = 0;
  private int p = 0;
  private int q = 0;
  private Paint r;
  private AlphaAnimation s = null;
  private AlphaAnimation t = null;
  
  public a(e parame)
  {
    super(e.a());
    this.a = parame;
    this.h = new Paint();
    this.h.setAntiAlias(true);
    this.h.setColor(-16777216);
    this.h.setStrokeWidth(6.0F * parame.f().b());
    this.h.setStyle(Paint.Style.STROKE);
    this.i = new Paint();
    this.i.setAntiAlias(true);
    this.i.setColor(Color.rgb(100, 100, 100));
    this.i.setStrokeWidth(10.0F * parame.f().b());
    this.i.setStyle(Paint.Style.STROKE);
    this.r = new Paint();
    this.r.setAntiAlias(true);
    this.r.setColor(Color.rgb(255, 255, 255));
    this.r.setStrokeWidth(7.0F * parame.f().b());
    this.r.setStyle(Paint.Style.STROKE);
    this.g = new Paint();
    this.g.setAntiAlias(true);
    this.g.setColor(-16777216);
    this.g.setTextSize(25.0F * parame.f().b());
    this.j = new Rect();
  }
  
  public static void b() {}
  
  public static void c() {}
  
  public final void a()
  {
    clearAnimation();
    this.h = null;
    this.g = null;
    this.j = null;
    this.d = null;
    this.i = null;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void d()
  {
    if (!isShown()) {
      return;
    }
    clearAnimation();
    this.t = new AlphaAnimation(1.0F, 0.0F);
    this.t.setDuration(2000L);
    this.t.setFillAfter(true);
    startAnimation(this.t);
  }
  
  public final void e()
  {
    clearAnimation();
    this.s = new AlphaAnimation(0.0F, 1.0F);
    this.s.setDuration(500L);
    this.s.setFillAfter(true);
    startAnimation(this.s);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    double d1 = this.a.b().e();
    int i1 = this.a.c().d().a();
    int i2 = this.b[i1];
    double d2 = i2 / d1;
    this.p = this.a.c().getWidth();
    for (;;)
    {
      d1 = d2;
      i1 = i2;
      if (d2 >= this.p / 5.0D) {
        break;
      }
      d2 *= 2.0D;
      i2 *= 2;
    }
    for (;;)
    {
      d2 = d1;
      i2 = i1;
      if (d1 <= this.p - this.n * 2.0D - 80.0D) {
        break;
      }
      d1 /= 2.0D;
      i1 = (int)(i1 / 2.0D);
    }
    while (d2 > this.p - this.n * 2.0D - 80.0D)
    {
      d2 /= 2.0D;
      i2 = (int)(i2 / 2.0D);
    }
    this.f = ((int)d2);
    String str = "m";
    i1 = i2;
    if (i2 > 2000)
    {
      i1 = i2 / 1000;
      str = "km";
    }
    this.d = (i1 + str);
    this.k = (i1 / 2);
    this.e = (i1 / 2);
    if ((this.d.equals("")) || (this.f == 0)) {
      return;
    }
    this.g.getTextBounds(this.d, 0, this.d.length(), this.j);
    this.o = ((int)(getHeight() - 8 - this.h.getStrokeWidth()));
    this.p = this.a.c().getWidth();
    if (this.c == 1)
    {
      this.l = (this.p / 2 - this.f / 2);
      this.m = (this.p / 2 + this.f / 2);
    }
    for (;;)
    {
      this.q = ((this.l + this.m) / 2);
      paramCanvas.drawLine(this.l, this.o, this.m, this.o, this.i);
      float f1 = this.l;
      paramCanvas.drawLine(this.a.f().b() * 4.0F + f1, this.o, this.q, this.o, this.h);
      paramCanvas.drawText("0", this.l - 6.0F * this.a.f().b(), this.o - this.n, this.g);
      paramCanvas.drawText(this.d, this.m - this.d.length() * 6 * this.a.f().b(), this.o - this.n, this.g);
      if (this.e == 0) {
        break;
      }
      paramCanvas.drawText(this.k, this.q - this.k.length() * 6 * this.a.f().b(), this.o - 10, this.g);
      paramCanvas.drawLine(this.q, this.o, this.m - this.a.f().b() * 4.0F, this.o, this.r);
      return;
      if (this.c == 2)
      {
        this.l = (this.p - this.n - this.f);
        this.m = (this.p - this.n);
      }
      else
      {
        this.l = this.n;
        this.m = (this.n + this.f);
      }
    }
    paramCanvas.drawLine(this.q, this.o, this.m - this.a.f().b() * 4.0F, this.o, this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.g.a
 * JD-Core Version:    0.7.0.1
 */