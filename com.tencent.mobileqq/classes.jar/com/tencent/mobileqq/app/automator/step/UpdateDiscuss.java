package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import zyc;

public class UpdateDiscuss
  extends AsyncStep
{
  private DiscussionObserver a;
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = new zyc(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
    }
    ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(6)).f(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getCurrentAccountUin()).longValue());
  }
  
  protected int a()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBoolean("isDiscussionlistok", false);
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getManager(52);
    if (bool)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(1);
      localDiscussionManager.a();
      localFriendListHandler.a(1000, true, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(3, true, Integer.valueOf(3));
      return 7;
    }
    localDiscussionManager.a();
    b();
    return 2;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateDiscuss
 * JD-Core Version:    0.7.0.1
 */