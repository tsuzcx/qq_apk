package com.tencent.biz.qrcode.logindev;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

class LoginDevInfoAdapter$1
  implements View.OnTouchListener
{
  LoginDevInfoAdapter$1(LoginDevInfoAdapter paramLoginDevInfoAdapter, Drawable paramDrawable, LoginDevItem paramLoginDevItem) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return true;
        }
      }
      else if (LoginDevInfoAdapter.a(this.c) != null) {
        LoginDevInfoAdapter.a(this.c).a(this.b);
      }
      if ((this.a instanceof GradientDrawable))
      {
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
        {
          ((GradientDrawable)this.a).setColor(-16777216);
          return true;
        }
        ((GradientDrawable)this.a).setColor(-1);
        return true;
      }
    }
    else if ((this.a instanceof GradientDrawable))
    {
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        ((GradientDrawable)this.a).setColor(-15263977);
        return true;
      }
      ((GradientDrawable)this.a).setColor(-920840);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.logindev.LoginDevInfoAdapter.1
 * JD-Core Version:    0.7.0.1
 */