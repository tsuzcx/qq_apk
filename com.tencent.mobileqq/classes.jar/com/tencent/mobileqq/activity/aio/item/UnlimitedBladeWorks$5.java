package com.tencent.mobileqq.activity.aio.item;

import com.immersion.stickersampleapp.HapticManager;

class UnlimitedBladeWorks$5
  implements CustomFrameAnimationDrawable.AnimationEndListener
{
  UnlimitedBladeWorks$5(UnlimitedBladeWorks paramUnlimitedBladeWorks) {}
  
  public void a()
  {
    UnlimitedBladeWorks.a(this.a).b = true;
    UnlimitedBladeWorks.a(this.a).a = false;
    if (UnlimitedBladeWorks.a(this.a) != null)
    {
      UnlimitedBladeWorks.a(this.a).a();
      if (UnlimitedBladeWorks.b(this.a))
      {
        HapticManager.a().c(UnlimitedBladeWorks.a(this.a));
        UnlimitedBladeWorks.a(this.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.5
 * JD-Core Version:    0.7.0.1
 */