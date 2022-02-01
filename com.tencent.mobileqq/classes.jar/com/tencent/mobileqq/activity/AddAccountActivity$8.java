package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

class AddAccountActivity$8
  implements TextWatcher
{
  AddAccountActivity$8(AddAccountActivity paramAddAccountActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() > 0)
    {
      if (this.a.mDelIcon != null) {
        this.a.mDelIcon.setVisibility(0);
      }
    }
    else if ((this.a.mDelIcon != null) && (this.a.mDelIcon.isShown())) {
      this.a.mDelIcon.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity.8
 * JD-Core Version:    0.7.0.1
 */