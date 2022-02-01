package com.tencent.mm.plugin.appbrand.widget.sms;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class EditVerifyCodeView$3
  implements View.OnKeyListener
{
  EditVerifyCodeView$3(EditVerifyCodeView paramEditVerifyCodeView) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 1))
    {
      EditVerifyCodeView.c(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView.3
 * JD-Core Version:    0.7.0.1
 */