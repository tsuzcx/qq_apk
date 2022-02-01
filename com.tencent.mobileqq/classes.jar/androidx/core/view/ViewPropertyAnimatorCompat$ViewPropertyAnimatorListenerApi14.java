package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;

class ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14
  implements ViewPropertyAnimatorListener
{
  boolean mAnimEndCalled;
  ViewPropertyAnimatorCompat mVpa;
  
  ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    this.mVpa = paramViewPropertyAnimatorCompat;
  }
  
  public void onAnimationCancel(View paramView)
  {
    Object localObject = paramView.getTag(2113929216);
    if ((localObject instanceof ViewPropertyAnimatorListener)) {}
    for (localObject = (ViewPropertyAnimatorListener)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewPropertyAnimatorListener)localObject).onAnimationCancel(paramView);
      }
      return;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public void onAnimationEnd(View paramView)
  {
    if (this.mVpa.mOldLayerType > -1)
    {
      paramView.setLayerType(this.mVpa.mOldLayerType, null);
      this.mVpa.mOldLayerType = -1;
    }
    if ((Build.VERSION.SDK_INT >= 16) || (!this.mAnimEndCalled))
    {
      if (this.mVpa.mEndAction != null)
      {
        localObject = this.mVpa.mEndAction;
        this.mVpa.mEndAction = null;
        ((Runnable)localObject).run();
      }
      localObject = paramView.getTag(2113929216);
      if (!(localObject instanceof ViewPropertyAnimatorListener)) {
        break label114;
      }
    }
    label114:
    for (Object localObject = (ViewPropertyAnimatorListener)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewPropertyAnimatorListener)localObject).onAnimationEnd(paramView);
      }
      this.mAnimEndCalled = true;
      return;
    }
  }
  
  public void onAnimationStart(View paramView)
  {
    this.mAnimEndCalled = false;
    if (this.mVpa.mOldLayerType > -1) {
      paramView.setLayerType(2, null);
    }
    if (this.mVpa.mStartAction != null)
    {
      localObject = this.mVpa.mStartAction;
      this.mVpa.mStartAction = null;
      ((Runnable)localObject).run();
    }
    Object localObject = paramView.getTag(2113929216);
    if ((localObject instanceof ViewPropertyAnimatorListener)) {}
    for (localObject = (ViewPropertyAnimatorListener)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewPropertyAnimatorListener)localObject).onAnimationStart(paramView);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorListenerApi14
 * JD-Core Version:    0.7.0.1
 */