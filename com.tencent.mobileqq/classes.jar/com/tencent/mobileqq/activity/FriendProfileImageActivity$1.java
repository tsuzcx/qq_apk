package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendProfileImageActivity$1
  implements View.OnClickListener
{
  FriendProfileImageActivity$1(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    FriendProfileImageActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.1
 * JD-Core Version:    0.7.0.1
 */