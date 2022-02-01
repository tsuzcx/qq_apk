package com.tencent.mm.ui.widget.snackbar;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.Queue;

class SnackContainer$2
  implements Animation.AnimationListener
{
  SnackContainer$2(SnackContainer paramSnackContainer) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.removeAllViews();
    if (!SnackContainer.b(this.a).isEmpty())
    {
      paramAnimation = this.a;
      SnackContainer.a(paramAnimation, (SnackContainer.SnackHolder)SnackContainer.b(paramAnimation).poll());
    }
    if (!this.a.isEmpty())
    {
      paramAnimation = this.a;
      SnackContainer.b(paramAnimation, (SnackContainer.SnackHolder)SnackContainer.b(paramAnimation).peek());
      return;
    }
    this.a.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((!this.a.isEmpty()) && (SnackContainer.b(this.a).peek() != null) && (((SnackContainer.SnackHolder)SnackContainer.b(this.a).peek()).e != null))
    {
      SnackBarAlert.setShowMode(false);
      ((SnackContainer.SnackHolder)SnackContainer.b(this.a).peek()).e.startHide();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer.2
 * JD-Core Version:    0.7.0.1
 */