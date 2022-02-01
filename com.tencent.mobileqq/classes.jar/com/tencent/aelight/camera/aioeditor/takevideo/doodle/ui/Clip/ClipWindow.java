package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import java.lang.reflect.Array;

public class ClipWindow
  implements ClipConstant
{
  private RectF e = new RectF();
  private RectF f = new RectF();
  private RectF g = new RectF();
  private RectF h = new RectF();
  private float[] i = new float[16];
  private float[] j = new float[32];
  private float[][] k = (float[][])Array.newInstance(Float.TYPE, new int[] { 2, 4 });
  private boolean l = false;
  private boolean m = true;
  private boolean n = false;
  private boolean o = false;
  private Matrix p = new Matrix();
  private Paint q = new Paint(1);
  private Paint r = new Paint(1);
  
  public ClipWindow()
  {
    this.q.setStyle(Paint.Style.STROKE);
    this.q.setStrokeCap(Paint.Cap.SQUARE);
    this.r.setStyle(Paint.Style.STROKE);
    this.r.setStrokeCap(Paint.Cap.SQUARE);
    this.r.setColor(201326592);
    this.r.setStrokeWidth(24.0F);
  }
  
  private void d(float paramFloat1, float paramFloat2)
  {
    c(true);
    this.e.set(0.0F, 0.0F, paramFloat1, paramFloat2);
    ClipUtils.a(this.h, this.e, 60.0F);
    this.g.set(this.e);
  }
  
  public void a(float paramFloat)
  {
    if (this.o) {
      this.e.set(this.f.left + (this.g.left - this.f.left) * paramFloat, this.f.top + (this.g.top - this.f.top) * paramFloat, this.f.right + (this.g.right - this.f.right) * paramFloat, this.f.bottom + (this.g.bottom - this.f.bottom) * paramFloat);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.h.set(0.0F, 0.0F, paramFloat1, paramFloat2 * 1.0F);
    if (!this.e.isEmpty())
    {
      ClipUtils.a(this.h, this.e);
      this.g.set(this.e);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.m) {
      return;
    }
    float f1 = this.e.width();
    int i3 = 0;
    float f2 = this.e.height();
    int i1 = 0;
    int i2;
    Object localObject;
    while (i1 < this.k.length)
    {
      i2 = 0;
      for (;;)
      {
        localObject = this.k;
        if (i2 >= localObject[i1].length) {
          break;
        }
        localObject[i1][i2] = (new float[] { f1, f2 }[i1] * a[i2]);
        i2 += 1;
      }
      i1 += 1;
    }
    i1 = 0;
    for (;;)
    {
      localObject = this.i;
      i2 = i3;
      if (i1 >= localObject.length) {
        break;
      }
      localObject[i1] = this.k[(i1 & 0x1)][(1935858840 >>> (i1 << 1) & 0x3)];
      i1 += 1;
    }
    for (;;)
    {
      localObject = this.j;
      if (i2 >= localObject.length) {
        break;
      }
      localObject[i2] = (this.k[(i2 & 0x1)][(179303760 >>> i2 & 0x1)] + c[(d[i2] & 0x3)] + b[(d[i2] >> 2)]);
      i2 += 1;
    }
    paramCanvas.translate(this.e.left, this.e.top);
    this.q.setStyle(Paint.Style.STROKE);
    this.q.setColor(-2130706433);
    this.q.setStrokeWidth(3.0F);
    paramCanvas.drawLines(this.i, this.q);
    paramCanvas.translate(-this.e.left, -this.e.top);
    this.q.setColor(-1);
    this.q.setStrokeWidth(5.0F);
    paramCanvas.drawRect(this.e, this.r);
    paramCanvas.drawRect(this.e, this.q);
    paramCanvas.translate(this.e.left, this.e.top);
    this.q.setColor(-1);
    this.q.setStrokeWidth(10.0F);
    paramCanvas.drawLines(this.j, this.q);
  }
  
  public void a(RectF paramRectF, float paramFloat)
  {
    RectF localRectF = new RectF();
    this.p.setRotate(paramFloat, paramRectF.centerX(), paramRectF.centerY());
    this.p.mapRect(localRectF, paramRectF);
    d(localRectF.width(), localRectF.height());
  }
  
  public void a(ClipConstant.Anchor paramAnchor, float paramFloat1, float paramFloat2)
  {
    paramAnchor.moveFrame(this.h, this.e, paramFloat1, paramFloat2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public boolean a()
  {
    this.f.set(this.e);
    this.g.set(this.e);
    ClipUtils.a(this.h, this.g, 60.0F);
    boolean bool = this.g.equals(this.f) ^ true;
    this.o = bool;
    return bool;
  }
  
  public RectF b(float paramFloat1, float paramFloat2)
  {
    RectF localRectF = new RectF(this.e);
    localRectF.offset(paramFloat1, paramFloat2);
    return localRectF;
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean b()
  {
    return this.o;
  }
  
  public ClipConstant.Anchor c(float paramFloat1, float paramFloat2)
  {
    if ((ClipConstant.Anchor.isCohesionContains(this.e, -48.0F, paramFloat1, paramFloat2)) && (!ClipConstant.Anchor.isCohesionContains(this.e, 48.0F, paramFloat1, paramFloat2)))
    {
      Object localObject = ClipConstant.Anchor.cohesion(this.e, 0.0F);
      int i1 = 0;
      int i3;
      for (int i2 = 0; i1 < localObject.length; i2 = i3)
      {
        i3 = i2;
        if (Math.abs(localObject[i1] - new float[] { paramFloat1, paramFloat2 }[(i1 >> 1)]) < 48.0F) {
          i3 = i2 | 1 << i1;
        }
        i1 += 1;
      }
      localObject = ClipConstant.Anchor.valueOf(i2);
      if (localObject != null) {
        this.o = false;
      }
      return localObject;
    }
    return null;
  }
  
  public void c(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean c()
  {
    return this.l;
  }
  
  public void d(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public boolean d()
  {
    return this.m;
  }
  
  public RectF e()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip.ClipWindow
 * JD-Core Version:    0.7.0.1
 */