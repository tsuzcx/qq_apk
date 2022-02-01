package com.tencent.mobileqq.activity.contact.addcontact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class ClassificationSearchActivity$12
  implements View.OnTouchListener
{
  ClassificationSearchActivity$12(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (InputMethodManager)this.a.getSystemService("input_method");
    if (paramMotionEvent.isActive()) {
      paramMotionEvent.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    this.a.a.clearFocus();
    paramView = this.a.a.getText().toString();
    this.a.a.setSelection(paramView.length());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.12
 * JD-Core Version:    0.7.0.1
 */