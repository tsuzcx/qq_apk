package com.tencent.mobileqq.apollo.emotionview.api.impl;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;

class CmShowEmotionAdapter$7
  implements Runnable
{
  CmShowEmotionAdapter$7(CmShowEmotionAdapter paramCmShowEmotionAdapter, ImageView paramImageView, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, ApolloLinearLayout.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, -0.5F, 1, 0.5F, 1, -0.5F, 1, 0.5F);
    localTranslateAnimation.setDuration(400L);
    localTranslateAnimation.setRepeatCount(1);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new CmShowEmotionAdapter.7.1(this));
    this.a.setVisibility(0);
    this.a.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter.7
 * JD-Core Version:    0.7.0.1
 */