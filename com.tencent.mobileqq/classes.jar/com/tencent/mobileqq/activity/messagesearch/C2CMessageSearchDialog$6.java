package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;

class C2CMessageSearchDialog$6
  implements View.OnTouchListener
{
  C2CMessageSearchDialog$6(C2CMessageSearchDialog paramC2CMessageSearchDialog) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)this.a.c.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog.6
 * JD-Core Version:    0.7.0.1
 */