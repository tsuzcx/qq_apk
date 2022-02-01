package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Property;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class DrawableWithAnimatedVisibilityChange
  extends Drawable
  implements Animatable2Compat
{
  private static final Property<DrawableWithAnimatedVisibilityChange, Float> o = new DrawableWithAnimatedVisibilityChange.3(Float.class, "growFraction");
  final Context a;
  final BaseProgressIndicatorSpec b;
  AnimatorDurationScaleProvider c;
  final Paint d = new Paint();
  private ValueAnimator e;
  private ValueAnimator f;
  private boolean g;
  private boolean h;
  private float i;
  private List<Animatable2Compat.AnimationCallback> j;
  private Animatable2Compat.AnimationCallback k;
  private boolean l;
  private float m;
  private int n;
  
  DrawableWithAnimatedVisibilityChange(@NonNull Context paramContext, @NonNull BaseProgressIndicatorSpec paramBaseProgressIndicatorSpec)
  {
    this.a = paramContext;
    this.b = paramBaseProgressIndicatorSpec;
    this.c = new AnimatorDurationScaleProvider();
    setAlpha(255);
  }
  
  private void a()
  {
    if (this.e == null)
    {
      this.e = ObjectAnimator.ofFloat(this, o, new float[] { 0.0F, 1.0F });
      this.e.setDuration(500L);
      this.e.setInterpolator(AnimationUtils.b);
      a(this.e);
    }
    if (this.f == null)
    {
      this.f = ObjectAnimator.ofFloat(this, o, new float[] { 1.0F, 0.0F });
      this.f.setDuration(500L);
      this.f.setInterpolator(AnimationUtils.b);
      b(this.f);
    }
  }
  
  private void a(@NonNull ValueAnimator paramValueAnimator)
  {
    ValueAnimator localValueAnimator = this.e;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
    }
    this.e = paramValueAnimator;
    paramValueAnimator.addListener(new DrawableWithAnimatedVisibilityChange.1(this));
  }
  
  private void a(@NonNull ValueAnimator... paramVarArgs)
  {
    boolean bool = this.l;
    this.l = true;
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      paramVarArgs[i1].end();
      i1 += 1;
    }
    this.l = bool;
  }
  
  private void b(@NonNull ValueAnimator paramValueAnimator)
  {
    ValueAnimator localValueAnimator = this.f;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
    }
    this.f = paramValueAnimator;
    paramValueAnimator.addListener(new DrawableWithAnimatedVisibilityChange.2(this));
  }
  
  private void f()
  {
    Object localObject = this.k;
    if (localObject != null) {
      ((Animatable2Compat.AnimationCallback)localObject).onAnimationStart(this);
    }
    localObject = this.j;
    if ((localObject != null) && (!this.l))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Animatable2Compat.AnimationCallback)((Iterator)localObject).next()).onAnimationStart(this);
      }
    }
  }
  
  private void g()
  {
    Object localObject = this.k;
    if (localObject != null) {
      ((Animatable2Compat.AnimationCallback)localObject).onAnimationEnd(this);
    }
    localObject = this.j;
    if ((localObject != null) && (!this.l))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Animatable2Compat.AnimationCallback)((Iterator)localObject).next()).onAnimationEnd(this);
      }
    }
  }
  
  boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a();
    if ((!isVisible()) && (!paramBoolean1)) {
      return false;
    }
    ValueAnimator localValueAnimator;
    if (paramBoolean1) {
      localValueAnimator = this.e;
    } else {
      localValueAnimator = this.f;
    }
    if (!paramBoolean3)
    {
      if (localValueAnimator.isRunning()) {
        localValueAnimator.end();
      } else {
        a(new ValueAnimator[] { localValueAnimator });
      }
      return super.setVisible(paramBoolean1, false);
    }
    if ((paramBoolean3) && (localValueAnimator.isRunning())) {
      return false;
    }
    if ((paramBoolean1) && (!super.setVisible(paramBoolean1, false))) {
      paramBoolean3 = false;
    } else {
      paramBoolean3 = true;
    }
    if (paramBoolean1) {
      paramBoolean1 = this.b.a();
    } else {
      paramBoolean1 = this.b.b();
    }
    if (!paramBoolean1)
    {
      a(new ValueAnimator[] { localValueAnimator });
      return paramBoolean3;
    }
    if ((!paramBoolean2) && (Build.VERSION.SDK_INT >= 19) && (localValueAnimator.isPaused()))
    {
      localValueAnimator.resume();
      return paramBoolean3;
    }
    localValueAnimator.start();
    return paramBoolean3;
  }
  
  void b(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.m != paramFloat)
    {
      this.m = paramFloat;
      invalidateSelf();
    }
  }
  
  public boolean b()
  {
    return b(false, false, false);
  }
  
  public boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    float f1 = this.c.a(this.a.getContentResolver());
    if ((paramBoolean3) && (f1 > 0.0F)) {
      paramBoolean3 = true;
    } else {
      paramBoolean3 = false;
    }
    return a(paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public boolean c()
  {
    ValueAnimator localValueAnimator = this.f;
    return ((localValueAnimator != null) && (localValueAnimator.isRunning())) || (this.h);
  }
  
  public void clearAnimationCallbacks()
  {
    this.j.clear();
    this.j = null;
  }
  
  public boolean d()
  {
    ValueAnimator localValueAnimator = this.e;
    return ((localValueAnimator != null) && (localValueAnimator.isRunning())) || (this.g);
  }
  
  float e()
  {
    if ((!this.b.a()) && (!this.b.b())) {
      return 1.0F;
    }
    if ((!this.h) && (!this.g)) {
      return this.m;
    }
    return this.i;
  }
  
  public int getAlpha()
  {
    return this.n;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return (d()) || (c());
  }
  
  public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    if (this.j == null) {
      this.j = new ArrayList();
    }
    if (!this.j.contains(paramAnimationCallback)) {
      this.j.add(paramAnimationCallback);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.n = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.d.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return b(paramBoolean1, paramBoolean2, true);
  }
  
  public void start()
  {
    a(true, true, false);
  }
  
  public void stop()
  {
    a(false, true, false);
  }
  
  public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    List localList = this.j;
    if ((localList != null) && (localList.contains(paramAnimationCallback)))
    {
      this.j.remove(paramAnimationCallback);
      if (this.j.isEmpty()) {
        this.j = null;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
 * JD-Core Version:    0.7.0.1
 */