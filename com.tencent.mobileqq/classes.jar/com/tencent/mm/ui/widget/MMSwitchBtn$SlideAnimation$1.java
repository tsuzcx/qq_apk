package com.tencent.mm.ui.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class MMSwitchBtn$SlideAnimation$1
  implements Animation.AnimationListener
{
  MMSwitchBtn$SlideAnimation$1(MMSwitchBtn.SlideAnimation paramSlideAnimation, MMSwitchBtn paramMMSwitchBtn) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool3 = MMSwitchBtn.a(this.b.d);
    int i = this.b.a;
    boolean bool2 = true;
    boolean bool1;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool3 != bool1)
    {
      paramAnimation = this.b.d;
      if (this.b.a == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      MMSwitchBtn.a(paramAnimation, bool1);
      this.b.d.post(new MMSwitchBtn.SlideAnimation.1.1(this));
    }
    MMSwitchBtn.b(this.b.d, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSwitchBtn.SlideAnimation.1
 * JD-Core Version:    0.7.0.1
 */