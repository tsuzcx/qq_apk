package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import zrt;

public class UpdateFriend
  extends AsyncStep
{
  private FriendListObserver a;
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new zrt(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(1)).a(0);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new zrt(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(1)).a(true);
  }
  
  protected int a()
  {
    if (this.b == 3)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBoolean("isFriendlistok", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "doStep PREF_ISFRIENDLIST_OK=" + bool);
      }
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getManager(50);
      if (bool)
      {
        FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(1);
        bool = localFriendsManager.a();
        localFriendsManager.c();
        localFriendListHandler.a(1, bool, Boolean.valueOf(bool));
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(3, true, Integer.valueOf(1));
        return 7;
      }
      localFriendsManager.a();
      localFriendsManager.c();
      d();
      return 2;
    }
    if (this.b == 7)
    {
      d();
      return 2;
    }
    b();
    return 2;
  }
  
  public void a()
  {
    if (this.b == 3) {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getManager(10)).c();
    }
    if (this.b == 8) {}
    for (int i = 0;; i = 2)
    {
      this.c = i;
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateFriend
 * JD-Core Version:    0.7.0.1
 */