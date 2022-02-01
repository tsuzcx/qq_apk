package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.PastablePwdEditText;

class AddAccountActivity$1
  implements View.OnFocusChangeListener
{
  AddAccountActivity$1(AddAccountActivity paramAddAccountActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == this.a.mAutoTextAccount)
    {
      if (true == paramBoolean)
      {
        if (this.a.mAutoTextAccount.isPopupShowing()) {
          this.a.mAutoTextAccount.dismissDropDown();
        }
        if ((this.a.mDelIcon != null) && (this.a.mAutoTextAccount.getText().length() > 0)) {
          this.a.mDelIcon.setVisibility(0);
        }
        this.a.mAutoTextAccount.setSelection(this.a.mAutoTextAccount.getText().length());
        return;
      }
      if ((this.a.mDelIcon != null) && (this.a.mDelIcon.isShown())) {
        this.a.mDelIcon.setVisibility(8);
      }
    }
    else if ((paramView == this.a.mPwdEdit) && (true == paramBoolean))
    {
      this.a.mPwdEdit.setSelection(this.a.mPwdEdit.getText().length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity.1
 * JD-Core Version:    0.7.0.1
 */