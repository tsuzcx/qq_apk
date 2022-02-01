package com.tencent.biz.qqcircle.publish.preview.itemtouchhelper;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ItemTouchHelper$RecoverAnimation$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ItemTouchHelper$RecoverAnimation$1(ItemTouchHelper.RecoverAnimation paramRecoverAnimation, ItemTouchHelper paramItemTouchHelper) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.a(paramValueAnimator.getAnimatedFraction());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.itemtouchhelper.ItemTouchHelper.RecoverAnimation.1
 * JD-Core Version:    0.7.0.1
 */