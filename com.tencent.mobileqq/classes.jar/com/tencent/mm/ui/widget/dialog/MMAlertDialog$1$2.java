package com.tencent.mm.ui.widget.dialog;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class MMAlertDialog$1$2
  implements Animation.AnimationListener
{
  MMAlertDialog$1$2(MMAlertDialog.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    MMAlertDialog.b(this.a.c).setVisibility(0);
    MMAlertDialog.a(this.a.c, 8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    MMAlertDialog.a(this.a.c, MMAlertDialog.e(this.a.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMAlertDialog.1.2
 * JD-Core Version:    0.7.0.1
 */