package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class UpdateDiscuss
  extends AsyncStep
{
  private DiscussionObserver a;
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new UpdateDiscuss.MyDiscussionObserver(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    }
    ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).f(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
  }
  
  public int a()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isDiscussionlistok", false);
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (bool)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      localDiscussionManager.a();
      localFriendListHandler.notifyUI(1000, true, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.notifyUI(3, true, Integer.valueOf(3));
      return 7;
    }
    localDiscussionManager.a();
    a();
    return 2;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateDiscuss
 * JD-Core Version:    0.7.0.1
 */