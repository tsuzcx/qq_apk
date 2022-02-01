package com.tencent.mobileqq.app.automator.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import antw;
import aoav;
import aohx;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import mqq.app.MobileQQ;

public class CheckPublicAccount
  extends AsyncStep
{
  aoav a;
  
  public int a()
  {
    Object localObject = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if (this.b == 6)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBoolean("isPublicAccountListOK", false))
      {
        a();
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
        a();
        ((PublicAccountHandler)localObject).a();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApplication().getApplicationContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getAccount(), 0);
      long l = System.currentTimeMillis();
      if (l - ((SharedPreferences)localObject).getLong("eqqlist_login_update_ts", 0L) > 86400000L)
      {
        antw localantw = (antw)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
        if (localantw != null) {
          localantw.a(SystemClock.uptimeMillis());
        }
        ((SharedPreferences)localObject).edit().putLong("eqqlist_login_update_ts", l);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getEntityManagerFactory().createEntityManager();
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getMessageFacade().refreshPubAccountAssistCache_Lazy((EntityManager)localObject);
      if (bool) {
        return 2;
      }
    }
    return 7;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Aoav == null)
    {
      this.jdField_a_of_type_Aoav = new aohx(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Aoav);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aoav != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Aoav);
      this.jdField_a_of_type_Aoav = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckPublicAccount
 * JD-Core Version:    0.7.0.1
 */