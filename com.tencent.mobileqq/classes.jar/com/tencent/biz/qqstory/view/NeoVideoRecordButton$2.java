package com.tencent.biz.qqstory.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class NeoVideoRecordButton$2
  implements ValueAnimator.AnimatorUpdateListener
{
  NeoVideoRecordButton$2(NeoVideoRecordButton paramNeoVideoRecordButton) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.c.a(((Integer)paramValueAnimator.getAnimatedValue("radius")).intValue(), 0.0F);
    this.a.c.e = ((Integer)paramValueAnimator.getAnimatedValue("color")).intValue();
    NeoVideoRecordButton.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.NeoVideoRecordButton.2
 * JD-Core Version:    0.7.0.1
 */