package com.tencent.mobileqq.activity.aio.item;

import com.immersion.stickersampleapp.HapticManager;

class UnlimitedBladeWorks$5
  implements CustomFrameAnimationDrawable.AnimationEndListener
{
  UnlimitedBladeWorks$5(UnlimitedBladeWorks paramUnlimitedBladeWorks) {}
  
  public void a()
  {
    UnlimitedBladeWorks.d(this.a).e = true;
    UnlimitedBladeWorks.d(this.a).d = false;
    if (UnlimitedBladeWorks.e(this.a) != null)
    {
      UnlimitedBladeWorks.e(this.a).a();
      if (UnlimitedBladeWorks.f(this.a))
      {
        HapticManager.b().d(UnlimitedBladeWorks.g(this.a));
        UnlimitedBladeWorks.a(this.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.5
 * JD-Core Version:    0.7.0.1
 */