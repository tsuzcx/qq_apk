package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Property;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class GroundDrawable
  extends Drawable
  implements Animatable
{
  private int A = -1;
  private boolean B = false;
  private Drawable C;
  private boolean D = false;
  private int E = 0;
  private ValueAnimator F;
  private WeakReference<GroundDrawable.GroundDrawableListener> G;
  Property<GroundDrawable, Float> a = new GroundDrawable.1(this, Float.class, "backHeight");
  Property<GroundDrawable, Integer> b = new GroundDrawable.2(this, Integer.class, "backAlpha");
  Property<GroundDrawable, Integer> c = new GroundDrawable.3(this, Integer.class, "speedAlpha");
  Property<GroundDrawable, Integer> d = new GroundDrawable.4(this, Integer.class, "reverseAlpha");
  Property<GroundDrawable, Float> e = new GroundDrawable.5(this, Float.class, "foreSpeed");
  Property<GroundDrawable, Float> f = new GroundDrawable.6(this, Float.class, "foreHeight");
  Property<GroundDrawable, Float> g = new GroundDrawable.7(this, Float.class, "speedPos");
  Property<GroundDrawable, Integer> h = new GroundDrawable.8(this, Integer.class, "markAlpha");
  private float i = 16.0F;
  private float j = 5.0F;
  private float k = 50.0F;
  private float l = 50.0F;
  private float m = 30.0F;
  private float n = 22.0F;
  private PickerBack o = new PickerBack();
  private RectF p = new RectF();
  private RectF q = new RectF();
  private int r = 0;
  private int s = 255;
  private int t = 0;
  private int u = 179;
  private int v = 0;
  private int w = 179;
  private PickerFore x = new PickerFore();
  private RectF y = new RectF();
  private Drawable z;
  
  private void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    Object localObject = this.F;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.F.removeAllUpdateListeners();
      this.F = null;
    }
    int i1 = getBounds().height();
    PropertyValuesHolder localPropertyValuesHolder1;
    PropertyValuesHolder localPropertyValuesHolder2;
    if (paramInt1 == 1)
    {
      localObject = this.a;
      paramFloat1 = this.p.height();
      paramFloat2 = i1;
      localObject = PropertyValuesHolder.ofFloat((Property)localObject, new float[] { paramFloat1, paramFloat2 });
      localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat(this.f, new float[] { this.y.height(), paramFloat2 });
      localPropertyValuesHolder2 = PropertyValuesHolder.ofInt(this.b, new int[] { this.r, 115 });
      this.F = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject, localPropertyValuesHolder1, PropertyValuesHolder.ofInt(this.c, new int[] { this.s, 0 }), PropertyValuesHolder.ofInt(this.d, new int[] { this.v, 255 }), localPropertyValuesHolder2, PropertyValuesHolder.ofInt(this.h, new int[] { this.w, 127 }) });
      this.F.setDuration(paramInt2);
    }
    else if (paramInt1 == 3)
    {
      localObject = PropertyValuesHolder.ofInt(this.b, new int[] { this.r, 0 });
      localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat(this.a, new float[] { this.p.height(), 0.0F });
      localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat(this.f, new float[] { this.y.height(), (int)(i1 * 0.9F) });
      PropertyValuesHolder localPropertyValuesHolder3 = PropertyValuesHolder.ofFloat(this.e, new float[] { this.q.height(), (int)this.k });
      PropertyValuesHolder localPropertyValuesHolder4 = PropertyValuesHolder.ofInt(this.c, new int[] { this.s, 255 });
      this.F = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject, localPropertyValuesHolder2, localPropertyValuesHolder3, PropertyValuesHolder.ofInt(this.d, new int[] { this.v, 0 }), localPropertyValuesHolder1, localPropertyValuesHolder4, PropertyValuesHolder.ofInt(this.h, new int[] { this.w, 179 }) });
      this.F.setDuration(paramInt2);
    }
    else if (paramInt1 == 4)
    {
      this.F = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(this.g, new float[] { paramFloat1, paramFloat2 }) });
      this.F.setDuration(paramInt2);
    }
    localObject = this.F;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).setRepeatMode(1);
      this.F.setRepeatCount(0);
      this.F.setStartDelay(0L);
      this.F.addUpdateListener(new GroundDrawable.9(this));
      this.F.addListener(new GroundDrawable.10(this));
      this.F.start();
    }
  }
  
  private void a(Context paramContext)
  {
    this.k = PickerContainer.a(paramContext, this.k);
    this.l = PickerContainer.a(paramContext, this.l);
    this.m = PickerContainer.a(paramContext, this.m);
    this.n = PickerContainer.a(paramContext, this.n);
    this.j = PickerContainer.a(paramContext, this.j);
    this.i /= paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(Canvas paramCanvas)
  {
    Object localObject = this.x.a(this.A);
    if (localObject != null)
    {
      float f1 = ((RectF)localObject).centerX();
      float f2 = ((RectF)localObject).centerY();
      f1 -= this.q.width() / 2.0F;
      f2 -= this.q.height() / 2.0F;
      float f3 = this.q.width();
      float f4 = this.q.height();
      paramCanvas.save();
      localObject = this.z;
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds((int)f1, (int)f2, (int)(f3 + f1), (int)(f4 + f2));
        this.z.setAlpha(this.s);
        this.z.draw(paramCanvas);
      }
      paramCanvas.restore();
    }
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean)
  {
    RectF localRectF = this.x.a(this.t - 1);
    if ((localRectF != null) && (this.C != null))
    {
      float f3 = localRectF.centerX();
      float f2 = localRectF.centerY();
      float f1 = this.m;
      f3 -= f1 / 2.0F;
      float f4 = this.n;
      f2 -= f4 / 2.0F;
      this.C.setBounds((int)f3, (int)f2, (int)(f1 + f3), (int)(f4 + f2));
      if (!paramBoolean) {
        this.C.setAlpha(this.v);
      } else {
        this.C.setAlpha(255);
      }
      this.C.draw(paramCanvas);
    }
  }
  
  private void a(Rect paramRect)
  {
    if (paramRect == null) {
      return;
    }
    if (this.D)
    {
      if (QLog.isColorLevel())
      {
        paramRect = new StringBuilder();
        paramRect.append("isrunning, cannot resetdata:");
        paramRect.append(this.E);
        QLog.d("GroundDrawable", 2, paramRect.toString());
      }
      return;
    }
    int i1 = this.E;
    if ((i1 != 0) && (i1 != 1))
    {
      if ((i1 == 3) || (i1 == 2))
      {
        a(this.p, paramRect.height());
        a(this.y, paramRect.height());
        paramRect = this.o;
        if (paramRect != null) {
          paramRect.a(this.p);
        }
        paramRect = this.x;
        if (paramRect != null) {
          paramRect.a(this.y);
        }
      }
    }
    else
    {
      a(this.p, paramRect.height() * 0.4F);
      PickerBack localPickerBack = this.o;
      if (localPickerBack != null) {
        localPickerBack.a(this.p);
      }
      a(this.y, paramRect.height() * 0.9F);
      paramRect = this.x;
      if (paramRect != null) {
        paramRect.a(this.y);
      }
    }
  }
  
  private void a(RectF paramRectF, float paramFloat)
  {
    if (paramRectF == null) {
      return;
    }
    Rect localRect = getBounds();
    float f1 = paramFloat;
    if (localRect.height() < paramFloat) {
      f1 = localRect.height();
    }
    float f2 = localRect.width() * 1.0F / localRect.height() * f1;
    paramFloat = f2;
    if (localRect.width() < f2) {
      paramFloat = localRect.width();
    }
    f2 = (localRect.width() - paramFloat) / 2.0F;
    float f3 = (localRect.height() - f1) / 2.0F;
    paramRectF.set(f2, f3, paramFloat + f2, f1 + f3);
  }
  
  private void a(Float paramFloat)
  {
    if (this.E == 3)
    {
      RectF localRectF = this.q;
      localRectF.left = (localRectF.centerX() - paramFloat.floatValue() / 2.0F);
      localRectF = this.q;
      localRectF.right = (localRectF.centerX() + paramFloat.floatValue() / 2.0F);
      localRectF = this.q;
      localRectF.top = (localRectF.centerY() - paramFloat.floatValue() / 2.0F);
      localRectF = this.q;
      localRectF.bottom = (localRectF.centerY() + paramFloat.floatValue() / 2.0F);
    }
  }
  
  private void b(int paramInt)
  {
    int i1 = this.E;
    if ((i1 != 3) && (i1 != 1))
    {
      if (i1 == 0)
      {
        this.w = 179;
        return;
      }
      this.w = 127;
      return;
    }
    this.w = paramInt;
  }
  
  private void b(Canvas paramCanvas)
  {
    Drawable localDrawable = this.z;
    if (localDrawable != null)
    {
      localDrawable.setBounds((int)this.q.left, (int)this.q.top, (int)this.q.right, (int)this.q.bottom);
      this.z.setAlpha(this.s);
      this.z.draw(paramCanvas);
    }
  }
  
  private void c(float paramFloat)
  {
    if (this.E == 4)
    {
      float f1 = this.q.centerY();
      this.q.offset(0.0F, paramFloat - f1);
      Object localObject = this.G;
      if (localObject != null)
      {
        localObject = (GroundDrawable.GroundDrawableListener)((WeakReference)localObject).get();
        if (localObject != null) {
          ((GroundDrawable.GroundDrawableListener)localObject).a(this.E, this.q);
        }
      }
    }
  }
  
  private void c(int paramInt)
  {
    int i1 = this.E;
    if ((i1 != 3) && (i1 != 1))
    {
      this.r = 115;
      return;
    }
    this.r = paramInt;
  }
  
  private float d()
  {
    return this.q.centerY();
  }
  
  private void d(float paramFloat)
  {
    int i1 = this.E;
    if ((i1 == 1) || (i1 == 3))
    {
      a(this.p, paramFloat);
      PickerBack localPickerBack = this.o;
      if (localPickerBack != null) {
        localPickerBack.a(this.p);
      }
    }
  }
  
  private void d(int paramInt)
  {
    int i1 = this.E;
    if ((i1 != 1) && (i1 != 3))
    {
      this.r = 255;
      return;
    }
    this.s = paramInt;
  }
  
  private float e()
  {
    return this.q.height();
  }
  
  private void e(float paramFloat)
  {
    int i1 = this.E;
    if ((i1 == 1) || (i1 == 3))
    {
      a(this.y, paramFloat);
      Object localObject = this.x;
      if (localObject != null)
      {
        ((PickerFore)localObject).a(this.y);
        localObject = this.G;
        if (localObject != null)
        {
          localObject = (GroundDrawable.GroundDrawableListener)((WeakReference)localObject).get();
          if (localObject != null) {
            ((GroundDrawable.GroundDrawableListener)localObject).a(this.E, a());
          }
        }
      }
    }
  }
  
  private void e(int paramInt)
  {
    int i1 = this.E;
    if (i1 == 1)
    {
      this.v = paramInt;
      this.u = (255 - this.v);
      return;
    }
    if (i1 == 3)
    {
      this.v = paramInt;
      this.u = ((int)((255 - this.v) * 179 * 1.0F / 255.0F));
    }
  }
  
  private float f()
  {
    return this.p.height();
  }
  
  private void f(int paramInt)
  {
    Object localObject = this.G;
    if (localObject == null) {
      return;
    }
    localObject = (GroundDrawable.GroundDrawableListener)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((GroundDrawable.GroundDrawableListener)localObject).b(paramInt);
  }
  
  private int g()
  {
    return this.w;
  }
  
  private void g(int paramInt)
  {
    Object localObject = this.G;
    if (localObject == null) {
      return;
    }
    localObject = (GroundDrawable.GroundDrawableListener)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((GroundDrawable.GroundDrawableListener)localObject).a(paramInt);
  }
  
  private int h()
  {
    return this.r;
  }
  
  private void h(int paramInt)
  {
    Object localObject = this.G;
    if (localObject == null) {
      return;
    }
    localObject = (GroundDrawable.GroundDrawableListener)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((GroundDrawable.GroundDrawableListener)localObject).c(paramInt);
  }
  
  private int i()
  {
    return this.v;
  }
  
  private int j()
  {
    return this.s;
  }
  
  private float k()
  {
    return this.y.height();
  }
  
  public int a(float paramFloat)
  {
    PickerFore localPickerFore = this.x;
    if (localPickerFore != null) {
      return localPickerFore.a(paramFloat);
    }
    return 0;
  }
  
  public RectF a()
  {
    PickerFore localPickerFore = this.x;
    if (localPickerFore != null) {
      return localPickerFore.a(this.A);
    }
    return null;
  }
  
  public RectF a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = this.A;
    this.A = paramInt;
    if (paramBoolean1) {
      this.B = paramBoolean1;
    }
    Object localObject1 = this.x;
    if (localObject1 != null)
    {
      localObject1 = ((PickerFore)localObject1).a(paramInt);
      if (localObject1 != null)
      {
        Object localObject2;
        if (!paramBoolean2)
        {
          this.q.set(((RectF)localObject1).centerX() - this.k / 2.0F, ((RectF)localObject1).centerY() - this.l / 2.0F, ((RectF)localObject1).centerX() + this.l / 2.0F, ((RectF)localObject1).centerY() + this.l / 2.0F);
          if (paramBoolean1)
          {
            localObject2 = this.G;
            if (localObject2 != null)
            {
              localObject2 = (GroundDrawable.GroundDrawableListener)((WeakReference)localObject2).get();
              if (localObject2 != null)
              {
                ((GroundDrawable.GroundDrawableListener)localObject2).a(this.E, this.A, (RectF)localObject1);
                this.B = false;
              }
            }
          }
          invalidateSelf();
        }
        else
        {
          localObject2 = this.x.a(i1);
          if (localObject2 != null)
          {
            this.q.set(((RectF)localObject2).centerX() - this.k / 2.0F, ((RectF)localObject2).centerY() - this.l / 2.0F, ((RectF)localObject2).centerX() + this.l / 2.0F, ((RectF)localObject2).centerY() + this.l / 2.0F);
            float f1 = Math.abs(((RectF)localObject2).centerY() - ((RectF)localObject1).centerY());
            float f2 = this.i;
            if (isRunning()) {
              stop();
            }
            this.E = 4;
            this.D = true;
            a(this.E, (int)(f1 * f2), ((RectF)localObject2).centerY(), ((RectF)localObject1).centerY());
          }
        }
      }
    }
    return this.q;
  }
  
  public void a(int paramInt)
  {
    this.E = paramInt;
    paramInt = this.E;
  }
  
  public boolean a(Context paramContext, int paramInt, float paramFloat1, float paramFloat2, GroundDrawable.GroundDrawableListener paramGroundDrawableListener)
  {
    this.G = new WeakReference(paramGroundDrawableListener);
    if (paramInt > 0) {
      this.i /= paramInt;
    }
    a(paramContext);
    this.t = paramInt;
    this.x.a(-1, paramInt, this.j, paramFloat1, paramFloat2);
    this.o.a(0, paramFloat1, paramFloat2);
    this.z = paramContext.getResources().getDrawable(2130842511);
    this.C = paramContext.getResources().getDrawable(2130842510);
    return true;
  }
  
  public int b()
  {
    return this.E;
  }
  
  public RectF b(float paramFloat)
  {
    int i1 = a(paramFloat);
    PickerFore localPickerFore = this.x;
    if (localPickerFore != null) {
      return localPickerFore.a(i1);
    }
    return null;
  }
  
  public void c()
  {
    this.x.a();
    this.o.a();
    this.z = null;
    this.C = null;
    this.D = false;
    ValueAnimator localValueAnimator = this.F;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.F.removeAllUpdateListeners();
      this.F = null;
    }
    this.G = null;
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i1 = this.E;
    if (i1 == 0)
    {
      this.x.a(paramCanvas, this.u, this.A, (int)(this.v * 1.0F * 179.0F / 255.0F), this.w);
      i1 = this.A;
      if ((i1 >= 0) && (i1 < this.t)) {
        a(paramCanvas);
      }
    }
    else if ((i1 != 1) && (i1 != 3) && (i1 != 2))
    {
      if (i1 == 4)
      {
        RectF localRectF = a();
        if (localRectF != null) {
          if (Math.abs(localRectF.centerY() - this.q.centerY()) < this.q.height() / 2.0F) {
            this.x.a(paramCanvas, this.u, this.A, (int)(this.v * 1.0F * 179.0F / 255.0F), this.w);
          } else {
            this.x.a(paramCanvas, this.u, -1, (int)(this.v * 1.0F * 179.0F / 255.0F), this.w);
          }
        }
        i1 = this.A;
        if ((i1 >= 0) && (i1 < this.t)) {
          b(paramCanvas);
        }
      }
    }
    else
    {
      this.o.a(paramCanvas, this.r);
      this.x.a(paramCanvas, this.u, this.A, (int)(this.v * 1.0F * 127.0F / 255.0F), this.w);
      a(paramCanvas, false);
      i1 = this.E;
      if ((i1 == 3) || (i1 == 1))
      {
        if (this.A == this.t - 1)
        {
          a(paramCanvas, true);
          return;
        }
        a(paramCanvas);
      }
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return this.D;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    a(paramRect);
    int i1 = this.A;
    if (i1 >= 0)
    {
      a(i1, false, false);
      if (this.B)
      {
        paramRect = this.G;
        if (paramRect != null)
        {
          paramRect = (GroundDrawable.GroundDrawableListener)paramRect.get();
          if (paramRect != null)
          {
            RectF localRectF = new RectF();
            localRectF.set(this.q);
            paramRect.a(this.E, this.A, localRectF);
            this.B = false;
          }
        }
      }
      this.B = false;
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void start()
  {
    if (isRunning()) {
      stop();
    }
    this.D = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start :");
      localStringBuilder.append(this.E);
      QLog.d("GroundDrawable", 2, localStringBuilder.toString());
    }
    int i1 = this.E;
    if ((i1 != 1) && (i1 != 0))
    {
      if ((i1 == 3) || (i1 == 2))
      {
        this.E = 3;
        a(this.E, 200, -1.0F, -1.0F);
      }
    }
    else
    {
      this.E = 1;
      a(this.E, 300, -1.0F, -1.0F);
    }
  }
  
  public void stop()
  {
    if (!this.D) {
      return;
    }
    this.D = false;
    ValueAnimator localValueAnimator = this.F;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.F.removeAllUpdateListeners();
      this.F = null;
    }
    int i1 = this.E;
    if (i1 == 1)
    {
      this.E = 2;
      a(getBounds());
      this.r = 115;
      return;
    }
    if (i1 == 3)
    {
      this.E = 0;
      a(getBounds());
      this.r = 115;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.GroundDrawable
 * JD-Core Version:    0.7.0.1
 */