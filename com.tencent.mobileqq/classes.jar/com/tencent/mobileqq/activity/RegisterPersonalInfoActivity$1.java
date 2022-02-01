package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant;

class RegisterPersonalInfoActivity$1
  implements TextWatcher
{
  RegisterPersonalInfoActivity$1(RegisterPersonalInfoActivity paramRegisterPersonalInfoActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    if (TextUtils.isEmpty(paramEditable.toString())) {
      RegisterPersonalInfoActivity.a(this.a).setEnabled(false);
    } else {
      RegisterPersonalInfoActivity.a(this.a).setEnabled(true);
    }
    if (RegisterPersonalInfoActivity.b(this.a) != null) {
      RegisterPersonalInfoActivity.b(this.a).b(RegisterPersonalInfoActivity.a(this.a).isEnabled());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPersonalInfoActivity.1
 * JD-Core Version:    0.7.0.1
 */