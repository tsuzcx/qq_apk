package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class LoadingAvatarProgressView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  LoadingAvatarProgressView$1(LoadingAvatarProgressView paramLoadingAvatarProgressView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    LoadingAvatarProgressView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue() * LoadingAvatarProgressView.a(this.a));
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.LoadingAvatarProgressView.1
 * JD-Core Version:    0.7.0.1
 */