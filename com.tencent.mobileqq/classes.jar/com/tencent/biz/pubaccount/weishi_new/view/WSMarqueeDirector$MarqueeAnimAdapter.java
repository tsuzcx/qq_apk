package com.tencent.biz.pubaccount.weishi_new.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.HorizontalScrollView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSMarqueeDirector$MarqueeAnimAdapter
  extends AnimatorListenerAdapter
  implements ValueAnimator.AnimatorUpdateListener
{
  private WSMarqueeDirector$MarqueeAnimAdapter(WSMarqueeDirector paramWSMarqueeDirector) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    WSMarqueeDirector.a(this.a).scrollTo(0, 0);
    WSLog.a("WSMarqueeDirector", "onAnimationEnd: ");
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    WSMarqueeDirector.a(this.a).scrollTo(0, 0);
    WSLog.a("WSMarqueeDirector", "onAnimationStart: ");
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i >= 0)
    {
      if (i > WSMarqueeDirector.a(this.a)) {
        return;
      }
      WSMarqueeDirector.a(this.a).scrollTo(i, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.WSMarqueeDirector.MarqueeAnimAdapter
 * JD-Core Version:    0.7.0.1
 */