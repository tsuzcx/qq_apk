package com.tencent.mobileqq.apollo.view.pannel;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import anpl;
import anpm;

public class ApolloPanelListAdapter$1$1$1
  implements Runnable
{
  public ApolloPanelListAdapter$1$1$1(anpl paramanpl) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, -0.5F, 1, 0.5F, 1, -0.5F, 1, 0.5F);
    localTranslateAnimation.setDuration(400L);
    localTranslateAnimation.setRepeatCount(1);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new anpm(this));
    this.a.a.a.setVisibility(0);
    this.a.a.a.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanelListAdapter.1.1.1
 * JD-Core Version:    0.7.0.1
 */