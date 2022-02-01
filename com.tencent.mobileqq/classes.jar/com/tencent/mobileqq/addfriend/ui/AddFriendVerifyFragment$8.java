package com.tencent.mobileqq.addfriend.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;

class AddFriendVerifyFragment$8
  implements View.OnTouchListener
{
  AddFriendVerifyFragment$8(AddFriendVerifyFragment paramAddFriendVerifyFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)this.a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.a.h.getWindowToken(), 2);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.8
 * JD-Core Version:    0.7.0.1
 */