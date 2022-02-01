package com.tencent.mm.ui.widget.snackbar;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.Queue;

class SnackContainer$3
  implements View.OnTouchListener
{
  SnackContainer$3(SnackContainer paramSnackContainer, SnackContainer.SnackHolder paramSnackHolder) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 4)
    {
      paramView = this.b;
      paramView.removeCallbacks(SnackContainer.c(paramView));
      SnackContainer.a(this.b, this.a);
      paramView = this.b;
      paramView.startAnimation(SnackContainer.a(paramView));
      if (!SnackContainer.b(this.b).isEmpty()) {
        SnackContainer.b(this.b).clear();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackContainer.3
 * JD-Core Version:    0.7.0.1
 */