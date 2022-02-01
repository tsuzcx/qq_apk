package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class NearbyChatPie$11
  extends FriendListObserver
{
  NearbyChatPie$11(NearbyChatPie paramNearbyChatPie) {}
  
  public void onAddFriend(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramString))
    {
      Intent localIntent = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
      localIntent.putExtra("uintype", 0);
      NearbyChatPie.b(this.a, localIntent);
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b + "Q.nearby.follow", 2, "onAddFriend, addUin:" + paramString + "|updateSession");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.11
 * JD-Core Version:    0.7.0.1
 */