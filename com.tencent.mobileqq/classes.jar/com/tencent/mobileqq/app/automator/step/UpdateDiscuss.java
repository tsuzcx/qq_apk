package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import antl;
import antp;
import antq;
import aojd;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class UpdateDiscuss
  extends AsyncStep
{
  private antq a;
  
  private void a()
  {
    if (this.jdField_a_of_type_Antq == null)
    {
      this.jdField_a_of_type_Antq = new aojd(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Antq);
    }
    ((antl)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).f(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin()).longValue());
  }
  
  public int a()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBoolean("isDiscussionlistok", false);
    antp localantp = (antp)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (bool)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      localantp.a();
      localFriendListHandler.notifyUI(1000, true, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.notifyUI(3, true, Integer.valueOf(3));
      return 7;
    }
    localantp.a();
    a();
    return 2;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Antq != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Antq);
      this.jdField_a_of_type_Antq = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateDiscuss
 * JD-Core Version:    0.7.0.1
 */