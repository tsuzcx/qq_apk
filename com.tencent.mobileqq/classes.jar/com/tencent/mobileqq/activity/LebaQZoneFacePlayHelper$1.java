package com.tencent.mobileqq.activity;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class LebaQZoneFacePlayHelper$1
  implements Animation.AnimationListener
{
  LebaQZoneFacePlayHelper$1(LebaQZoneFacePlayHelper paramLebaQZoneFacePlayHelper, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.a) && (LebaQZoneFacePlayHelper.a(this.b) != null) && (LebaQZoneFacePlayHelper.a(this.b).size() >= 2)) {
      LebaQZoneFacePlayHelper.b(this.b).sendEmptyMessageDelayed(1688002, 1400L);
    }
    if (LebaQZoneFacePlayHelper.c(this.b) != null)
    {
      LebaQZoneFacePlayHelper.c(this.b).c();
      LebaQZoneFacePlayHelper.a(this.b, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper.1
 * JD-Core Version:    0.7.0.1
 */