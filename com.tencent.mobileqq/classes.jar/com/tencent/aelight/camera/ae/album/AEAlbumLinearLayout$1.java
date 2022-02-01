package com.tencent.aelight.camera.ae.album;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class AEAlbumLinearLayout$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AEAlbumLinearLayout$1(AEAlbumLinearLayout paramAEAlbumLinearLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((paramValueAnimator.getAnimatedValue() instanceof Integer))
    {
      if (AEAlbumLinearLayout.a(this.a) != null) {
        AEAlbumLinearLayout.a(this.a).a(((Integer)paramValueAnimator.getAnimatedValue()).intValue() / (AEAlbumLinearLayout.b(this.a) * 1.0F));
      }
      this.a.scrollTo(0, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.AEAlbumLinearLayout.1
 * JD-Core Version:    0.7.0.1
 */