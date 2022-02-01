package com.tencent.av.ui;

import android.view.ViewParent;
import android.widget.RelativeLayout;

class NormalMenuView$2$1
  implements Runnable
{
  NormalMenuView$2$1(NormalMenuView.2 param2) {}
  
  public void run()
  {
    ViewParent localViewParent;
    if (this.a.c.c != null) {
      localViewParent = this.a.c.c.getParent();
    } else {
      localViewParent = null;
    }
    if (localViewParent != null) {
      localViewParent.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.NormalMenuView.2.1
 * JD-Core Version:    0.7.0.1
 */