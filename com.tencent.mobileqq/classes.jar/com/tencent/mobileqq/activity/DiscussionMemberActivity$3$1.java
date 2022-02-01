package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

class DiscussionMemberActivity$3$1
  implements Runnable
{
  DiscussionMemberActivity$3$1(DiscussionMemberActivity.3 param3) {}
  
  public void run()
  {
    this.a.e.c.offsetTopAndBottom(-this.a.a);
    DiscussionMemberActivity.a(this.a.e).setVisibility(0);
    this.a.e.c.startAnimation(this.a.b);
    this.a.c.hideSoftInputFromWindow(this.a.e.getWindow().peekDecorView().getWindowToken(), 0);
    this.a.e.removeObserver(this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity.3.1
 * JD-Core Version:    0.7.0.1
 */