package com.tencent.mm.ui.widget.snackbar;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SnackBar$1
  implements View.OnClickListener
{
  SnackBar$1(SnackBar paramSnackBar) {}
  
  public void onClick(View paramView)
  {
    if ((SnackBar.a(this.a) != null) && (SnackBar.b(this.a).isShowing())) {
      SnackBar.a(this.a).onMessageClick();
    }
    SnackBar.c(this.a).postDelayed(new SnackBar.1.1(this), 100L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.SnackBar.1
 * JD-Core Version:    0.7.0.1
 */