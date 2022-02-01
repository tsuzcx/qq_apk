package com.tencent.biz.qqstory.view.segment;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqstory.support.logging.SLog;

class SegmentView$2
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    SLog.b(this.c.b(), "deletedItemViewWithAnimation end");
    this.a.clearAnimation();
    this.c.u();
    this.a.getLayoutParams().height = this.b;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    SLog.b(this.c.b(), "deletedItemViewWithAnimation start");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.segment.SegmentView.2
 * JD-Core Version:    0.7.0.1
 */