package com.tencent.ad.tangram.views.feedback;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AdFeedbackDialogFragment$1
  implements Animation.AnimationListener
{
  AdFeedbackDialogFragment$1(AdFeedbackDialogFragment paramAdFeedbackDialogFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AdFeedbackDialogFragment.access$100(this.this$0).post(new AdFeedbackDialogFragment.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.1
 * JD-Core Version:    0.7.0.1
 */