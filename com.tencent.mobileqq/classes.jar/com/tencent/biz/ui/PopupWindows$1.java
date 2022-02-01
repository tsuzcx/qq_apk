package com.tencent.biz.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;

class PopupWindows$1
  implements View.OnTouchListener
{
  PopupWindows$1(PopupWindows paramPopupWindows) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 4)
    {
      this.a.c.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.PopupWindows.1
 * JD-Core Version:    0.7.0.1
 */