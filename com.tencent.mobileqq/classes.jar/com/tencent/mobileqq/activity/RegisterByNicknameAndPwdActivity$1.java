package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.ClearableEditText;

class RegisterByNicknameAndPwdActivity$1
  implements View.OnFocusChangeListener
{
  RegisterByNicknameAndPwdActivity$1(RegisterByNicknameAndPwdActivity paramRegisterByNicknameAndPwdActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == RegisterByNicknameAndPwdActivity.access$000(this.a))
    {
      if (paramBoolean)
      {
        RegisterByNicknameAndPwdActivity.access$000(this.a).setSelection(RegisterByNicknameAndPwdActivity.access$000(this.a).getText().length());
        RegisterByNicknameAndPwdActivity.access$100(this.a).setVisibility(0);
        RegisterByNicknameAndPwdActivity.access$200(this.a).setVisibility(0);
        RegisterByNicknameAndPwdActivity.access$300(this.a).setVisibility(0);
        return;
      }
      RegisterByNicknameAndPwdActivity.access$100(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity.1
 * JD-Core Version:    0.7.0.1
 */