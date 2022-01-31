package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

class DefaultItemAnimator$8
  extends DefaultItemAnimator.VpaListenerAdapter
{
  DefaultItemAnimator$8(DefaultItemAnimator paramDefaultItemAnimator, DefaultItemAnimator.ChangeInfo paramChangeInfo, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    super(null);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.val$newViewAnimation.setListener(null);
    ViewCompat.setAlpha(this.val$newView, 1.0F);
    ViewCompat.setTranslationX(this.val$newView, 0.0F);
    ViewCompat.setTranslationY(this.val$newView, 0.0F);
    this.this$0.dispatchChangeFinished(this.val$changeInfo.newHolder, false);
    DefaultItemAnimator.access$1300(this.this$0).remove(this.val$changeInfo.newHolder);
    DefaultItemAnimator.access$800(this.this$0);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.this$0.dispatchChangeStarting(this.val$changeInfo.newHolder, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.8
 * JD-Core Version:    0.7.0.1
 */