package com.tencent.mobileqq.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class AddFriendVerifyActivity$1
  implements View.OnTouchListener
{
  AddFriendVerifyActivity$1(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) != 2) {
      return false;
    }
    paramView = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
    if (paramView.isActive()) {
      paramView.hideSoftInputFromWindow(this.a.getWindow().getDecorView().getWindowToken(), 0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.1
 * JD-Core Version:    0.7.0.1
 */