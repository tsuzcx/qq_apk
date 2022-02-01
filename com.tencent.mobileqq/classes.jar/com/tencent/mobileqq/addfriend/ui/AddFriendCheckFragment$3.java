package com.tencent.mobileqq.addfriend.ui;

import android.os.Handler;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.friend.listeners.OnOpenIdGetListener;
import com.tencent.qphone.base.util.QLog;

class AddFriendCheckFragment$3
  implements OnOpenIdGetListener
{
  AddFriendCheckFragment$3(AddFriendCheckFragment paramAddFriendCheckFragment) {}
  
  public void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if (!AddFriendCheckFragment.a(this.a))
    {
      if (this.a.jdField_a_of_type_Boolean) {
        return;
      }
      if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendCheckFragment", 2, "openIdObserver success");
        }
        if (!paramOpenID.openID.equals(AddFriendCheckFragment.a()))
        {
          AddFriendCheckFragment.a(this.a, true);
          this.a.a();
          return;
        }
        AddFriendCheckFragment.a(this.a);
        return;
      }
      AddFriendCheckFragment.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendCheckFragment", 2, "openIdObserver fail");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendCheckFragment.3
 * JD-Core Version:    0.7.0.1
 */