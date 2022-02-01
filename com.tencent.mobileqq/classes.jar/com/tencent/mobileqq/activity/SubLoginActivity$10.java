package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

class SubLoginActivity$10
  implements TextWatcher
{
  SubLoginActivity$10(SubLoginActivity paramSubLoginActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() > 0)
    {
      if (SubLoginActivity.a(this.a) != null) {
        SubLoginActivity.a(this.a).setVisibility(0);
      }
    }
    else if ((SubLoginActivity.a(this.a) != null) && (SubLoginActivity.a(this.a).isShown())) {
      SubLoginActivity.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubLoginActivity.10
 * JD-Core Version:    0.7.0.1
 */