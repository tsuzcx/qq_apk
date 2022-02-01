package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.color.MaterialColors;

final class CircularIndeterminateAnimatorDelegate
  extends IndeterminateAnimatorDelegate<ObjectAnimator>
{
  private static final int[] e = { 0, 1350, 2700, 4050 };
  private static final int[] f = { 667, 2017, 3367, 4717 };
  private static final int[] g = { 1000, 2350, 3700, 5050 };
  private static final Property<CircularIndeterminateAnimatorDelegate, Float> o = new CircularIndeterminateAnimatorDelegate.3(Float.class, "animationFraction");
  private static final Property<CircularIndeterminateAnimatorDelegate, Float> p = new CircularIndeterminateAnimatorDelegate.4(Float.class, "completeEndFraction");
  Animatable2Compat.AnimationCallback a = null;
  private ObjectAnimator h;
  private ObjectAnimator i;
  private final FastOutSlowInInterpolator j;
  private final BaseProgressIndicatorSpec k;
  private int l = 0;
  private float m;
  private float n;
  
  public CircularIndeterminateAnimatorDelegate(@NonNull CircularProgressIndicatorSpec paramCircularProgressIndicatorSpec)
  {
    super(1);
    this.k = paramCircularProgressIndicatorSpec;
    this.j = new FastOutSlowInInterpolator();
  }
  
  private void a(int paramInt)
  {
    this.c[0] = (this.m * 1520.0F - 20.0F);
    this.c[1] = (this.m * 1520.0F);
    int i1 = 0;
    while (i1 < 4)
    {
      float f1 = a(paramInt, e[i1], 667);
      arrayOfFloat = this.c;
      arrayOfFloat[1] += this.j.getInterpolation(f1) * 250.0F;
      f1 = a(paramInt, f[i1], 667);
      arrayOfFloat = this.c;
      arrayOfFloat[0] += this.j.getInterpolation(f1) * 250.0F;
      i1 += 1;
    }
    float[] arrayOfFloat = this.c;
    arrayOfFloat[0] += (this.c[1] - this.c[0]) * this.n;
    arrayOfFloat = this.c;
    arrayOfFloat[0] /= 360.0F;
    arrayOfFloat = this.c;
    arrayOfFloat[1] /= 360.0F;
  }
  
  private void b(float paramFloat)
  {
    this.n = paramFloat;
  }
  
  private void b(int paramInt)
  {
    int i1 = 0;
    while (i1 < 4)
    {
      float f1 = a(paramInt, g[i1], 333);
      if ((f1 >= 0.0F) && (f1 <= 1.0F))
      {
        i1 = (i1 + this.l) % this.k.c.length;
        int i2 = this.k.c.length;
        paramInt = MaterialColors.b(this.k.c[i1], this.b.getAlpha());
        i1 = MaterialColors.b(this.k.c[((i1 + 1) % i2)], this.b.getAlpha());
        f1 = this.j.getInterpolation(f1);
        this.d[0] = ArgbEvaluatorCompat.a().a(f1, Integer.valueOf(paramInt), Integer.valueOf(i1)).intValue();
        return;
      }
      i1 += 1;
    }
  }
  
  private void g()
  {
    if (this.h == null)
    {
      this.h = ObjectAnimator.ofFloat(this, o, new float[] { 0.0F, 1.0F });
      this.h.setDuration(5400L);
      this.h.setInterpolator(null);
      this.h.setRepeatCount(-1);
      this.h.addListener(new CircularIndeterminateAnimatorDelegate.1(this));
    }
    if (this.i == null)
    {
      this.i = ObjectAnimator.ofFloat(this, p, new float[] { 0.0F, 1.0F });
      this.i.setDuration(333L);
      this.i.setInterpolator(this.j);
      this.i.addListener(new CircularIndeterminateAnimatorDelegate.2(this));
    }
  }
  
  private float h()
  {
    return this.m;
  }
  
  private float i()
  {
    return this.n;
  }
  
  void a()
  {
    g();
    f();
    this.h.start();
  }
  
  @VisibleForTesting
  void a(float paramFloat)
  {
    this.m = paramFloat;
    int i1 = (int)(this.m * 5400.0F);
    a(i1);
    b(i1);
    this.b.invalidateSelf();
  }
  
  public void a(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    this.a = paramAnimationCallback;
  }
  
  void b()
  {
    ObjectAnimator localObjectAnimator = this.h;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  void c()
  {
    if (this.i.isRunning()) {
      return;
    }
    if (this.b.isVisible())
    {
      this.i.start();
      return;
    }
    b();
  }
  
  public void d()
  {
    f();
  }
  
  public void e()
  {
    this.a = null;
  }
  
  @VisibleForTesting
  void f()
  {
    this.l = 0;
    this.d[0] = MaterialColors.b(this.k.c[0], this.b.getAlpha());
    this.n = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate
 * JD-Core Version:    0.7.0.1
 */