package com.tencent.mobileqq.app.automator.step;

import agku;
import anzd;
import aodh;
import aoef;
import aogp;
import aogq;
import aogr;
import aomh;
import awvd;
import azxq;
import bcrf;
import bcud;
import bhik;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import nms;
import nnd;

public class GetCheckUpdate
  extends AsyncStep
{
  aomh a;
  
  public int a()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(1);
    if (this.b == 45) {}
    for (int i = 1;; i = 4)
    {
      localFriendListHandler.a(true, i);
      return 2;
    }
  }
  
  public void b()
  {
    super.b();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app;
    if (this.b == 45)
    {
      PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)localQQAppInterface.a(11);
      if (localPublicAccountHandler.a())
      {
        Automator localAutomator = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
        localPublicAccountHandler.getClass();
        localAutomator.a(102, new aoef(localPublicAccountHandler));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(106, new bhik(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(118, new nnd(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(127, new nms(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(117, new aogp(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(113, new bcud(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(116, new bcrf(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(114, new aogr(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(115, new aogq(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(122, new azxq(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(119, new anzd(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(120, new agku(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(123, new aodh(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(126, new awvd(localQQAppInterface));
    }
    if (this.jdField_a_of_type_Aomh == null)
    {
      this.jdField_a_of_type_Aomh = new aomh(this, null);
      localQQAppInterface.addObserver(this.jdField_a_of_type_Aomh);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aomh != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Aomh);
      this.jdField_a_of_type_Aomh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetCheckUpdate
 * JD-Core Version:    0.7.0.1
 */