package com.tencent.mobileqq.activity.contact.addfriendverifi;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NewFriendVerifyBlockedListFragment$4
  implements View.OnClickListener
{
  NewFriendVerifyBlockedListFragment$4(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  public void onClick(View paramView)
  {
    NewFriendVerificationManager.a(NewFriendVerifyBlockedListFragment.a(this.a).app).c(NewFriendVerifyBlockedListFragment.a(this.a).app.getCurrentAccountUin());
    ReportController.b(null, "dc00898", "", "", "0X800A3A9", "0X800A3A9", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerifyBlockedListFragment.4
 * JD-Core Version:    0.7.0.1
 */