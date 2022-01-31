package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

class DefaultItemAnimator$7
  extends DefaultItemAnimator.VpaListenerAdapter
{
  DefaultItemAnimator$7(DefaultItemAnimator paramDefaultItemAnimator, DefaultItemAnimator.ChangeInfo paramChangeInfo, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.val$oldViewAnim.setListener(null);
    ViewCompat.setAlpha(paramView, 1.0F);
    ViewCompat.setTranslationX(paramView, 0.0F);
    ViewCompat.setTranslationY(paramView, 0.0F);
    this.this$0.dispatchChangeFinished(this.val$changeInfo.oldHolder, true);
    DefaultItemAnimator.access$1300(this.this$0).remove(this.val$changeInfo.oldHolder);
    DefaultItemAnimator.access$800(this.this$0);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.this$0.dispatchChangeStarting(this.val$changeInfo.oldHolder, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.DefaultItemAnimator.7
 * JD-Core Version:    0.7.0.1
 */