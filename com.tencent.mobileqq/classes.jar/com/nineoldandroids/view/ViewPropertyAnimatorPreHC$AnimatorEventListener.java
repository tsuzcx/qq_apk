package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

class ViewPropertyAnimatorPreHC$AnimatorEventListener
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private ViewPropertyAnimatorPreHC$AnimatorEventListener(ViewPropertyAnimatorPreHC paramViewPropertyAnimatorPreHC) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (ViewPropertyAnimatorPreHC.access$1(this.this$0) != null) {
      ViewPropertyAnimatorPreHC.access$1(this.this$0).onAnimationCancel(paramAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (ViewPropertyAnimatorPreHC.access$1(this.this$0) != null) {
      ViewPropertyAnimatorPreHC.access$1(this.this$0).onAnimationEnd(paramAnimator);
    }
    ViewPropertyAnimatorPreHC.access$2(this.this$0).remove(paramAnimator);
    if (ViewPropertyAnimatorPreHC.access$2(this.this$0).isEmpty()) {
      ViewPropertyAnimatorPreHC.access$3(this.this$0, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (ViewPropertyAnimatorPreHC.access$1(this.this$0) != null) {
      ViewPropertyAnimatorPreHC.access$1(this.this$0).onAnimationRepeat(paramAnimator);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (ViewPropertyAnimatorPreHC.access$1(this.this$0) != null) {
      ViewPropertyAnimatorPreHC.access$1(this.this$0).onAnimationStart(paramAnimator);
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = (ViewPropertyAnimatorPreHC.PropertyBundle)ViewPropertyAnimatorPreHC.access$2(this.this$0).get(paramValueAnimator);
    Object localObject;
    if ((paramValueAnimator.mPropertyMask & 0x1FF) != 0)
    {
      localObject = (View)ViewPropertyAnimatorPreHC.access$4(this.this$0).get();
      if (localObject != null) {
        ((View)localObject).invalidate();
      }
    }
    paramValueAnimator = paramValueAnimator.mNameValuesHolder;
    int j;
    int i;
    if (paramValueAnimator != null)
    {
      j = paramValueAnimator.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        paramValueAnimator = (View)ViewPropertyAnimatorPreHC.access$4(this.this$0).get();
        if (paramValueAnimator != null) {
          paramValueAnimator.invalidate();
        }
        return;
      }
      localObject = (ViewPropertyAnimatorPreHC.NameValuesHolder)paramValueAnimator.get(i);
      float f2 = ((ViewPropertyAnimatorPreHC.NameValuesHolder)localObject).mFromValue;
      float f3 = ((ViewPropertyAnimatorPreHC.NameValuesHolder)localObject).mDeltaValue;
      ViewPropertyAnimatorPreHC.access$5(this.this$0, ((ViewPropertyAnimatorPreHC.NameValuesHolder)localObject).mNameConstant, f2 + f3 * f1);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.nineoldandroids.view.ViewPropertyAnimatorPreHC.AnimatorEventListener
 * JD-Core Version:    0.7.0.1
 */