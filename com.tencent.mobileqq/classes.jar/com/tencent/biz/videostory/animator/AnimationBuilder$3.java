package com.tencent.biz.videostory.animator;

import android.view.View;

class AnimationBuilder$3
  implements AnimationListener.Update
{
  AnimationBuilder$3(AnimationBuilder paramAnimationBuilder) {}
  
  public void a(View paramView, float paramFloat)
  {
    paramView.getLayoutParams().width = ((int)paramFloat);
    paramView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.animator.AnimationBuilder.3
 * JD-Core Version:    0.7.0.1
 */