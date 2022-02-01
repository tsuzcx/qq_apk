package com.tencent.mobileqq.app.automator.step;

import anvi;
import aohv;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CheckFriendsLastLoginInfo
  extends AsyncStep
{
  private anvi a;
  
  public int a()
  {
    if (((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getLastLoginInfo())
    {
      if (this.jdField_a_of_type_Anvi == null)
      {
        this.jdField_a_of_type_Anvi = new aohv(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Anvi);
      }
      return 2;
    }
    return 7;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Anvi != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_Anvi = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckFriendsLastLoginInfo
 * JD-Core Version:    0.7.0.1
 */