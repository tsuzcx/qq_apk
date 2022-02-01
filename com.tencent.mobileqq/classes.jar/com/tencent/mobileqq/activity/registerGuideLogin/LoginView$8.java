package com.tencent.mobileqq.activity.registerGuideLogin;

import android.view.View;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.loginregister.EquipLockProxy;

class LoginView$8
  extends URLDrawableDownListener.Adapter
{
  LoginView$8(LoginView paramLoginView) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = paramURLDrawable.getCurrDrawable();
    if ((paramView instanceof ApngDrawable)) {
      LoginView.a(this.a).a(null, (ApngDrawable)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.8
 * JD-Core Version:    0.7.0.1
 */