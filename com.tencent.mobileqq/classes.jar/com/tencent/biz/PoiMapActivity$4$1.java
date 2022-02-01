package com.tencent.biz;

import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

class PoiMapActivity$4$1
  implements Runnable
{
  PoiMapActivity$4$1(PoiMapActivity.4 param4) {}
  
  public void run()
  {
    this.a.c.v = false;
    this.a.c.u.startAnimation(this.a.a);
    this.a.b.hideSoftInputFromWindow(this.a.c.getWindow().peekDecorView().getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.4.1
 * JD-Core Version:    0.7.0.1
 */