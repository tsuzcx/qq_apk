package com.tencent.biz.qrcode.logindev;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;

class LoginDevInfoAdapter$1
  implements View.OnTouchListener
{
  LoginDevInfoAdapter$1(LoginDevInfoAdapter paramLoginDevInfoAdapter, Drawable paramDrawable, LoginDevItem paramLoginDevItem) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof GradientDrawable)) {
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
        {
          ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setColor(-15263977);
        }
        else
        {
          ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setColor(-920840);
          continue;
          if (LoginDevInfoAdapter.a(this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevInfoAdapter) != null) {
            LoginDevInfoAdapter.a(this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevInfoAdapter).a(this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevItem);
          }
          if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof GradientDrawable)) {
            if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
              ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setColor(-16777216);
            } else {
              ((GradientDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setColor(-1);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.logindev.LoginDevInfoAdapter.1
 * JD-Core Version:    0.7.0.1
 */