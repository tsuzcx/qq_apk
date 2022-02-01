package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class UpdateTroop
  extends AsyncStep
{
  private TroopObserver a;
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new UpdateTroop.MyFriendListObserver(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    }
    ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b();
  }
  
  public int a()
  {
    long l1 = SystemClock.uptimeMillis();
    if (this.b == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isTrooplistok", false);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory();
      if (((localObject instanceof QQEntityManagerFactoryProxy)) && (((QQEntityManagerFactoryProxy)localObject).a())) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Boolean = false;
      }
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "onCheckTroopList:Done");
        }
        long l2 = SystemClock.uptimeMillis();
        TroopListHandler localTroopListHandler = (TroopListHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER);
        l2 = SystemClock.uptimeMillis() - l2;
        ((TroopManager)localObject).a();
        localTroopListHandler.notifyUI(TroopNotificationConstants.b, true, null);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.notifyUI(3, true, Integer.valueOf(2));
        l1 = SystemClock.uptimeMillis() - l1 - l2;
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("UpdateTroop_withoutHandlerCost", Long.valueOf(l1));
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "troopHandler creation cost: " + l2 + ", total cost without troopHandler: " + l1);
        }
        return 7;
      }
      ((TroopManager)localObject).a();
      a();
    }
    for (;;)
    {
      return 2;
      a();
    }
  }
  
  public void b()
  {
    this.c = 2;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateTroop
 * JD-Core Version:    0.7.0.1
 */