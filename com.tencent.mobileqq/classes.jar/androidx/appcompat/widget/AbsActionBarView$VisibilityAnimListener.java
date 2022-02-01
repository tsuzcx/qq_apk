package androidx.appcompat.widget;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

public class AbsActionBarView$VisibilityAnimListener
  implements ViewPropertyAnimatorListener
{
  private boolean mCanceled = false;
  int mFinalVisibility;
  
  protected AbsActionBarView$VisibilityAnimListener(AbsActionBarView paramAbsActionBarView) {}
  
  public void onAnimationCancel(View paramView)
  {
    this.mCanceled = true;
  }
  
  public void onAnimationEnd(View paramView)
  {
    if (this.mCanceled) {
      return;
    }
    paramView = this.this$0;
    paramView.mVisibilityAnim = null;
    AbsActionBarView.access$101(paramView, this.mFinalVisibility);
  }
  
  public void onAnimationStart(View paramView)
  {
    AbsActionBarView.access$001(this.this$0, 0);
    this.mCanceled = false;
  }
  
  public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, int paramInt)
  {
    this.this$0.mVisibilityAnim = paramViewPropertyAnimatorCompat;
    this.mFinalVisibility = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AbsActionBarView.VisibilityAnimListener
 * JD-Core Version:    0.7.0.1
 */