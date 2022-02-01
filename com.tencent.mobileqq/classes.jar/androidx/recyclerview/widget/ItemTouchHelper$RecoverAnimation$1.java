package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ItemTouchHelper$RecoverAnimation$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ItemTouchHelper$RecoverAnimation$1(ItemTouchHelper.RecoverAnimation paramRecoverAnimation) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.this$0.setFraction(paramValueAnimator.getAnimatedFraction());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation.1
 * JD-Core Version:    0.7.0.1
 */