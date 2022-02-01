package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R.animator;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

final class LinearIndeterminateDisjointAnimatorDelegate
  extends IndeterminateAnimatorDelegate<ObjectAnimator>
{
  private static final int[] e = { 533, 567, 850, 750 };
  private static final int[] f = { 1267, 1000, 333, 0 };
  private static final Property<LinearIndeterminateDisjointAnimatorDelegate, Float> n = new LinearIndeterminateDisjointAnimatorDelegate.2(Float.class, "animationFraction");
  Animatable2Compat.AnimationCallback a = null;
  private ObjectAnimator g;
  private final Interpolator[] h;
  private final BaseProgressIndicatorSpec i;
  private int j = 0;
  private boolean k;
  private float l;
  private boolean m;
  
  public LinearIndeterminateDisjointAnimatorDelegate(@NonNull Context paramContext, @NonNull LinearProgressIndicatorSpec paramLinearProgressIndicatorSpec)
  {
    super(2);
    this.i = paramLinearProgressIndicatorSpec;
    this.h = new Interpolator[] { AnimationUtilsCompat.loadInterpolator(paramContext, R.animator.c), AnimationUtilsCompat.loadInterpolator(paramContext, R.animator.d), AnimationUtilsCompat.loadInterpolator(paramContext, R.animator.e), AnimationUtilsCompat.loadInterpolator(paramContext, R.animator.f) };
  }
  
  private void a(int paramInt)
  {
    int i1 = 0;
    while (i1 < 4)
    {
      float f1 = a(paramInt, f[i1], e[i1]);
      f1 = this.h[i1].getInterpolation(f1);
      this.c[i1] = Math.max(0.0F, Math.min(1.0F, f1));
      i1 += 1;
    }
  }
  
  private void g()
  {
    if (this.g == null)
    {
      this.g = ObjectAnimator.ofFloat(this, n, new float[] { 0.0F, 1.0F });
      this.g.setDuration(1800L);
      this.g.setInterpolator(null);
      this.g.setRepeatCount(-1);
      this.g.addListener(new LinearIndeterminateDisjointAnimatorDelegate.1(this));
    }
  }
  
  private void h()
  {
    if (this.k)
    {
      Arrays.fill(this.d, MaterialColors.b(this.i.c[this.j], this.b.getAlpha()));
      this.k = false;
    }
  }
  
  private float i()
  {
    return this.l;
  }
  
  public void a()
  {
    g();
    f();
    this.g.start();
  }
  
  @VisibleForTesting
  void a(float paramFloat)
  {
    this.l = paramFloat;
    a((int)(this.l * 1800.0F));
    h();
    this.b.invalidateSelf();
  }
  
  public void a(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    this.a = paramAnimationCallback;
  }
  
  public void b()
  {
    ObjectAnimator localObjectAnimator = this.g;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  public void c()
  {
    if (this.b.isVisible())
    {
      this.m = true;
      this.g.setRepeatCount(0);
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
    this.j = 0;
    int i1 = MaterialColors.b(this.i.c[0], this.b.getAlpha());
    this.d[0] = i1;
    this.d[1] = i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate
 * JD-Core Version:    0.7.0.1
 */