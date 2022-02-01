package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class TroopTransferActivity$SearchTextWatcher
  implements TextWatcher
{
  private TroopTransferActivity$SearchTextWatcher(TroopTransferActivity paramTroopTransferActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.j.getText().toString().trim();
    this.a.a(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.SearchTextWatcher
 * JD-Core Version:    0.7.0.1
 */