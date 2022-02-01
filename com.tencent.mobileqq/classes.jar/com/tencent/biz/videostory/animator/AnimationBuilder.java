package com.tencent.biz.videostory.animator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class AnimationBuilder
{
  private final ViewAnimator a;
  private final View[] b;
  private final List<Animator> c = new ArrayList();
  private boolean d;
  private boolean e = false;
  private Interpolator f = null;
  
  public AnimationBuilder(ViewAnimator paramViewAnimator, View... paramVarArgs)
  {
    this.a = paramViewAnimator;
    this.b = paramVarArgs;
  }
  
  protected float a(float paramFloat)
  {
    return paramFloat * this.b[0].getContext().getResources().getDisplayMetrics().density;
  }
  
  public AnimationBuilder a(long paramLong)
  {
    this.a.a(paramLong);
    return this;
  }
  
  protected AnimationBuilder a(Animator paramAnimator)
  {
    this.c.add(paramAnimator);
    return this;
  }
  
  public AnimationBuilder a(AnimationListener.Start paramStart)
  {
    this.a.a(paramStart);
    return this;
  }
  
  public AnimationBuilder a(AnimationListener.Stop paramStop)
  {
    this.a.a(paramStop);
    return this;
  }
  
  public AnimationBuilder a(AnimationListener.Update paramUpdate, float... paramVarArgs)
  {
    View[] arrayOfView = this.b;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(a(paramVarArgs));
      if (paramUpdate != null) {
        localValueAnimator.addUpdateListener(new AnimationBuilder.1(this, paramUpdate, localView));
      }
      a(localValueAnimator);
      i += 1;
    }
    return this;
  }
  
  public AnimationBuilder a(String paramString, float... paramVarArgs)
  {
    View[] arrayOfView = this.b;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      this.c.add(ObjectAnimator.ofFloat(localView, paramString, a(paramVarArgs)));
      i += 1;
    }
    return this;
  }
  
  public AnimationBuilder a(View... paramVarArgs)
  {
    return this.a.b(paramVarArgs);
  }
  
  protected List<Animator> a()
  {
    return this.c;
  }
  
  protected float[] a(float... paramVarArgs)
  {
    if (!this.e) {
      return paramVarArgs;
    }
    float[] arrayOfFloat = new float[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfFloat[i] = a(paramVarArgs[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public Interpolator b()
  {
    return this.f;
  }
  
  public AnimationBuilder b(float... paramVarArgs)
  {
    return a("translationY", paramVarArgs);
  }
  
  public ViewAnimator b(float paramFloat)
  {
    return this.a.a(new DecelerateInterpolator(paramFloat));
  }
  
  public AnimationBuilder c(float... paramVarArgs)
  {
    return a("translationX", paramVarArgs);
  }
  
  public ViewAnimator c()
  {
    return this.a.a(new AccelerateInterpolator());
  }
  
  public AnimationBuilder d(float... paramVarArgs)
  {
    return a("alpha", paramVarArgs);
  }
  
  public ViewAnimator d()
  {
    this.a.b();
    return this.a;
  }
  
  public View e()
  {
    return this.b[0];
  }
  
  public AnimationBuilder e(float... paramVarArgs)
  {
    return a(new AnimationBuilder.2(this), paramVarArgs);
  }
  
  public AnimationBuilder f(float... paramVarArgs)
  {
    return a(new AnimationBuilder.3(this), paramVarArgs);
  }
  
  public boolean f()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.animator.AnimationBuilder
 * JD-Core Version:    0.7.0.1
 */