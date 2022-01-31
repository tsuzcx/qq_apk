package com.tencent.mapsdk.rastercore.e;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.mapsdk.rastercore.f.b;

public class a
  implements c
{
  private LatLng a = null;
  private double b = 0.0D;
  private float c = 10.0F;
  private int d = -16777216;
  private int e = 0;
  private float f = 0.0F;
  private boolean g = true;
  private boolean h = false;
  private DashPathEffect i = null;
  private DashPathEffect j;
  private String k;
  private f l;
  private com.tencent.mapsdk.rastercore.d.a m;
  
  public a(f paramf, CircleOptions paramCircleOptions)
  {
    this.l = paramf;
    this.m = paramf.e();
    this.k = getId();
    this.e = paramCircleOptions.getFillColor();
    this.a = paramCircleOptions.getCenter();
    this.g = paramCircleOptions.isVisible();
    this.c = paramCircleOptions.getStrokeWidth();
    this.f = paramCircleOptions.getZIndex();
    this.d = paramCircleOptions.getStrokeColor();
    this.b = paramCircleOptions.getRadius();
    this.h = paramCircleOptions.getStrokeDash();
    this.i = paramCircleOptions.getStrokeDashPathEffect();
    this.j = new DashPathEffect(new float[] { this.c, this.c }, 0.0F);
  }
  
  public LatLng a()
  {
    return this.a;
  }
  
  public void a(double paramDouble)
  {
    this.b = paramDouble;
    this.l.a(false, false);
  }
  
  public void a(float paramFloat)
  {
    this.c = paramFloat;
    this.j = new DashPathEffect(new float[] { this.c, this.c }, 0.0F);
    this.l.a(false, false);
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    this.l.a(false, false);
  }
  
  public void a(DashPathEffect paramDashPathEffect)
  {
    this.i = paramDashPathEffect;
  }
  
  public void a(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    this.l.a(false, false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public double b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
    this.l.a(false, false);
  }
  
  public boolean b(LatLng paramLatLng)
  {
    return this.b >= com.tencent.mapsdk.rastercore.c.a(this.a, paramLatLng);
  }
  
  public float c()
  {
    return this.c;
  }
  
  public boolean checkInBounds()
  {
    return true;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public void destroy()
  {
    this.a = null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((a() == null) || (this.b <= 0.0D) || (!isVisible())) {}
    float f1;
    PointF localPointF;
    Paint localPaint;
    do
    {
      return;
      f1 = this.l.b().a(this.a.getLatitude(), (float)b());
      localPointF = this.l.b().a(this.a);
      localPaint = new Paint();
      localPaint.setColor(e());
      localPaint.setAntiAlias(true);
      localPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawCircle(localPointF.x, localPointF.y, f1, localPaint);
    } while (b.a(c(), 0.0F));
    if (this.h)
    {
      if (this.i != null) {
        break label187;
      }
      localPaint.setPathEffect(this.j);
    }
    for (;;)
    {
      localPaint.setColor(d());
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setStrokeWidth(c());
      paramCanvas.drawCircle(localPointF.x, localPointF.y, f1, localPaint);
      return;
      label187:
      localPaint.setPathEffect(this.i);
    }
  }
  
  public int e()
  {
    return this.e;
  }
  
  public boolean equalsRemote(c paramc)
  {
    return (equals(paramc)) || (paramc.getId().equals(getId()));
  }
  
  public boolean f()
  {
    return this.h;
  }
  
  public DashPathEffect g()
  {
    return this.i;
  }
  
  public String getId()
  {
    if (this.k == null) {
      this.k = com.tencent.mapsdk.rastercore.d.a.a("Circle");
    }
    return this.k;
  }
  
  public float getZIndex()
  {
    return this.f;
  }
  
  public int hashCodeRemote()
  {
    return 0;
  }
  
  public boolean isVisible()
  {
    return this.g;
  }
  
  public void remove()
  {
    this.m.b(getId());
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.g = paramBoolean;
    this.l.a(false, false);
  }
  
  public void setZIndex(float paramFloat)
  {
    this.f = paramFloat;
    this.m.c();
    this.l.a(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.e.a
 * JD-Core Version:    0.7.0.1
 */