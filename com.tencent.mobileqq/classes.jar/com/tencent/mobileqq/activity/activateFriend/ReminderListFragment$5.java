package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.os.Bundle;
import android.os.Handler;
import mqq.observer.BusinessObserver;

class ReminderListFragment$5
  implements BusinessObserver
{
  ReminderListFragment$5(ReminderListFragment paramReminderListFragment, AcsMsg paramAcsMsg, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).post(new ReminderListFragment.5.1(this, paramInt, paramBoolean, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.5
 * JD-Core Version:    0.7.0.1
 */