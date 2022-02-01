package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

class DefaultItemAnimator$6
  extends AnimatorListenerAdapter
{
  DefaultItemAnimator$6(DefaultItemAnimator paramDefaultItemAnimator, RecyclerView.ViewHolder paramViewHolder, int paramInt1, View paramView, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.val$deltaX != 0) {
      this.val$view.setTranslationX(0.0F);
    }
    if (this.val$deltaY != 0) {
      this.val$view.setTranslationY(0.0F);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$animation.setListener(null);
    this.this$0.dispatchMoveFinished(this.val$holder);
    this.this$0.mMoveAnimations.remove(this.val$holder);
    this.this$0.dispatchFinishedWhenDone();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.this$0.dispatchMoveStarting(this.val$holder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.DefaultItemAnimator.6
 * JD-Core Version:    0.7.0.1
 */