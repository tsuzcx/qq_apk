package com.tencent.biz.subscribe.animation;

import android.os.Handler;

class PopViewAnimationDrawableHelper$1
  implements PopViewAnimationDrawableHelper.OnInnerFrameAnimationListener
{
  PopViewAnimationDrawableHelper$1(PopViewAnimationDrawableHelper paramPopViewAnimationDrawableHelper) {}
  
  public void a()
  {
    if (PopViewAnimationDrawableHelper.a(this.a) != null) {
      PopViewAnimationDrawableHelper.a(this.a).b();
    }
    if ((PopViewAnimationDrawableHelper.a(this.a) != null) && (PopViewAnimationDrawableHelper.a(this.a) != null)) {
      PopViewAnimationDrawableHelper.a(this.a).removeCallbacks(PopViewAnimationDrawableHelper.a(this.a));
    }
  }
  
  public void b()
  {
    PopViewAnimationDrawableHelper.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.animation.PopViewAnimationDrawableHelper.1
 * JD-Core Version:    0.7.0.1
 */