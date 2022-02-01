package com.tencent.biz.qqstory.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class NeoVideoRecordButton$1
  implements ValueAnimator.AnimatorUpdateListener
{
  NeoVideoRecordButton$1(NeoVideoRecordButton paramNeoVideoRecordButton) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.b.a(((Integer)paramValueAnimator.getAnimatedValue("border")).intValue(), 0.0F);
    this.a.b.b(((Integer)paramValueAnimator.getAnimatedValue("ring")).intValue(), 0.0F);
    this.a.c.a(((Integer)paramValueAnimator.getAnimatedValue("center")).intValue(), 0.0F);
    this.a.c.h = ((Integer)paramValueAnimator.getAnimatedValue("color")).intValue();
    NeoVideoRecordButton.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.NeoVideoRecordButton.1
 * JD-Core Version:    0.7.0.1
 */