package com.tencent.mobileqq.app.automator.step;

import ajjh;
import ajjj;
import ajyh;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class UpdateFriend
  extends AsyncStep
{
  private ajjh a;
  
  private void b()
  {
    if (this.jdField_a_of_type_Ajjh == null)
    {
      this.jdField_a_of_type_Ajjh = new ajyh(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Ajjh);
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(1)).a(0);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Ajjh == null)
    {
      this.jdField_a_of_type_Ajjh = new ajyh(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Ajjh);
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
      ajjj localajjj = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(51);
      if (bool)
      {
        FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(1);
        bool = localajjj.a();
        localajjj.c();
        localFriendListHandler.notifyUI(1, bool, Boolean.valueOf(bool));
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.notifyUI(3, true, Integer.valueOf(1));
        return 7;
      }
      localajjj.a();
      localajjj.c();
      c();
      return 2;
    }
    if (this.b == 7)
    {
      c();
      return 2;
    }
    b();
    return 2;
  }
  
  public void a()
  {
    if (this.b == 3) {
      ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(11)).c();
    }
    if (this.b == 8) {}
    for (int i = 0;; i = 2)
    {
      this.c = i;
      return;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajjh != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_Ajjh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateFriend
 * JD-Core Version:    0.7.0.1
 */