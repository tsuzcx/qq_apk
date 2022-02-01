package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class DiscussionMemberActivity$SearchTextWatcher
  implements TextWatcher
{
  private DiscussionMemberActivity$SearchTextWatcher(DiscussionMemberActivity paramDiscussionMemberActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.a.getText().toString().trim();
    this.a.b(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity.SearchTextWatcher
 * JD-Core Version:    0.7.0.1
 */