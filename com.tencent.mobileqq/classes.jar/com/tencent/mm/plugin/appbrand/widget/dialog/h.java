package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

final class h
{
  private View a;
  private int b;
  private ValueAnimator c;
  
  public h(View paramView)
  {
    this.a = paramView;
  }
  
  void a()
  {
    ValueAnimator localValueAnimator = this.c;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
  }
  
  void a(int paramInt, Runnable paramRunnable)
  {
    if (this.a == null) {
      return;
    }
    if ((b()) && (this.b == paramInt)) {
      return;
    }
    this.b = paramInt;
    if (((this.a.getBackground() instanceof ColorDrawable)) && (((ColorDrawable)this.a.getBackground()).getColor() == paramInt))
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      paramRunnable = this.c;
      if (paramRunnable != null) {
        paramRunnable.cancel();
      }
      return;
    }
    paramRunnable = new h.1(this, paramRunnable);
    ValueAnimator localValueAnimator = this.c;
    if ((localValueAnimator != null) && (localValueAnimator.isStarted()) && (this.c.isRunning()) && (this.b == paramInt))
    {
      this.c.addListener(paramRunnable);
      return;
    }
    localValueAnimator = this.c;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    if ((this.a.getBackground() instanceof ColorDrawable)) {
      paramInt = ((ColorDrawable)this.a.getBackground()).getColor();
    } else {
      paramInt = 0;
    }
    this.c = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.b) });
    this.c.addListener(paramRunnable);
    this.c.addUpdateListener(new h.2(this));
    this.c.start();
  }
  
  boolean b()
  {
    ValueAnimator localValueAnimator = this.c;
    return (localValueAnimator != null) && (localValueAnimator.isRunning());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.h
 * JD-Core Version:    0.7.0.1
 */