package com.tencent.mobileqq.activity.history;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class ChatHistoryTroopMemberFragment$SearchTextWatcher
  implements TextWatcher
{
  protected ChatHistoryTroopMemberFragment$SearchTextWatcher(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.a.getText().toString().trim();
    this.a.e(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.SearchTextWatcher
 * JD-Core Version:    0.7.0.1
 */