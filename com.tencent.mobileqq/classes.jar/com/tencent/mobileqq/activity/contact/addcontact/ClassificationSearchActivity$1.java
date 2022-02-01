package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.MessageQueue.IdleHandler;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class ClassificationSearchActivity$1
  implements MessageQueue.IdleHandler
{
  ClassificationSearchActivity$1(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public boolean queueIdle()
  {
    this.a.K.requestFocus();
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(this.a.K, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.1
 * JD-Core Version:    0.7.0.1
 */