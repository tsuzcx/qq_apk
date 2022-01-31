package com.tencent.mobileqq.app.automator.step;

import acny;
import ajjp;
import ajoh;
import ajpd;
import ajrg;
import ajrh;
import ajri;
import ajxl;
import ardz;
import atww;
import awan;
import awbp;
import azyv;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import moo;
import moz;

public class GetCheckUpdate
  extends AsyncStep
{
  ajxl a;
  
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
        localAutomator.a(102, new ajpd(localPublicAccountHandler));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(106, new azyv(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(118, new moz(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(127, new moo(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(117, new ajrg(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(113, new awbp(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(116, new awan(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(114, new ajri(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(115, new ajrh(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(122, new atww(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(119, new ajjp(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(120, new acny(localQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(123, new ajoh(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app));
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a(126, new ardz(localQQAppInterface));
    }
    if (this.jdField_a_of_type_Ajxl == null)
    {
      this.jdField_a_of_type_Ajxl = new ajxl(this, null);
      localQQAppInterface.addObserver(this.jdField_a_of_type_Ajxl);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajxl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Ajxl);
      this.jdField_a_of_type_Ajxl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetCheckUpdate
 * JD-Core Version:    0.7.0.1
 */