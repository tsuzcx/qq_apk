package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddFriendVerifyActivity$31
  implements View.OnClickListener
{
  AddFriendVerifyActivity$31(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.b.j != null) && (this.b.j.isShowing()) && (this.b.j.getWindow() != null)) {}
    try
    {
      this.b.j.dismiss();
      AddFriendVerifyActivity.a(this.b, -1, this.a);
      label58:
      this.b.j = null;
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.31
 * JD-Core Version:    0.7.0.1
 */