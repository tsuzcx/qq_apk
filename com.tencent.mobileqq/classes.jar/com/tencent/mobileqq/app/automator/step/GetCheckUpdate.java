package com.tencent.mobileqq.app.automator.step;

import afus;
import anvr;
import anzw;
import aoau;
import aoct;
import aocu;
import aocv;
import aoij;
import awom;
import azra;
import bcrf;
import bcuh;
import bhal;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import nvi;
import nvt;

public class GetCheckUpdate
  extends AsyncStep
{
  aoij a;
  
  public int a()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (this.b == 45) {}
    for (int i = 1;; i = 4)
    {
      localFriendListHandler.getCheckUpdate(true, i);
      return 2;
    }
  }
  
  public void b()
  {
    super.b();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app;
    if (this.b == 45)
    {
      PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
      if (localPublicAccountHandler.a())
      {
        Automator localAutomator = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
        localPublicAccountHandler.getClass();
        localAutomator.a(102, new aoau(localPublicAccountHandler));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(106, new bhal(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(118, new nvt(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(127, new nvi(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(117, new aoct(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(113, new bcuh(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(116, new bcrf(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(114, new aocv(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(115, new aocu(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(122, new azra(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(119, new anvr(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(120, new afus(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(123, new anzw(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(126, new awom(localQQAppInterface));
    }
    if (this.jdField_a_of_type_Aoij == null)
    {
      this.jdField_a_of_type_Aoij = new aoij(this, null);
      localQQAppInterface.addObserver(this.jdField_a_of_type_Aoij);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aoij != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Aoij);
      this.jdField_a_of_type_Aoij = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetCheckUpdate
 * JD-Core Version:    0.7.0.1
 */