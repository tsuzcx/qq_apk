package com.tencent.mobileqq.app.automator.step;

import alnc;
import alvc;
import amcz;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import awbw;
import awbx;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.app.MobileQQ;

public class CheckPublicAccount
  extends AsyncStep
{
  alvc a;
  
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
        alnc localalnc = (alnc)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(21);
        if (localalnc != null) {
          localalnc.a(SystemClock.uptimeMillis());
        }
        ((SharedPreferences)localObject).edit().putLong("eqqlist_login_update_ts", l);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getEntityManagerFactory().createEntityManager();
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a((awbw)localObject);
      if (bool) {
        return 2;
      }
    }
    return 7;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Alvc == null)
    {
      this.jdField_a_of_type_Alvc = new amcz(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Alvc);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Alvc != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Alvc);
      this.jdField_a_of_type_Alvc = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckPublicAccount
 * JD-Core Version:    0.7.0.1
 */