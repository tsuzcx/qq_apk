package com.tencent.common.galleryactivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.util.ViscousFluidInterpolator;

public class AnimationView
  extends View
{
  private AnimationLister A;
  private Rect B;
  private Rect C;
  private Rect D = new Rect();
  private RectF E = new RectF();
  private Rect F = new Rect();
  public boolean a;
  ViscousFluidInterpolator b = new ViscousFluidInterpolator();
  AccelerateDecelerateInterpolator c = new AccelerateDecelerateInterpolator();
  boolean d = false;
  boolean e = false;
  boolean f = true;
  long g = 0L;
  float h;
  float i;
  float j;
  float k;
  float l;
  Paint m = new Paint(6);
  private int n = 3;
  private int o = 3;
  private long p;
  private long q = 350L;
  private boolean r;
  private boolean s;
  private Drawable t;
  private Rect u;
  private Rect v;
  private Rect w;
  private int x;
  private int y;
  private int z;
  
  public AnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.g = System.currentTimeMillis();
    this.d = true;
    this.w = this.t.copyBounds();
    this.F = new Rect(0, 0, this.t.getIntrinsicWidth(), this.t.getIntrinsicHeight());
    this.t.setBounds(this.F);
  }
  
  private void a(Canvas paramCanvas)
  {
    int i1 = this.n;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return;
        }
        this.r = false;
        localObject = this.A;
        if (localObject != null) {
          ((AnimationLister)localObject).g();
        }
        paramCanvas.save();
        this.t.setBounds(this.v);
        this.t.draw(paramCanvas);
        paramCanvas.restore();
        this.t.setBounds(this.w);
      }
    }
    else
    {
      if ((this.u == null) || (this.v == null) || (this.t == null)) {
        break label890;
      }
      this.p = SystemClock.uptimeMillis();
      this.n = 2;
      paramCanvas.save();
    }
    float f1 = (float)(SystemClock.uptimeMillis() - this.p) / (float)this.q;
    if (f1 >= 1.0F) {
      this.n = 3;
    }
    f1 = Math.min(f1, 1.0F);
    f1 = 1.0F - this.c.getInterpolation(f1);
    Object localObject = this.u;
    Rect localRect = this.v;
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    localRect = new Rect(localRect.left + arrayOfInt[0], localRect.top + arrayOfInt[1], localRect.right + arrayOfInt[0], localRect.bottom + arrayOfInt[1]);
    i1 = localRect.width();
    int i2 = localRect.height();
    float f2 = ((Rect)localObject).width();
    float f3 = ((Rect)localObject).height();
    float f4 = i1;
    float f5 = f2 / f4;
    float f6 = i2;
    float f7 = f3 / f6;
    paramCanvas.save();
    int i3 = this.x;
    if (i3 == 1)
    {
      paramCanvas.translate((((Rect)localObject).left - arrayOfInt[0] - (localRect.left - arrayOfInt[0]) * f7) * f1, (((Rect)localObject).top - arrayOfInt[1] - (localRect.top - arrayOfInt[1]) * f7) * f1);
      f3 = 1.0F - (1.0F - f7) * f1;
      paramCanvas.scale(f3, f3);
      if (this.a)
      {
        f3 = (i1 - i2) / 2.0F;
        paramCanvas.translate(-f3 * f1, 0.0F);
        f2 = localRect.left - arrayOfInt[0];
        f1 = f3 * f1;
        paramCanvas.clipRect(f2 + f1, localRect.top - arrayOfInt[1], localRect.right - arrayOfInt[0] - f1, localRect.bottom - arrayOfInt[1]);
      }
      else
      {
        paramCanvas.clipRect(localRect.left - arrayOfInt[0], localRect.top - arrayOfInt[1], localRect.right - arrayOfInt[0] - (f4 - f2 / f7) * f1, localRect.bottom - arrayOfInt[1]);
      }
    }
    else if (i3 == 2)
    {
      paramCanvas.translate((((Rect)localObject).left - arrayOfInt[0] - (localRect.left - arrayOfInt[0]) * f5) * f1, (((Rect)localObject).top - arrayOfInt[1] - (localRect.top - arrayOfInt[1]) * f5) * f1);
      f2 = 1.0F - (1.0F - f5) * f1;
      paramCanvas.scale(f2, f2);
      if (this.a)
      {
        f4 = (i2 - i1) / 2.0F;
        paramCanvas.translate(0.0F, -f4 * f1);
        f2 = localRect.left - arrayOfInt[0];
        f3 = localRect.top - arrayOfInt[1];
        f1 = f4 * f1;
        paramCanvas.clipRect(f2, f3 + f1, localRect.right - arrayOfInt[0], localRect.bottom - arrayOfInt[1] - f1);
      }
      else
      {
        paramCanvas.clipRect(localRect.left - arrayOfInt[0], localRect.top - arrayOfInt[1], localRect.right - arrayOfInt[0], localRect.bottom - arrayOfInt[1] - (f6 - f3 / f5) * f1);
      }
    }
    else
    {
      paramCanvas.translate((((Rect)localObject).left - arrayOfInt[0] - (localRect.left - arrayOfInt[0]) * f5) * f1, (((Rect)localObject).top - arrayOfInt[1] - (localRect.top - arrayOfInt[1]) * f7) * f1);
      paramCanvas.scale(1.0F - (1.0F - f5) * f1, 1.0F - (1.0F - f7) * f1);
    }
    this.t.setBounds(this.v);
    this.t.draw(paramCanvas);
    paramCanvas.restore();
    invalidate();
    return;
    label890:
    this.n = 3;
    this.r = false;
    localObject = this.A;
    if (localObject != null) {
      ((AnimationLister)localObject).g();
    }
    super.onDraw(paramCanvas);
  }
  
  private void b(Canvas paramCanvas)
  {
    int i1 = this.o;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return;
        }
        paramCanvas = this.A;
        if (paramCanvas != null) {
          paramCanvas.j();
        }
        this.s = false;
        this.t.setBounds(this.w);
      }
    }
    else
    {
      if ((this.u == null) || (this.v == null) || (this.t == null)) {
        break label952;
      }
      this.p = SystemClock.uptimeMillis();
      this.o = 2;
    }
    float f1 = (float)(SystemClock.uptimeMillis() - this.p) / (float)this.q;
    if (f1 >= 1.0F) {
      this.o = 3;
    }
    f1 = Math.min(f1, 1.0F);
    f1 = this.b.getInterpolation(f1);
    Rect localRect1 = this.u;
    Rect localRect2 = this.v;
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    localRect2 = new Rect(localRect2.left + arrayOfInt[0], localRect2.top + arrayOfInt[1], localRect2.right + arrayOfInt[0], localRect2.bottom + arrayOfInt[1]);
    i1 = localRect2.right - localRect2.left;
    int i2 = localRect2.bottom - localRect2.top;
    float f2 = localRect1.right - localRect1.left + this.y;
    float f3 = localRect1.bottom - localRect1.top + this.z;
    float f4 = i1;
    float f5 = f2 / f4;
    float f6 = i2;
    float f7 = f3 / f6;
    paramCanvas.save();
    int i3 = this.x;
    if (i3 == 1)
    {
      paramCanvas.translate((localRect1.left - arrayOfInt[0] - this.y - (localRect2.left - arrayOfInt[0]) * f7) * f1, (localRect1.top - arrayOfInt[1] - this.z - (localRect2.top - arrayOfInt[1]) * f7) * f1);
      f3 = 1.0F - (1.0F - f7) * f1;
      paramCanvas.scale(f3, f3);
      if (this.a)
      {
        f3 = (i1 - i2) / 2.0F;
        paramCanvas.translate(-f3 * f1, 0.0F);
        f2 = localRect2.left - arrayOfInt[0];
        f1 = f3 * f1;
        paramCanvas.clipRect(f2 + f1, localRect2.top - arrayOfInt[1], localRect2.right - arrayOfInt[0] - f1, localRect2.bottom - arrayOfInt[1]);
      }
      else
      {
        paramCanvas.clipRect(localRect2.left - arrayOfInt[0] + this.y / f3 * f1, localRect2.top - arrayOfInt[1] + this.z / f3 * f1, localRect2.right - arrayOfInt[0] - (f4 - f2 / f7) * f1, localRect2.bottom - arrayOfInt[1]);
      }
    }
    else if (i3 == 2)
    {
      paramCanvas.translate((localRect1.left - arrayOfInt[0] - this.y - (localRect2.left - arrayOfInt[0]) * f5) * f1, (localRect1.top - arrayOfInt[1] - this.z - (localRect2.top - arrayOfInt[1]) * f5) * f1);
      f2 = 1.0F - (1.0F - f5) * f1;
      paramCanvas.scale(f2, f2);
      if (this.a)
      {
        f4 = (i2 - i1) / 2.0F;
        paramCanvas.translate(0.0F, -f4 * f1);
        f2 = localRect2.left - arrayOfInt[0];
        f3 = localRect2.top - arrayOfInt[1];
        f1 = f4 * f1;
        paramCanvas.clipRect(f2, f3 + f1, localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - f1);
      }
      else
      {
        paramCanvas.clipRect(localRect2.left - arrayOfInt[0] + this.y / f2 * f1, localRect2.top - arrayOfInt[1] + this.z / f2 * f1, localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - (f6 - f3 / f5) * f1);
      }
    }
    else
    {
      paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f5) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f7) * f1);
      paramCanvas.scale(1.0F - (1.0F - f5) * f1, 1.0F - (1.0F - f7) * f1);
    }
    this.t.setBounds(this.v);
    this.t.draw(paramCanvas);
    paramCanvas.restore();
    invalidate();
    return;
    label952:
    this.o = 3;
    this.s = false;
    super.onDraw(paramCanvas);
    paramCanvas = this.A;
    if (paramCanvas != null) {
      paramCanvas.j();
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    if (this.g > 0L)
    {
      long l1 = System.currentTimeMillis() - this.g;
      this.l = ((float)l1 / (float)this.q);
      if (this.f) {
        this.l = this.c.getInterpolation(this.l);
      } else {
        this.l = this.b.getInterpolation(this.l);
      }
      float f1 = 1.0F - this.l;
      if (this.d) {
        if (l1 <= this.q)
        {
          this.h = (this.B.top * f1 + this.C.top * this.l);
          this.i = (this.B.bottom * f1 + this.C.bottom * this.l);
          this.j = (this.B.left * f1 + this.C.left * this.l);
          this.k = (this.B.right * f1 + this.C.right * this.l);
          this.D.set((int)this.j, (int)this.h, (int)this.k, (int)this.i);
          this.h = (this.u.top * f1 + this.v.top * this.l);
          this.i = (this.u.bottom * f1 + this.v.bottom * this.l);
          this.j = (this.u.left * f1 + this.v.left * this.l);
          this.k = (this.u.right * f1 + this.v.right * this.l);
          this.E.set(this.j, this.h, this.k, this.i);
        }
        else
        {
          this.d = false;
          AnimationLister localAnimationLister = this.A;
          if (localAnimationLister != null) {
            if (this.f) {
              localAnimationLister.g();
            } else {
              localAnimationLister.j();
            }
          }
        }
      }
      f1 = this.E.width() / this.D.width();
      float f2 = this.E.height() / this.D.height();
      paramCanvas.translate(this.E.left - this.D.left * f1, this.E.top - this.D.top * f2);
      paramCanvas.scale(f1, f2);
      paramCanvas.clipRect(this.D);
      this.t.draw(paramCanvas);
      invalidate();
    }
    paramCanvas.restore();
  }
  
  public void a(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.o = 1;
    this.s = true;
    this.t = paramDrawable;
    this.w = paramDrawable.copyBounds();
    this.u = paramRect1;
    this.v = paramRect2;
    this.x = paramInt1;
    this.y = paramInt2;
    this.z = paramInt3;
    this.q = paramLong;
    paramDrawable = this.A;
    if (paramDrawable != null) {
      paramDrawable.i();
    }
    invalidate();
  }
  
  public void a(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, int paramInt, long paramLong)
  {
    this.n = 1;
    this.r = true;
    this.t = paramDrawable;
    this.w = paramDrawable.copyBounds();
    this.u = paramRect1;
    this.v = paramRect2;
    this.x = paramInt;
    this.q = paramLong;
    paramDrawable = this.A;
    if (paramDrawable != null) {
      paramDrawable.h();
    }
    invalidate();
  }
  
  public void a(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, long paramLong)
  {
    this.e = true;
    this.f = true;
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    paramRect3 = new Rect(paramRect3);
    paramRect3.offset(arrayOfInt[0], -arrayOfInt[1]);
    this.B = paramRect1;
    this.C = paramRect2;
    this.u = paramRect3;
    this.v = paramRect4;
    this.t = paramDrawable;
    this.q = paramLong;
    a();
    paramDrawable = this.A;
    if (paramDrawable != null) {
      paramDrawable.h();
    }
  }
  
  public void b(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, long paramLong)
  {
    this.e = true;
    this.f = false;
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    paramRect3 = new Rect(paramRect3);
    paramRect3.offset(arrayOfInt[0], -arrayOfInt[1]);
    this.B = paramRect2;
    this.C = paramRect1;
    this.u = paramRect4;
    this.v = paramRect3;
    this.t = paramDrawable;
    this.q = paramLong;
    a();
    paramDrawable = this.A;
    if (paramDrawable != null) {
      paramDrawable.i();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.e)
    {
      c(paramCanvas);
      return;
    }
    if (this.r)
    {
      a(paramCanvas);
      return;
    }
    if (this.s)
    {
      b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setAnimationListener(AnimationLister paramAnimationLister)
  {
    this.A = paramAnimationLister;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AnimationView
 * JD-Core Version:    0.7.0.1
 */