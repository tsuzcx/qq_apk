package android.support.v4.view;

import android.view.View;

class ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener
  implements ViewPropertyAnimatorListener
{
  ViewPropertyAnimatorCompat mVpa;
  
  ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$MyVpaListener(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
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
  
  public void onAnimationEnd(View paramView)
  {
    if (ViewPropertyAnimatorCompat.access$400(this.mVpa) >= 0)
    {
      ViewCompat.setLayerType(paramView, ViewPropertyAnimatorCompat.access$400(this.mVpa), null);
      ViewPropertyAnimatorCompat.access$402(this.mVpa, -1);
    }
    if (ViewPropertyAnimatorCompat.access$000(this.mVpa) != null) {
      ViewPropertyAnimatorCompat.access$000(this.mVpa).run();
    }
    Object localObject = paramView.getTag(2113929216);
    if ((localObject instanceof ViewPropertyAnimatorListener)) {}
    for (localObject = (ViewPropertyAnimatorListener)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewPropertyAnimatorListener)localObject).onAnimationEnd(paramView);
      }
      return;
    }
  }
  
  public void onAnimationStart(View paramView)
  {
    if (ViewPropertyAnimatorCompat.access$400(this.mVpa) >= 0) {
      ViewCompat.setLayerType(paramView, 2, null);
    }
    if (ViewPropertyAnimatorCompat.access$100(this.mVpa) != null) {
      ViewPropertyAnimatorCompat.access$100(this.mVpa).run();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl.MyVpaListener
 * JD-Core Version:    0.7.0.1
 */