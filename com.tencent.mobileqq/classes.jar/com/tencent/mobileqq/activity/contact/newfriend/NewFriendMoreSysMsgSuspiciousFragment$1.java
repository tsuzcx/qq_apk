package com.tencent.mobileqq.activity.contact.newfriend;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NewFriendMoreSysMsgSuspiciousFragment$1
  implements View.OnClickListener
{
  NewFriendMoreSysMsgSuspiciousFragment$1(NewFriendMoreSysMsgSuspiciousFragment paramNewFriendMoreSysMsgSuspiciousFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.1
 * JD-Core Version:    0.7.0.1
 */