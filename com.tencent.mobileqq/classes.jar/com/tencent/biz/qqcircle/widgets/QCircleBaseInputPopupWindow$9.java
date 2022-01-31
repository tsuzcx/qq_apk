package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import tzr;

public class QCircleBaseInputPopupWindow$9
  implements Runnable
{
  public QCircleBaseInputPopupWindow$9(tzr paramtzr, View paramView) {}
  
  public void run()
  {
    tzr.a(this.this$0).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleBaseInputPopupWindow.9
 * JD-Core Version:    0.7.0.1
 */