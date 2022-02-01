package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

class DefaultItemAnimator$8
  extends AnimatorListenerAdapter
{
  DefaultItemAnimator$8(DefaultItemAnimator paramDefaultItemAnimator, DefaultItemAnimator.ChangeInfo paramChangeInfo, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$newViewAnimation.setListener(null);
    this.val$newView.setAlpha(1.0F);
    this.val$newView.setTranslationX(0.0F);
    this.val$newView.setTranslationY(0.0F);
    this.this$0.dispatchChangeFinished(this.val$changeInfo.newHolder, false);
    this.this$0.mChangeAnimations.remove(this.val$changeInfo.newHolder);
    this.this$0.dispatchFinishedWhenDone();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.this$0.dispatchChangeStarting(this.val$changeInfo.newHolder, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.DefaultItemAnimator.8
 * JD-Core Version:    0.7.0.1
 */