package com.tencent.mobileqq.app.automator.step;

import aeqb;
import alpf;
import aluf;
import alvb;
import alxf;
import alxg;
import alxh;
import amdk;
import atqy;
import awmj;
import ayvb;
import aywd;
import bczh;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import nce;
import ncp;

public class GetCheckUpdate
  extends AsyncStep
{
  amdk a;
  
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
  
  public void a()
  {
    super.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app;
    if (this.b == 45)
    {
      PublicAccountHandler localPublicAccountHandler = (PublicAccountHandler)localQQAppInterface.a(11);
      if (localPublicAccountHandler.a())
      {
        Automator localAutomator = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
        localPublicAccountHandler.getClass();
        localAutomator.a(102, new alvb(localPublicAccountHandler));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(106, new bczh(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(118, new ncp(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(127, new nce(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(117, new alxf(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(113, new aywd(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(116, new ayvb(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(114, new alxh(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(115, new alxg(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(122, new awmj(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(119, new alpf(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(120, new aeqb(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(123, new aluf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(126, new atqy(localQQAppInterface));
    }
    if (this.jdField_a_of_type_Amdk == null)
    {
      this.jdField_a_of_type_Amdk = new amdk(this, null);
      localQQAppInterface.addObserver(this.jdField_a_of_type_Amdk);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Amdk != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Amdk);
      this.jdField_a_of_type_Amdk = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetCheckUpdate
 * JD-Core Version:    0.7.0.1
 */