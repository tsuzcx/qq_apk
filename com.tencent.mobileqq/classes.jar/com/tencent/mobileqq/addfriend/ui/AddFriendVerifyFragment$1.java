package com.tencent.mobileqq.addfriend.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qphone.base.util.BaseApplication;

class AddFriendVerifyFragment$1
  implements View.OnTouchListener
{
  AddFriendVerifyFragment$1(AddFriendVerifyFragment paramAddFriendVerifyFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) != 2) {
      return false;
    }
    paramView = (InputMethodManager)BaseApplication.getContext().getSystemService("input_method");
    if (paramView.isActive()) {
      paramView.hideSoftInputFromWindow(this.a.getActivity().getWindow().getDecorView().getWindowToken(), 0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.1
 * JD-Core Version:    0.7.0.1
 */