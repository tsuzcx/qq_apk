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
    if ((localObject instanceof ViewPropertyAnimatorListener)) {
      localObject = (ViewPropertyAnimatorListener)localObject;
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((ViewPropertyAnimatorListener)localObject).onAnimationCancel(paramView);
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public void onAnimationEnd(View paramView)
  {
    int i = this.mVpa.mOldLayerType;
    ViewPropertyAnimatorListener localViewPropertyAnimatorListener = null;
    if (i > -1)
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
      Object localObject = paramView.getTag(2113929216);
      if ((localObject instanceof ViewPropertyAnimatorListener)) {
        localViewPropertyAnimatorListener = (ViewPropertyAnimatorListener)localObject;
      }
      if (localViewPropertyAnimatorListener != null) {
        localViewPropertyAnimatorListener.onAnimationEnd(paramView);
      }
      this.mAnimEndCalled = true;
    }
  }
  
  public void onAnimationStart(View paramView)
  {
    this.mAnimEndCalled = false;
    int i = this.mVpa.mOldLayerType;
    ViewPropertyAnimatorListener localViewPropertyAnimatorListener = null;
    if (i > -1) {
      paramView.setLayerType(2, null);
    }
    if (this.mVpa.mStartAction != null)
    {
      localObject = this.mVpa.mStartAction;
      this.mVpa.mStartAction = null;
      ((Runnable)localObject).run();
    }
    Object localObject = paramView.getTag(2113929216);
    if ((localObject instanceof ViewPropertyAnimatorListener)) {
      localViewPropertyAnimatorListener = (ViewPropertyAnimatorListener)localObject;
    }
    if (localViewPropertyAnimatorListener != null) {
      localViewPropertyAnimatorListener.onAnimationStart(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.ViewPropertyAnimatorCompat.ViewPropertyAnimatorListenerApi14
 * JD-Core Version:    0.7.0.1
 */