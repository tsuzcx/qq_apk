package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.PastablePwdEditText;

class AddAccountActivity$7
  implements TextWatcher
{
  AddAccountActivity$7(AddAccountActivity paramAddAccountActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    AddAccountActivity.access$502(this.a, null);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AddAccountActivity.access$502(this.a, paramCharSequence.toString());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.mCurrentAccount != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if ((paramCharSequence != null) && (AddAccountActivity.access$500(this.a) != null) && (AddAccountActivity.access$500(this.a).length() != paramCharSequence.length()) && (paramInt3 != 0)) {
        BaseApplicationImpl.sApplication.refreAccountList();
      }
      AddAccountActivity.access$600(this.a, null);
      if (AddAccountActivity.access$500(this.a) != null)
      {
        if (AddAccountActivity.access$500(this.a).length() == 0) {
          return;
        }
        if ((paramCharSequence != null) && (paramCharSequence.length() != 0) && (paramCharSequence.length() == AddAccountActivity.access$500(this.a).length() + 1))
        {
          if ((paramCharSequence.substring(0, AddAccountActivity.access$500(this.a).length()).equals(AddAccountActivity.access$500(this.a))) && (this.a.mPwdEdit != null))
          {
            paramCharSequence = paramCharSequence.substring(AddAccountActivity.access$500(this.a).length());
            if (paramCharSequence != null)
            {
              if (paramCharSequence.length() != 1) {
                return;
              }
              this.a.mPwdEdit.setText(paramCharSequence);
              this.a.mPwdEdit.setSelection(1);
            }
          }
        }
        else {
          BaseApplicationImpl.sApplication.refreAccountList();
        }
      }
      else
      {
        return;
      }
    }
    AddAccountActivity.access$502(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity.7
 * JD-Core Version:    0.7.0.1
 */