package com.tencent.mapsdk.rastercore.g;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.mapsdk.rastercore.b.d;
import com.tencent.mapsdk.rastercore.d.a.1;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.c;
import com.tencent.mapsdk.rastercore.d.f;

public final class a
  extends View
{
  private f a;
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
  private double o = 80.0D;
  private int p = 0;
  private int q = 0;
  private int r = 0;
  private Paint s;
  private AlphaAnimation t = null;
  private AlphaAnimation u = null;
  
  public a(f paramf)
  {
    super(f.a());
    this.a = paramf;
    this.h = new Paint();
    this.h.setAntiAlias(true);
    this.h.setColor(-16777216);
    this.h.setStrokeWidth(6.0F * paramf.f().b());
    this.h.setStyle(Paint.Style.STROKE);
    this.i = new Paint();
    this.i.setAntiAlias(true);
    this.i.setColor(Color.rgb(100, 100, 100));
    this.i.setStrokeWidth(10.0F * paramf.f().b());
    this.i.setStyle(Paint.Style.STROKE);
    this.s = new Paint();
    this.s.setAntiAlias(true);
    this.s.setColor(Color.rgb(255, 255, 255));
    this.s.setStrokeWidth(7.0F * paramf.f().b());
    this.s.setStyle(Paint.Style.STROKE);
    this.g = new Paint();
    this.g.setAntiAlias(true);
    this.g.setColor(-16777216);
    this.g.setTextSize(25.0F * paramf.f().b());
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
    this.u = new AlphaAnimation(1.0F, 0.0F);
    this.u.setDuration(2000L);
    this.u.setFillAfter(true);
    startAnimation(this.u);
  }
  
  public final void e()
  {
    clearAnimation();
    this.t = new AlphaAnimation(0.0F, 1.0F);
    this.t.setDuration(500L);
    this.t.setFillAfter(true);
    startAnimation(this.t);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    double d1 = this.a.b().e();
    int i1 = this.a.c().d().a();
    this.q = this.a.c().getWidth();
    if (this.q - this.n * 2.0D - this.o < 0.0D)
    {
      i1 = 0;
      if (i1 != 0) {
        break label266;
      }
    }
    label266:
    while ((this.d.equals("")) || (this.f == 0))
    {
      return;
      int i2 = this.b[i1];
      d1 = i2 / d1;
      double d2;
      for (;;)
      {
        d2 = d1;
        i1 = i2;
        if (d1 >= this.q / 5.0D) {
          break;
        }
        d1 *= 2.0D;
        i2 *= 2;
      }
      while (d2 > this.q - this.n * 2.0D - this.o)
      {
        d2 /= 2.0D;
        i1 = (int)(i1 / 2.0D);
      }
      this.f = ((int)d2);
      String str = "m";
      i2 = i1;
      if (i1 > 2000)
      {
        i2 = i1 / 1000;
        str = "km";
      }
      this.d = (i2 + str);
      this.k = (i2 / 2);
      this.e = (i2 / 2);
      i1 = 1;
      break;
    }
    this.g.getTextBounds(this.d, 0, this.d.length(), this.j);
    this.p = ((int)(getHeight() - 8 - this.h.getStrokeWidth()));
    this.q = this.a.c().getWidth();
    if (this.c == 1)
    {
      this.l = (this.q / 2 - this.f / 2);
      this.m = (this.q / 2 + this.f / 2);
    }
    for (;;)
    {
      this.r = ((this.l + this.m) / 2);
      paramCanvas.drawLine(this.l, this.p, this.m, this.p, this.i);
      float f1 = this.l;
      paramCanvas.drawLine(this.a.f().b() * 4.0F + f1, this.p, this.r, this.p, this.h);
      paramCanvas.drawText("0", this.l - 6.0F * this.a.f().b(), this.p - this.n, this.g);
      paramCanvas.drawText(this.d, this.m - this.d.length() * 6 * this.a.f().b(), this.p - this.n, this.g);
      if (this.e == 0) {
        break;
      }
      paramCanvas.drawText(this.k, this.r - this.k.length() * 6 * this.a.f().b(), this.p - 10, this.g);
      paramCanvas.drawLine(this.r, this.p, this.m - this.a.f().b() * 4.0F, this.p, this.s);
      return;
      if (this.c == 2)
      {
        this.l = (this.q - this.n - this.f);
        this.m = (this.q - this.n);
      }
      else
      {
        this.l = this.n;
        this.m = (this.n + this.f);
      }
    }
    paramCanvas.drawLine(this.r, this.p, this.m - this.a.f().b() * 4.0F, this.p, this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.g.a
 * JD-Core Version:    0.7.0.1
 */