package com.tencent.biz.qqcircle.richframework.widget.menu;

import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager.LayoutParams;
import java.lang.ref.WeakReference;

class BubblePopupWindow$1
  implements ViewTreeObserver.OnScrollChangedListener
{
  BubblePopupWindow$1(BubblePopupWindow paramBubblePopupWindow) {}
  
  public void onScrollChanged()
  {
    View localView;
    if (BubblePopupWindow.a(this.a) != null) {
      localView = (View)BubblePopupWindow.a(this.a).get();
    } else {
      localView = null;
    }
    if ((localView != null) && (BubblePopupWindow.b(this.a) != null))
    {
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)BubblePopupWindow.b(this.a).getLayoutParams();
      if (localLayoutParams == null) {
        return;
      }
      BubblePopupWindow localBubblePopupWindow = this.a;
      BubblePopupWindow.a(localBubblePopupWindow, localView, localLayoutParams, BubblePopupWindow.c(localBubblePopupWindow), BubblePopupWindow.d(this.a));
      this.a.a(localLayoutParams.x, localLayoutParams.y, -1, -1, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow.1
 * JD-Core Version:    0.7.0.1
 */