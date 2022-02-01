package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.widget.Gallery;

class FriendProfileImageActivity$6$1
  implements Runnable
{
  FriendProfileImageActivity$6$1(FriendProfileImageActivity.6 param6) {}
  
  public void run()
  {
    if (this.a.b.i != this.a.b.c.d())
    {
      this.a.b.i = this.a.b.c.d();
      return;
    }
    View localView = this.a.b.a.getSelectedView();
    if (localView == null) {
      return;
    }
    this.a.b.d = localView;
    this.a.b.c.a(this.a.b.c.d());
    this.a.b.a(this.a.b.a, this.a.b.c.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.6.1
 * JD-Core Version:    0.7.0.1
 */