package com.tencent.mm.ui.widget.snackbar;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SnackBar$2
  implements View.OnTouchListener
{
  SnackBar$2(SnackBar paramSnackBar) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((SnackBarAlert.isShow()) && (SnackBar.b(this.a).isShowing()))
    {
      SnackBarAlert.setShowMode(false);
      SnackBar.c(this.a).postDelayed(new SnackBar.2.1(this), 100L);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackBar.2
 * JD-Core Version:    0.7.0.1
 */