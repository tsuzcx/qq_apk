package com.tencent.mobileqq.activity.aio.navigate;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class NavigateBarManager$4
  implements View.OnTouchListener
{
  NavigateBarManager$4(NavigateBarManager paramNavigateBarManager) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (((i == 1) || (i == 3)) && (Build.VERSION.SDK_INT >= 11)) {
        paramView.setAlpha(1.0F);
      }
    }
    else if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager.4
 * JD-Core Version:    0.7.0.1
 */