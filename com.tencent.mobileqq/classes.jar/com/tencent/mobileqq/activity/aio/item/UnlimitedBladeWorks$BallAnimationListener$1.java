package com.tencent.mobileqq.activity.aio.item;

import com.immersion.stickersampleapp.HapticManager;

class UnlimitedBladeWorks$BallAnimationListener$1
  implements CustomFrameAnimationDrawable.AnimationEndListener
{
  UnlimitedBladeWorks$BallAnimationListener$1(UnlimitedBladeWorks.BallAnimationListener paramBallAnimationListener) {}
  
  public void a()
  {
    UnlimitedBladeWorks.d(this.a.a).e = true;
    UnlimitedBladeWorks.d(this.a.a).d = false;
    if (UnlimitedBladeWorks.e(this.a.a) != null)
    {
      UnlimitedBladeWorks.e(this.a.a).a();
      if (UnlimitedBladeWorks.f(this.a.a))
      {
        HapticManager.b().d(UnlimitedBladeWorks.g(this.a.a));
        UnlimitedBladeWorks.a(this.a.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.BallAnimationListener.1
 * JD-Core Version:    0.7.0.1
 */