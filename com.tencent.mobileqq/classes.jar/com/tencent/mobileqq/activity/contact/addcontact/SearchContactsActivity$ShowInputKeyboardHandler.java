package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.MessageQueue.IdleHandler;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

final class SearchContactsActivity$ShowInputKeyboardHandler
  implements MessageQueue.IdleHandler
{
  final SearchContactsActivity a;
  
  public SearchContactsActivity$ShowInputKeyboardHandler(SearchContactsActivity paramSearchContactsActivity)
  {
    this.a = paramSearchContactsActivity;
  }
  
  public boolean queueIdle()
  {
    this.a.K.requestFocus();
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(this.a.K, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity.ShowInputKeyboardHandler
 * JD-Core Version:    0.7.0.1
 */