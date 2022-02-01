package com.tencent.mobileqq.activity.selectmember;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

class CreateFaceToFaceDiscussionActivity$7
  implements Animation.AnimationListener
{
  CreateFaceToFaceDiscussionActivity$7(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.mLayoutAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0.0F);
    this.a.contentLayout.setAnimation(this.a.mLayoutAnimation);
    paramAnimation = (FrameLayout.LayoutParams)this.a.contentLayout.getLayoutParams();
    paramAnimation.setMargins(0, 0, 0, this.a.bottomLayout.getHeight());
    this.a.contentLayout.setLayoutParams(paramAnimation);
    this.a.mTextviewTip.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.7
 * JD-Core Version:    0.7.0.1
 */