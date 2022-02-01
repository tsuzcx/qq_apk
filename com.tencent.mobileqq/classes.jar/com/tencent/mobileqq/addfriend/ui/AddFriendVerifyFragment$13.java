package com.tencent.mobileqq.addfriend.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddFriendVerifyFragment$13
  implements View.OnClickListener
{
  AddFriendVerifyFragment$13(AddFriendVerifyFragment paramAddFriendVerifyFragment, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((AddFriendVerifyFragment.j(this.b) != null) && (AddFriendVerifyFragment.j(this.b).isShowing()) && (AddFriendVerifyFragment.j(this.b).getWindow() != null)) {}
    try
    {
      AddFriendVerifyFragment.j(this.b).dismiss();
      AddFriendVerifyFragment.a(this.b, -1, this.a);
      label58:
      AddFriendVerifyFragment.a(this.b, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.13
 * JD-Core Version:    0.7.0.1
 */