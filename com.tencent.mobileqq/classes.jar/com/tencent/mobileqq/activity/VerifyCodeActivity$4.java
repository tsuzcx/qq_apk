package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;

class VerifyCodeActivity$4
  implements TextWatcher
{
  VerifyCodeActivity$4(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() >= 4)
    {
      VerifyCodeActivity.access$200(this.a, true);
      return;
    }
    VerifyCodeActivity.access$300(this.a, false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyCodeActivity.4
 * JD-Core Version:    0.7.0.1
 */