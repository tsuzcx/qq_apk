package com.tencent.biz.subscribe.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;

public class PopViewAnimationDrawableHelper
{
  private Handler a;
  private Runnable b;
  private PopViewAnimationDrawableHelper.OnFrameAnimationListener c;
  private PopViewAnimationDrawableHelper.OnInnerFrameAnimationListener d;
  private int e;
  private int f;
  private AnimationDrawable g;
  private int h;
  
  public PopViewAnimationDrawableHelper(AnimationDrawable paramAnimationDrawable)
  {
    this.g = paramAnimationDrawable;
    this.h = paramAnimationDrawable.getNumberOfFrames();
    this.a = new PopViewAnimationDrawableHelper.InnerHandler();
    this.d = new PopViewAnimationDrawableHelper.1(this);
    this.b = new PopViewAnimationDrawableHelper.LoopingRunnable(this);
  }
  
  private void c()
  {
    Runnable localRunnable = this.b;
    if (localRunnable != null)
    {
      Handler localHandler = this.a;
      if (localHandler != null)
      {
        int i = this.f;
        if (i > 0)
        {
          localHandler.postDelayed(localRunnable, i);
          return;
        }
        if (i == 0) {
          i = d();
        } else {
          i = this.e;
        }
        localHandler.postDelayed(localRunnable, i);
      }
    }
  }
  
  private int d()
  {
    int i = 0;
    while (i < this.h)
    {
      if (this.e < this.g.getDuration(i)) {
        this.e = this.g.getDuration(i);
      }
      i += 1;
    }
    int j = this.e;
    i = j;
    if (j > 1000) {
      i = 1000;
    }
    return i;
  }
  
  public void a()
  {
    Object localObject = this.g;
    if (localObject == null) {
      return;
    }
    ((AnimationDrawable)localObject).start();
    c();
    localObject = this.c;
    if (localObject != null) {
      ((PopViewAnimationDrawableHelper.OnFrameAnimationListener)localObject).a();
    }
  }
  
  public void a(PopViewAnimationDrawableHelper.OnFrameAnimationListener paramOnFrameAnimationListener)
  {
    this.c = paramOnFrameAnimationListener;
  }
  
  public void b()
  {
    Handler localHandler = this.a;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper
 * JD-Core Version:    0.7.0.1
 */