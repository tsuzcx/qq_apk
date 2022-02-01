package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class MiniMsgTabFragment$2$1
  implements Animation.AnimationListener
{
  MiniMsgTabFragment$2$1(MiniMsgTabFragment.2 param2, Activity paramActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.b.a.b.getCount() == 1) && (!MiniMsgTabFragment.j(this.b.a)))
    {
      paramAnimation = MiniMsgTabFragment.k(this.b.a);
      paramAnimation.putExtra("miniAppID", MiniMsgTabFragment.d(this.b.a));
      paramAnimation.putExtra("clickID", -1);
      this.a.setResult(-1, paramAnimation);
      this.a.finish();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment.2.1
 * JD-Core Version:    0.7.0.1
 */