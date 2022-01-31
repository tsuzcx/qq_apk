package com.tencent.mobileqq.app.automator.step;

import ajvp;
import akdn;
import aklj;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import aukp;
import aukq;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import mqq.app.MobileQQ;

public class CheckPublicAccount
  extends AsyncStep
{
  akdn a;
  
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
        ajvp localajvp = (ajvp)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(21);
        if (localajvp != null) {
          localajvp.a(SystemClock.uptimeMillis());
        }
        ((SharedPreferences)localObject).edit().putLong("eqqlist_login_update_ts", l);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getEntityManagerFactory().createEntityManager();
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a((aukp)localObject);
      if (bool) {
        return 2;
      }
    }
    return 7;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Akdn == null)
    {
      this.jdField_a_of_type_Akdn = new aklj(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Akdn);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Akdn != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Akdn);
      this.jdField_a_of_type_Akdn = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckPublicAccount
 * JD-Core Version:    0.7.0.1
 */