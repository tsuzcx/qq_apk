package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import anvi;
import anvk;
import aojf;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class UpdateFriend
  extends AsyncStep
{
  private anvi a;
  
  private void a()
  {
    if (this.jdField_a_of_type_Anvi == null)
    {
      this.jdField_a_of_type_Anvi = new aojf(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Anvi);
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getGatheredContactsList(0);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Anvi == null)
    {
      this.jdField_a_of_type_Anvi = new aojf(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Anvi);
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true);
  }
  
  public int a()
  {
    if (this.b == 3)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBoolean("isFriendlistok", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "doStep PREF_ISFRIENDLIST_OK=" + bool);
      }
      anvk localanvk = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (bool)
      {
        FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        bool = localanvk.a();
        localanvk.e();
        localFriendListHandler.notifyUI(1, bool, Boolean.valueOf(bool));
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.notifyUI(3, true, Integer.valueOf(1));
        return 7;
      }
      localanvk.a();
      localanvk.e();
      d();
      return 2;
    }
    if (this.b == 7)
    {
      d();
      return 2;
    }
    a();
    return 2;
  }
  
  public void b()
  {
    if (this.b == 3) {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(QQManagerFactory.CONTACT_MANAGER)).e();
    }
    if (this.b == 8) {}
    for (int i = 0;; i = 2)
    {
      this.c = i;
      return;
    }
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
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateFriend
 * JD-Core Version:    0.7.0.1
 */