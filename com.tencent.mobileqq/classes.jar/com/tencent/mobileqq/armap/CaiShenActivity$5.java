package com.tencent.mobileqq.armap;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class CaiShenActivity$5
  implements Animation.AnimationListener
{
  CaiShenActivity$5(CaiShenActivity paramCaiShenActivity, ImageView paramImageView, Handler paramHandler, Animation paramAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.val$arrow.setVisibility(4);
    this.val$handler.postDelayed(new CaiShenActivity.5.1(this), 200L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.CaiShenActivity.5
 * JD-Core Version:    0.7.0.1
 */