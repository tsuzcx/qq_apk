package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.image.URLImageView;

class ReadInJoyAdExpandCardPic$1
  implements Animator.AnimatorListener
{
  ReadInJoyAdExpandCardPic$1(ReadInJoyAdExpandCardPic paramReadInJoyAdExpandCardPic, View paramView1, View paramView2) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    if ((paramAnimator != null) && (this.b != null))
    {
      paramAnimator.setVisibility(8);
      this.b.setVisibility(0);
    }
    if (ReadInJoyAdExpandCardPic.a(this.c) != null) {
      ReadInJoyAdExpandCardPic.a(this.c).setClickable(true);
    }
    ReadInJoyAdExpandCardPic.a(this.c, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (ReadInJoyAdExpandCardPic.a(this.c) != null) {
      ReadInJoyAdExpandCardPic.a(this.c).setClickable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdExpandCardPic.1
 * JD-Core Version:    0.7.0.1
 */