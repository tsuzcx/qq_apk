package com.tencent.biz.qqcircle.immersive.part;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout;

class QFSMainMultiTabFragmentPart$10$1
  implements ValueAnimator.AnimatorUpdateListener
{
  QFSMainMultiTabFragmentPart$10$1(QFSMainMultiTabFragmentPart.10 param10, float paramFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((paramValueAnimator != null) && (QFSMainMultiTabFragmentPart.i(this.b.this$0) != null))
    {
      QFSMainMultiTabFragmentPart.i(this.b.this$0).setTranslationY(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
      float f = (this.a - ((Float)paramValueAnimator.getAnimatedValue()).floatValue()) / this.a;
      QFSMainMultiTabFragmentPart.i(this.b.this$0).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart.10.1
 * JD-Core Version:    0.7.0.1
 */