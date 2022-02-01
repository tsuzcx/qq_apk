package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.login.ui.AddAccountBaseUI;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

class AddAccountActivity$8
  implements TextWatcher
{
  AddAccountActivity$8(AddAccountActivity paramAddAccountActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.mCurrentAccount != null)
    {
      AddAccountActivity.access$700(this.a);
      return;
    }
    if (paramCharSequence == null) {
      return;
    }
    String str = paramCharSequence.toString();
    if (str != null)
    {
      if (str.length() == 0) {
        return;
      }
      if (this.a.mSimpleAccoutList != null)
      {
        paramInt1 = 0;
        while (paramInt1 < this.a.mSimpleAccoutList.size())
        {
          SimpleAccount localSimpleAccount = (SimpleAccount)this.a.mSimpleAccoutList.get(paramInt1);
          if ((localSimpleAccount != null) && (localSimpleAccount.getUin() != null))
          {
            if (this.a.app == null) {
              paramCharSequence = localSimpleAccount.getUin();
            } else {
              paramCharSequence = this.a.app.getUinDisplayNameBeforeLogin(localSimpleAccount.getUin());
            }
            if (str.equals(paramCharSequence))
            {
              if (localSimpleAccount.isLogined())
              {
                if (this.a.mBaseUI.o()) {
                  this.a.mBaseUI.c();
                }
                this.a.mBaseUI.b("!@#ewaGbhkc$!!=");
                this.a.mCurrentAccount = localSimpleAccount;
                return;
              }
              this.a.mBaseUI.b("");
              return;
            }
          }
          paramInt1 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity.8
 * JD-Core Version:    0.7.0.1
 */