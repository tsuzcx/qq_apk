package com.tencent.biz.videostory.animator;

import android.view.View;

class AnimationBuilder$2
  implements AnimationListener.Update
{
  AnimationBuilder$2(AnimationBuilder paramAnimationBuilder) {}
  
  public void a(View paramView, float paramFloat)
  {
    paramView.getLayoutParams().height = ((int)paramFloat);
    paramView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.animator.AnimationBuilder.2
 * JD-Core Version:    0.7.0.1
 */