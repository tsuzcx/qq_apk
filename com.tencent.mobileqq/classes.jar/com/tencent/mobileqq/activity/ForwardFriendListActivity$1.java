package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardFriendListActivity$1
  implements View.OnClickListener
{
  ForwardFriendListActivity$1(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.app != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtras(this.a.getIntent().getExtras());
      localIntent.putExtra("extra_choose_friend_uin", this.a.app.getAccount());
      localIntent.putExtra("extra_choose_friend_name", this.a.app.getCurrentNickname());
      this.a.setResult(-1, localIntent);
      this.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardFriendListActivity.1
 * JD-Core Version:    0.7.0.1
 */