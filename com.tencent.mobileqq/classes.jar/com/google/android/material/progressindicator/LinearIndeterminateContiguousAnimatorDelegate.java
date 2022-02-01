package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

final class LinearIndeterminateContiguousAnimatorDelegate
  extends IndeterminateAnimatorDelegate<ObjectAnimator>
{
  private static final Property<LinearIndeterminateContiguousAnimatorDelegate, Float> j = new LinearIndeterminateContiguousAnimatorDelegate.2(Float.class, "animationFraction");
  private ObjectAnimator a;
  private FastOutSlowInInterpolator e;
  private final BaseProgressIndicatorSpec f;
  private int g = 1;
  private boolean h;
  private float i;
  
  public LinearIndeterminateContiguousAnimatorDelegate(@NonNull LinearProgressIndicatorSpec paramLinearProgressIndicatorSpec)
  {
    super(3);
    this.f = paramLinearProgressIndicatorSpec;
    this.e = new FastOutSlowInInterpolator();
  }
  
  private void a(int paramInt)
  {
    this.c[0] = 0.0F;
    float f1 = a(paramInt, 0, 667);
    float[] arrayOfFloat1 = this.c;
    float[] arrayOfFloat2 = this.c;
    float f2 = this.e.getInterpolation(f1);
    arrayOfFloat2[2] = f2;
    arrayOfFloat1[1] = f2;
    arrayOfFloat1 = this.c;
    arrayOfFloat2 = this.c;
    f1 = this.e.getInterpolation(f1 + 0.4992504F);
    arrayOfFloat2[4] = f1;
    arrayOfFloat1[3] = f1;
    this.c[5] = 1.0F;
  }
  
  private void g()
  {
    if (this.a == null)
    {
      this.a = ObjectAnimator.ofFloat(this, j, new float[] { 0.0F, 1.0F });
      this.a.setDuration(333L);
      this.a.setInterpolator(null);
      this.a.setRepeatCount(-1);
      this.a.addListener(new LinearIndeterminateContiguousAnimatorDelegate.1(this));
    }
  }
  
  private void h()
  {
    if ((this.h) && (this.c[3] < 1.0F))
    {
      this.d[2] = this.d[1];
      this.d[1] = this.d[0];
      this.d[0] = MaterialColors.b(this.f.c[this.g], this.b.getAlpha());
      this.h = false;
    }
  }
  
  private float i()
  {
    return this.i;
  }
  
  public void a()
  {
    g();
    f();
    this.a.start();
  }
  
  @VisibleForTesting
  void a(float paramFloat)
  {
    this.i = paramFloat;
    a((int)(this.i * 333.0F));
    h();
    this.b.invalidateSelf();
  }
  
  public void a(@Nullable Animatable2Compat.AnimationCallback paramAnimationCallback) {}
  
  public void b()
  {
    ObjectAnimator localObjectAnimator = this.a;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  public void c() {}
  
  public void d()
  {
    f();
  }
  
  public void e() {}
  
  @VisibleForTesting
  void f()
  {
    this.h = true;
    this.g = 1;
    Arrays.fill(this.d, MaterialColors.b(this.f.c[0], this.b.getAlpha()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate
 * JD-Core Version:    0.7.0.1
 */