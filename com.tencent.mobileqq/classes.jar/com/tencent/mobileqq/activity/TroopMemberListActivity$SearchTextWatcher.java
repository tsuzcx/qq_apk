package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class TroopMemberListActivity$SearchTextWatcher
  implements TextWatcher
{
  protected TroopMemberListActivity$SearchTextWatcher(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.searchEditText.getText().toString().trim();
    this.a.refreshSearchResultList(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.SearchTextWatcher
 * JD-Core Version:    0.7.0.1
 */