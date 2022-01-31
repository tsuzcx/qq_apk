package com.tencent.mobileqq.app.automator.step;

import alri;
import alrk;
import alrl;
import amit;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class UpdateDiscuss
  extends AsyncStep
{
  private alrl a;
  
  private void b()
  {
    if (this.jdField_a_of_type_Alrl == null)
    {
      this.jdField_a_of_type_Alrl = new amit(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Alrl);
    }
    ((alri)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(6)).f(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin()).longValue());
  }
  
  public int a()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBoolean("isDiscussionlistok", false);
    alrk localalrk = (alrk)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(53);
    if (bool)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(1);
      localalrk.a();
      localFriendListHandler.notifyUI(1000, true, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.notifyUI(3, true, Integer.valueOf(3));
      return 7;
    }
    localalrk.a();
    b();
    return 2;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Alrl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Alrl);
      this.jdField_a_of_type_Alrl = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateDiscuss
 * JD-Core Version:    0.7.0.1
 */