package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;

class C2CLinkMessageSearchDialog$6
  implements View.OnTouchListener
{
  C2CLinkMessageSearchDialog$6(C2CLinkMessageSearchDialog paramC2CLinkMessageSearchDialog) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)this.a.a.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageSearchDialog.6
 * JD-Core Version:    0.7.0.1
 */