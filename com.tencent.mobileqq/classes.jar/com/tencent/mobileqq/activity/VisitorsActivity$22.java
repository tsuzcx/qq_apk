package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class VisitorsActivity$22
  extends AnimateUtils.AnimationAdapter
{
  VisitorsActivity$22(VisitorsActivity paramVisitorsActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.M > 0)
    {
      this.a.ar.postDelayed(this.a.N, 200L);
      return;
    }
    this.a.L.setVisibility(4);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = this.a;
    paramAnimation.M -= 1;
    this.a.L.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.22
 * JD-Core Version:    0.7.0.1
 */