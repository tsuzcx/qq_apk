package com.tencent.biz.qqstory.msgTabNode.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class MsgTabStoryNodeListManager$12
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    MsgTabStoryNodeListManager.d(this.c).setAlpha(1.0F - MsgTabStoryNodeListManager.d(this.c).getTranslationY() / MsgTabStoryNodeListManager.e(this.c) + 0.3F);
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = this.a;
    MsgTabStoryNodeListManager.f(this.c).setTranslationY(this.b + (f1 - f2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.12
 * JD-Core Version:    0.7.0.1
 */