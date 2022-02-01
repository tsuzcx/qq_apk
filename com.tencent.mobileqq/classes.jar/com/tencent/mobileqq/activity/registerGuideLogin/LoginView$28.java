package com.tencent.mobileqq.activity.registerGuideLogin;

import android.text.Editable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.qphone.base.util.QLog;

class LoginView$28
  implements View.OnFocusChangeListener
{
  LoginView$28(LoginView paramLoginView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == this.a.p)
    {
      if (true == paramBoolean)
      {
        this.a.p.setSelection(this.a.p.length());
        if (this.a.p.isPopupShowing()) {
          this.a.p.dismissDropDown();
        }
        if ((this.a.i != null) && (this.a.p.getText().length() > 0)) {
          this.a.i.setVisibility(0);
        }
        this.a.p.setSelection(this.a.p.getText().length());
        if (GuideHandler.a(GuideHandler.a)) {
          return;
        }
        if ((LoginView.c(this.a).isActive(this.a.p)) && (QLog.isColorLevel())) {
          QLog.d("InputMethodRelativeLayout", 2, "isActive(mAutoTextAccount)");
        }
        this.a.p.setHint("");
        return;
      }
      if ((this.a.i != null) && (this.a.i.isShown())) {
        this.a.i.setVisibility(8);
      }
      paramView = new SpannableString(HardCodeUtil.a(2131905388));
      paramView.setSpan(new AbsoluteSizeSpan(17, true), 0, paramView.length(), 33);
      this.a.p.setHint(paramView);
      return;
    }
    if (paramView == this.a.h)
    {
      if (paramBoolean)
      {
        this.a.h.setSelection(this.a.h.getText().length());
        this.a.j.setVisibility(0);
        if (LoginView.c(this.a).isActive(this.a.h)) {
          LoginView.c(this.a).showSoftInput(this.a.h, 2);
        }
        this.a.h.setHint("");
        return;
      }
      this.a.j.setVisibility(8);
      paramView = new SpannableString(HardCodeUtil.a(2131897872));
      paramView.setSpan(new AbsoluteSizeSpan(17, true), 0, paramView.length(), 33);
      this.a.h.setHint(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.28
 * JD-Core Version:    0.7.0.1
 */