package com.tencent.mobileqq.apollo.emotionview.api.impl;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class CmShowEmotionAdapter$7$1
  implements Animation.AnimationListener
{
  CmShowEmotionAdapter$7$1(CmShowEmotionAdapter.7 param7) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.setVisibility(8);
    this.a.a.postDelayed(new CmShowEmotionAdapter.7.1.1(this), 300L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter.7.1
 * JD-Core Version:    0.7.0.1
 */