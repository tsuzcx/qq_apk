package com.tencent.mobileqq.apollo.emotionview.api.impl;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

class CmShowEmotionAdapter$7$1$1
  implements Runnable
{
  CmShowEmotionAdapter$7$1$1(CmShowEmotionAdapter.7.1 param1) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, -0.5F, 1, 0.5F, 1, -0.5F, 1, 0.5F);
    localTranslateAnimation.setDuration(400L);
    localTranslateAnimation.setRepeatCount(1);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new CmShowEmotionAdapter.7.1.1.1(this));
    this.a.a.a.setVisibility(0);
    this.a.a.a.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter.7.1.1
 * JD-Core Version:    0.7.0.1
 */