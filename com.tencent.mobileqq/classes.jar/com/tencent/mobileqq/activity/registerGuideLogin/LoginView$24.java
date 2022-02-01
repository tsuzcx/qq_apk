package com.tencent.mobileqq.activity.registerGuideLogin;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginView$24
  implements View.OnClickListener
{
  LoginView$24(LoginView paramLoginView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.i != null) && (this.a.i.isShown())) {
      this.a.i.setVisibility(8);
    }
    this.a.p.setText("");
    this.a.h.setText("");
    this.a.b();
    libsafeedit.clearPassBuffer();
    LoginView.C(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.24
 * JD-Core Version:    0.7.0.1
 */