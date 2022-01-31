package com.tencent.mobileqq.app.automator.step;

import ajvr;
import akdo;
import aklk;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import aukn;
import auko;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import mqq.app.MobileQQ;

public class CheckPublicAccount
  extends AsyncStep
{
  akdo a;
  
  public int a()
  {
    Object localObject = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(11);
    if (this.b == 6)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBoolean("isPublicAccountListOK", false))
      {
        b();
        ((PublicAccountHandler)localObject).b();
        ((PublicAccountHandler)localObject).a();
        return 2;
      }
    }
    else
    {
      boolean bool = ((PublicAccountHandler)localObject).a();
      if (bool)
      {
        b();
        ((PublicAccountHandler)localObject).a();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApplication().getApplicationContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getAccount(), 0);
      long l = System.currentTimeMillis();
      if (l - ((SharedPreferences)localObject).getLong("eqqlist_login_update_ts", 0L) > 86400000L)
      {
        ajvr localajvr = (ajvr)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(21);
        if (localajvr != null) {
          localajvr.a(SystemClock.uptimeMillis());
        }
        ((SharedPreferences)localObject).edit().putLong("eqqlist_login_update_ts", l);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getEntityManagerFactory().createEntityManager();
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a((aukn)localObject);
      if (bool) {
        return 2;
      }
    }
    return 7;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Akdo == null)
    {
      this.jdField_a_of_type_Akdo = new aklk(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Akdo);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Akdo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Akdo);
      this.jdField_a_of_type_Akdo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckPublicAccount
 * JD-Core Version:    0.7.0.1
 */