package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

class DefaultItemAnimator$4
  extends AnimatorListenerAdapter
{
  DefaultItemAnimator$4(DefaultItemAnimator paramDefaultItemAnimator, RecyclerView.ViewHolder paramViewHolder, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$animation.setListener(null);
    this.val$view.setAlpha(1.0F);
    this.this$0.dispatchRemoveFinished(this.val$holder);
    this.this$0.mRemoveAnimations.remove(this.val$holder);
    this.this$0.dispatchFinishedWhenDone();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.this$0.dispatchRemoveStarting(this.val$holder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.DefaultItemAnimator.4
 * JD-Core Version:    0.7.0.1
 */