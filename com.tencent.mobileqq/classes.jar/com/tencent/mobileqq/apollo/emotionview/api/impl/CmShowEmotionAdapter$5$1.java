package com.tencent.mobileqq.apollo.emotionview.api.impl;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class CmShowEmotionAdapter$5$1
  implements Animation.AnimationListener
{
  CmShowEmotionAdapter$5$1(CmShowEmotionAdapter.5 param5) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.setVisibility(8);
    this.a.a.postDelayed(new CmShowEmotionAdapter.5.1.1(this), 300L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter.5.1
 * JD-Core Version:    0.7.0.1
 */