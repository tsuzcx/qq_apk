package com.tencent.mobileqq.app.automator.step;

import acyo;
import ajxr;
import akcq;
import akdm;
import akfp;
import akfq;
import akfr;
import aklu;
import asac;
import auux;
import awzx;
import axaz;
import bban;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mzk;
import mzv;

public class GetCheckUpdate
  extends AsyncStep
{
  aklu a;
  
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
        localAutomator.a(102, new akdm(localPublicAccountHandler));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(106, new bban(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(118, new mzv(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(127, new mzk(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(117, new akfp(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(113, new axaz(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(116, new awzx(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(114, new akfr(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(115, new akfq(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(122, new auux(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(119, new ajxr(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(120, new acyo(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(123, new akcq(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(126, new asac(localQQAppInterface));
    }
    if (this.jdField_a_of_type_Aklu == null)
    {
      this.jdField_a_of_type_Aklu = new aklu(this, null);
      localQQAppInterface.addObserver(this.jdField_a_of_type_Aklu);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aklu != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Aklu);
      this.jdField_a_of_type_Aklu = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetCheckUpdate
 * JD-Core Version:    0.7.0.1
 */