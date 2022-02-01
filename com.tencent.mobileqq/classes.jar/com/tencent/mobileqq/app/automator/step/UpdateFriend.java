package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import anyu;
import anyw;
import aond;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class UpdateFriend
  extends AsyncStep
{
  private anyu a;
  
  private void a()
  {
    if (this.jdField_a_of_type_Anyu == null)
    {
      this.jdField_a_of_type_Anyu = new aond(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Anyu);
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(1)).a(0);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Anyu == null)
    {
      this.jdField_a_of_type_Anyu = new aond(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Anyu);
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(1)).a(true);
  }
  
  public int a()
  {
    if (this.b == 3)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBoolean("isFriendlistok", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "doStep PREF_ISFRIENDLIST_OK=" + bool);
      }
      anyw localanyw = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(51);
      if (bool)
      {
        FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(1);
        bool = localanyw.a();
        localanyw.e();
        localFriendListHandler.notifyUI(1, bool, Boolean.valueOf(bool));
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.notifyUI(3, true, Integer.valueOf(1));
        return 7;
      }
      localanyw.a();
      localanyw.e();
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
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(11)).e();
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
    if (this.jdField_a_of_type_Anyu != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Anyu);
      this.jdField_a_of_type_Anyu = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateFriend
 * JD-Core Version:    0.7.0.1
 */