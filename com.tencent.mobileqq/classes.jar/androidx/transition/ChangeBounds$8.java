package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;

class ChangeBounds$8
  extends AnimatorListenerAdapter
{
  private boolean mIsCanceled;
  
  ChangeBounds$8(ChangeBounds paramChangeBounds, View paramView, Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.mIsCanceled = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.mIsCanceled)
    {
      ViewCompat.setClipBounds(this.val$view, this.val$finalClip);
      ViewUtils.setLeftTopRightBottom(this.val$view, this.val$endLeft, this.val$endTop, this.val$endRight, this.val$endBottom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ChangeBounds.8
 * JD-Core Version:    0.7.0.1
 */