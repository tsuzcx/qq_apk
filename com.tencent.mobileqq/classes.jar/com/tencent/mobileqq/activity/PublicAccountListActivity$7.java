package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

class PublicAccountListActivity$7
  implements DialogInterface.OnDismissListener
{
  PublicAccountListActivity$7(PublicAccountListActivity paramPublicAccountListActivity, int paramInt, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.d.m.setTag("");
    paramDialogInterface = this.d;
    paramDialogInterface.s = false;
    paramDialogInterface.b.offsetTopAndBottom(-this.a);
    this.d.c.setVisibility(0);
    this.d.b.startAnimation(this.b);
    this.c.hideSoftInputFromWindow(this.d.getWindow().peekDecorView().getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.7
 * JD-Core Version:    0.7.0.1
 */