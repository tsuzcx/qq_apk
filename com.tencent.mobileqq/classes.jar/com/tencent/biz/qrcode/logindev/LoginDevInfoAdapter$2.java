package com.tencent.biz.qrcode.logindev;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginDevInfoAdapter$2
  implements View.OnClickListener
{
  LoginDevInfoAdapter$2(LoginDevInfoAdapter paramLoginDevInfoAdapter, LoginDevItem paramLoginDevItem) {}
  
  public void onClick(View paramView)
  {
    if (LoginDevInfoAdapter.a(this.b) != null) {
      LoginDevInfoAdapter.a(this.b).b(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.logindev.LoginDevInfoAdapter.2
 * JD-Core Version:    0.7.0.1
 */