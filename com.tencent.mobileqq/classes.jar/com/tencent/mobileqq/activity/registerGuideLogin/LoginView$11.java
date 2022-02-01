package com.tencent.mobileqq.activity.registerGuideLogin;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;

class LoginView$11
  implements View.OnTouchListener
{
  LoginView$11(LoginView paramLoginView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("mScrollRootView.setOnTouch action=");
      paramView.append(paramMotionEvent.getAction());
      paramView.append(" im:");
      paramView.append(LoginView.a(this.a));
      QLog.d("LoginActivity.LoginView", 2, paramView.toString());
    }
    if ((paramMotionEvent.getAction() == 1) && (LoginView.a(this.a) != null)) {
      LoginView.a(this.a).hideSoftInputFromWindow(this.a.a.getWindow().getDecorView().getWindowToken(), 0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.11
 * JD-Core Version:    0.7.0.1
 */