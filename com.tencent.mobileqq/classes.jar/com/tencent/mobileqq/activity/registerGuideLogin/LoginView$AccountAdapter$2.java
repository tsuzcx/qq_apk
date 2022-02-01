package com.tencent.mobileqq.activity.registerGuideLogin;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class LoginView$AccountAdapter$2
  implements View.OnClickListener
{
  LoginView$AccountAdapter$2(LoginView.AccountAdapter paramAccountAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.b.b.p.removeTextChangedListener(this.b.b.H);
    this.b.b.h.removeTextChangedListener(this.b.b.I);
    this.b.b.p.removeTextChangedListener(this.b.b.J);
    this.b.b.x = this.a;
    SimpleAccount localSimpleAccount = (SimpleAccount)this.b.b.v.get(this.b.b.x);
    if (!LoginView.E(this.b.b))
    {
      LoginView.g(this.b.b, true);
      this.b.b.h.setTransformationMethod(PasswordTransformationMethod.getInstance());
      ImageView localImageView = this.b.b.j;
      int i;
      if ((!LoginView.r(this.b.b)) && (!LoginView.s(this.b.b)) && (!this.b.b.z) && (!LoginView.t(this.b.b))) {
        i = 2130846063;
      } else {
        i = 2130848790;
      }
      localImageView.setImageResource(i);
      this.b.b.j.setContentDescription(HardCodeUtil.a(2131904280));
    }
    LoginView.a(this.b.b, localSimpleAccount);
    this.b.b.p.addTextChangedListener(this.b.b.H);
    this.b.b.h.addTextChangedListener(this.b.b.I);
    this.b.b.p.clearFocus();
    this.b.b.p.addTextChangedListener(this.b.b.J);
    this.b.b.h.clearFocus();
    this.b.b.h.setClearButtonVisible(false);
    this.b.b.q.getDelIcon().setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.AccountAdapter.2
 * JD-Core Version:    0.7.0.1
 */