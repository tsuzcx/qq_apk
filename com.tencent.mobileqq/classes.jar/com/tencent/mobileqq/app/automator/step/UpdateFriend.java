package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class UpdateFriend
  extends AsyncStep
{
  private FriendListObserver a;
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new UpdateFriend.MyFriendListObserver(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getGatheredContactsList(0);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new UpdateFriend.MyFriendListObserver(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true);
  }
  
  public int a()
  {
    if (this.b == 3)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isFriendlistok", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "doStep PREF_ISFRIENDLIST_OK=" + bool);
      }
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (bool)
      {
        FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        bool = localFriendsManager.a();
        localFriendsManager.d();
        localFriendListHandler.notifyUI(1, bool, Boolean.valueOf(bool));
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.notifyUI(3, true, Integer.valueOf(1));
        return 7;
      }
      localFriendsManager.a();
      localFriendsManager.d();
      d();
      return 2;
    }
    if (this.b == 7)
    {
      d();
      return 2;
    }
    a();
    return 2;
  }
  
  public void b()
  {
    if (this.b == 3) {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).e();
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
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateFriend
 * JD-Core Version:    0.7.0.1
 */