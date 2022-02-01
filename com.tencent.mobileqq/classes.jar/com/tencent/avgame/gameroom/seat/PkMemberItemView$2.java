package com.tencent.avgame.gameroom.seat;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;

class PkMemberItemView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  PkMemberItemView$2(PkMemberItemView paramPkMemberItemView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    paramValueAnimator = new ColorMatrixColorFilter(localColorMatrix);
    this.a.b.setColorFilter(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.PkMemberItemView.2
 * JD-Core Version:    0.7.0.1
 */