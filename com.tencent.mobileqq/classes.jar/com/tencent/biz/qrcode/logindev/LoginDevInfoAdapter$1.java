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
      else if (LoginDevInfoAdapter.a(this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevInfoAdapter) != null) {
        LoginDevInfoAdapter.a(this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevInfoAdapter).a(this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevItem);
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof GradientDrawable))
      {
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
        {
          ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setColor(-16777216);
          return true;
        }
        ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setColor(-1);
        return true;
      }
    }
    else if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof GradientDrawable))
    {
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setColor(-15263977);
        return true;
      }
      ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setColor(-920840);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.logindev.LoginDevInfoAdapter.1
 * JD-Core Version:    0.7.0.1
 */