package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;

public class UpdateDiscuss
  extends AsyncStep
{
  private DiscussionObserver a;
  
  private void a()
  {
    if (this.a == null)
    {
      this.a = new UpdateDiscuss.MyDiscussionObserver(this, null);
      this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.a);
    }
    ((DiscussionHandler)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).f(Long.valueOf(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
  }
  
  protected int doStep()
  {
    boolean bool = this.mAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isDiscussionlistok", false);
    DiscussionManager localDiscussionManager = (DiscussionManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (bool)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      localDiscussionManager.a();
      localFriendListHandler.notifyUI(1000, true, null);
      this.mAutomator.notifyUI(3, true, Integer.valueOf(3));
      return 7;
    }
    localDiscussionManager.a();
    a();
    return 2;
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateDiscuss
 * JD-Core Version:    0.7.0.1
 */