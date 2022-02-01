package com.tencent.biz.qqstory.view;

import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.Animation.AnimationListener;

class AnimationPoint$1
  implements Runnable
{
  AnimationPoint$1(AnimationPoint paramAnimationPoint) {}
  
  public void run()
  {
    if (this.this$0.n) {
      return;
    }
    if ((SystemClock.uptimeMillis() - this.this$0.d >= this.this$0.b) && (this.this$0.b >= 0L))
    {
      if (this.this$0.l != null) {
        this.this$0.l.onAnimationEnd(null);
      }
    }
    else {
      this.this$0.m.postDelayed(this, 30L);
    }
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.AnimationPoint.1
 * JD-Core Version:    0.7.0.1
 */