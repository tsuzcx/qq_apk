package com.tencent.biz.pubaccount.readinjoy;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.widgets.TabLayout;

class ReadInJoyChannelViewPagerController$10$1
  implements Animator.AnimatorListener
{
  ReadInJoyChannelViewPagerController$10$1(ReadInJoyChannelViewPagerController.10 param10) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyChannelViewPagerController.b(this.a.this$0, false);
    ReadInJoyChannelViewPagerController.a(this.a.this$0, ReadInJoyChannelViewPagerController.a, 0.0F, 0);
    ReadInJoyChannelViewPagerController.a(this.a.this$0).postDelayed(new ReadInJoyChannelViewPagerController.10.1.1(this), 0L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.10.1
 * JD-Core Version:    0.7.0.1
 */