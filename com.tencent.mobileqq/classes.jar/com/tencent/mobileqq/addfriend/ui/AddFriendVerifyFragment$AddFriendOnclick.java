package com.tencent.mobileqq.addfriend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

abstract class AddFriendVerifyFragment$AddFriendOnclick
  implements View.OnClickListener
{
  AddFriendVerifyFragment$AddFriendOnclick(AddFriendVerifyFragment paramAddFriendVerifyFragment) {}
  
  public void onClick(View paramView)
  {
    AddFriendVerifyFragment.t(this.f);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.AddFriendOnclick
 * JD-Core Version:    0.7.0.1
 */