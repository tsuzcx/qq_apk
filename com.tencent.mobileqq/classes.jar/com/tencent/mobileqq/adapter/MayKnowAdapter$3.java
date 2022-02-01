package com.tencent.mobileqq.adapter;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class MayKnowAdapter$3
  implements Animation.AnimationListener
{
  MayKnowAdapter$3(MayKnowAdapter paramMayKnowAdapter, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    if ((paramAnimation != null) && ((paramAnimation.getTag() instanceof MayKnowAdapter.MKRViewHolder))) {
      ((MayKnowAdapter.MKRViewHolder)this.a.getTag()).j = true;
    }
    MayKnowAdapter.a(this.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.MayKnowAdapter.3
 * JD-Core Version:    0.7.0.1
 */