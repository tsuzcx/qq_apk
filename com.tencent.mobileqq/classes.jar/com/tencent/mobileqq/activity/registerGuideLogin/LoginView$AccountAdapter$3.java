package com.tencent.mobileqq.activity.registerGuideLogin;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class LoginView$AccountAdapter$3
  implements View.OnTouchListener
{
  LoginView$AccountAdapter$3(LoginView.AccountAdapter paramAccountAdapter) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
    else {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.AccountAdapter.3
 * JD-Core Version:    0.7.0.1
 */