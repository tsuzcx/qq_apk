package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.util.WeakReferenceHandler;

class FriendProfileCardActivity$10
  extends BroadcastReceiver
{
  FriendProfileCardActivity$10(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a.equals(this.a.app.getCurrentAccountUin())) && (this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)) {
      this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.10
 * JD-Core Version:    0.7.0.1
 */