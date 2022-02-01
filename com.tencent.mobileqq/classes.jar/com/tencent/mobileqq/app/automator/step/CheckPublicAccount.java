package com.tencent.mobileqq.app.automator.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import mqq.app.MobileQQ;

public class CheckPublicAccount
  extends AsyncStep
{
  PublicAccountObserver a;
  
  public int a()
  {
    Object localObject = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if (this.b == 6)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isPublicAccountListOK", false))
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
      long l = System.currentTimeMillis();
      if (l - ((SharedPreferences)localObject).getLong("eqqlist_login_update_ts", 0L) > 86400000L)
      {
        EnterpriseQQHandler localEnterpriseQQHandler = (EnterpriseQQHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
        if (localEnterpriseQQHandler != null) {
          localEnterpriseQQHandler.a(SystemClock.uptimeMillis());
        }
        ((SharedPreferences)localObject).edit().putLong("eqqlist_login_update_ts", l);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((EntityManager)localObject);
      if (bool) {
        return 2;
      }
    }
    return 7;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new CheckPublicAccount.MyPublicAccountObserver(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckPublicAccount
 * JD-Core Version:    0.7.0.1
 */