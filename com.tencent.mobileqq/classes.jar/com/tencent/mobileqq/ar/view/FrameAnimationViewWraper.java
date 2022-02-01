package com.tencent.mobileqq.ar.view;

import android.animation.Animator.AnimatorListener;
import android.util.SparseArray;

public class FrameAnimationViewWraper
{
  private int a = 1;
  private SparseArray<FrameAnimationDrawable> b = new SparseArray();
  private Animator.AnimatorListener c = new FrameAnimationViewWraper.1(this);
  private FrameAnimationViewWraper.OnEnterAnimationEndListener d;
  
  private void a(int paramInt)
  {
    if (this.b.get(paramInt) != null) {
      ((FrameAnimationDrawable)this.b.get(paramInt)).stop();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    FrameAnimationDrawable localFrameAnimationDrawable1 = (FrameAnimationDrawable)this.b.get(paramInt1);
    FrameAnimationDrawable localFrameAnimationDrawable2 = (FrameAnimationDrawable)this.b.get(paramInt2);
    localFrameAnimationDrawable1.a(false, null);
    localFrameAnimationDrawable2.a(true, this.c);
  }
  
  public void a()
  {
    int i = 1;
    while (i <= 3)
    {
      a(i);
      i += 1;
    }
  }
  
  public void a(int paramInt, FrameAnimationDrawable paramFrameAnimationDrawable)
  {
    this.b.put(paramInt, paramFrameAnimationDrawable);
  }
  
  public void a(int paramInt, FrameAnimationViewWraper.OnEnterAnimationEndListener paramOnEnterAnimationEndListener)
  {
    int i = this.a;
    if (i == paramInt) {
      return;
    }
    this.d = paramOnEnterAnimationEndListener;
    a(i, paramInt);
    this.a = paramInt;
  }
  
  public void b()
  {
    a();
    this.b.clear();
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.FrameAnimationViewWraper
 * JD-Core Version:    0.7.0.1
 */