package com.tencent.biz.qqcircle.comment;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

class QCircleBaseInputPopupWindow$5
  implements Runnable
{
  QCircleBaseInputPopupWindow$5(QCircleBaseInputPopupWindow paramQCircleBaseInputPopupWindow, View paramView) {}
  
  public void run()
  {
    QCircleBaseInputPopupWindow.c(this.this$0).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleBaseInputPopupWindow.5
 * JD-Core Version:    0.7.0.1
 */