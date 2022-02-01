package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CheckFriendsLastLoginInfo
  extends AsyncStep
{
  private FriendListObserver a;
  
  public int a()
  {
    if (((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getLastLoginInfo())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new CheckFriendsLastLoginInfo.MyFriendListObserver(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      }
      return 2;
    }
    return 7;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckFriendsLastLoginInfo
 * JD-Core Version:    0.7.0.1
 */