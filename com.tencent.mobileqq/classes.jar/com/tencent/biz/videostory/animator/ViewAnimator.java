package com.tencent.biz.videostory.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ViewAnimator
{
  private List<AnimationBuilder> a = new ArrayList();
  private long b = 3000L;
  private long c = 0L;
  private Interpolator d = null;
  private int e = 0;
  private int f = 1;
  private AnimatorSet g;
  private View h = null;
  private AnimationListener.Start i;
  private AnimationListener.Stop j;
  private AnimationListener.Repeat k;
  private AnimationListener.Cancel l;
  private ViewAnimator m = null;
  private ViewAnimator n = null;
  private boolean o = false;
  
  public static AnimationBuilder a(View... paramVarArgs)
  {
    return new ViewAnimator().b(paramVarArgs);
  }
  
  protected AnimatorSet a()
  {
    this.o = false;
    Object localObject1 = new ArrayList();
    Object localObject2 = this.a.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (AnimationBuilder)((Iterator)localObject2).next();
      List localList = ((AnimationBuilder)localObject3).a();
      if (((AnimationBuilder)localObject3).b() != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          ((Animator)localIterator.next()).setInterpolator(((AnimationBuilder)localObject3).b());
        }
      }
      ((List)localObject1).addAll(localList);
    }
    localObject2 = this.a.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (AnimationBuilder)((Iterator)localObject2).next();
      if (((AnimationBuilder)localObject3).f()) {
        this.h = ((AnimationBuilder)localObject3).e();
      }
    }
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Animator)((Iterator)localObject2).next();
      if ((localObject3 instanceof ValueAnimator))
      {
        localObject3 = (ValueAnimator)localObject3;
        ((ValueAnimator)localObject3).setRepeatCount(this.e);
        ((ValueAnimator)localObject3).setRepeatMode(this.f);
        if (!this.o)
        {
          ((ValueAnimator)localObject3).addListener(new ViewAnimator.1(this));
          this.o = true;
        }
      }
    }
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether((Collection)localObject1);
    ((AnimatorSet)localObject2).setDuration(this.b);
    ((AnimatorSet)localObject2).setStartDelay(this.c);
    localObject1 = this.d;
    if (localObject1 != null) {
      ((AnimatorSet)localObject2).setInterpolator((TimeInterpolator)localObject1);
    }
    ((AnimatorSet)localObject2).addListener(new ViewAnimator.2(this));
    return localObject2;
  }
  
  public ViewAnimator a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public ViewAnimator a(Interpolator paramInterpolator)
  {
    this.d = paramInterpolator;
    return this;
  }
  
  public ViewAnimator a(AnimationListener.Start paramStart)
  {
    this.i = paramStart;
    return this;
  }
  
  public ViewAnimator a(AnimationListener.Stop paramStop)
  {
    this.j = paramStop;
    return this;
  }
  
  public AnimationBuilder b(View... paramVarArgs)
  {
    paramVarArgs = new AnimationBuilder(this, paramVarArgs);
    this.a.add(paramVarArgs);
    return paramVarArgs;
  }
  
  public ViewAnimator b()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      ((ViewAnimator)localObject).b();
      return this;
    }
    this.g = a();
    localObject = this.h;
    if (localObject != null)
    {
      ((View)localObject).getViewTreeObserver().addOnPreDrawListener(new ViewAnimator.3(this));
      return this;
    }
    this.g.start();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.animator.ViewAnimator
 * JD-Core Version:    0.7.0.1
 */