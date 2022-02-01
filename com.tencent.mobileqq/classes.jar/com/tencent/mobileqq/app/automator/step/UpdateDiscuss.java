package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import anwo;
import anws;
import anwt;
import aonb;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class UpdateDiscuss
  extends AsyncStep
{
  private anwt a;
  
  private void a()
  {
    if (this.jdField_a_of_type_Anwt == null)
    {
      this.jdField_a_of_type_Anwt = new aonb(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Anwt);
    }
    ((anwo)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(6)).f(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin()).longValue());
  }
  
  public int a()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBoolean("isDiscussionlistok", false);
    anws localanws = (anws)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(53);
    if (bool)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(1);
      localanws.a();
      localFriendListHandler.notifyUI(1000, true, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.notifyUI(3, true, Integer.valueOf(3));
      return 7;
    }
    localanws.a();
    a();
    return 2;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Anwt != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Anwt);
      this.jdField_a_of_type_Anwt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateDiscuss
 * JD-Core Version:    0.7.0.1
 */