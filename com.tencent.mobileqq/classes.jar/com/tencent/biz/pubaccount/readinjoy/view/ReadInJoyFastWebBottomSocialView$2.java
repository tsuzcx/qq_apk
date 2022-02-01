package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;

class ReadInJoyFastWebBottomSocialView$2
  implements Animation.AnimationListener
{
  ReadInJoyFastWebBottomSocialView$2(ReadInJoyFastWebBottomSocialView paramReadInJoyFastWebBottomSocialView) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    ImageView localImageView = ReadInJoyFastWebBottomSocialView.a(this.a);
    if (ReadInJoyFastWebBottomSocialView.a(this.a).a) {}
    for (int i = 2130843069;; i = 2130843071)
    {
      localImageView.setImageResource(i);
      paramAnimation.setInterpolator(new AnticipateInterpolator());
      return;
    }
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialView.2
 * JD-Core Version:    0.7.0.1
 */