package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class UpdateTroop
  extends AsyncStep
{
  private TroopObserver a;
  
  private void a()
  {
    if (this.a == null)
    {
      this.a = new UpdateTroop.MyFriendListObserver(this, null);
      this.mAutomator.k.addObserver(this.a);
    }
    ((ITroopListHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).b();
  }
  
  protected int doStep()
  {
    long l1 = SystemClock.uptimeMillis();
    if (this.mStepId == 4)
    {
      this.mAutomator.e = this.mAutomator.d.getBoolean("isTrooplistok", false);
      Object localObject = this.mAutomator.k.getEntityManagerFactory();
      if (((localObject instanceof QQEntityManagerFactoryProxy)) && (((QQEntityManagerFactoryProxy)localObject).a())) {
        this.mAutomator.e = false;
      }
      localObject = (TroopManager)this.mAutomator.k.getManager(QQManagerFactory.TROOP_MANAGER);
      if (this.mAutomator.e)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "onCheckTroopList:Done");
        }
        long l2 = SystemClock.uptimeMillis();
        ITroopListHandler localITroopListHandler = (ITroopListHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER);
        l2 = SystemClock.uptimeMillis() - l2;
        ((TroopManager)localObject).a();
        localITroopListHandler.a(TroopObserver.TYPE_GET_TROOP_LIST, true, null);
        this.mAutomator.notifyUI(3, true, Integer.valueOf(2));
        l1 = SystemClock.uptimeMillis() - l1 - l2;
        this.mAutomator.j.put("UpdateTroop_withoutHandlerCost", Long.valueOf(l1));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("troopHandler creation cost: ");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append(", total cost without troopHandler: ");
          ((StringBuilder)localObject).append(l1);
          QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
        }
        return 7;
      }
      ((TroopManager)localObject).a();
      a();
      return 2;
    }
    a();
    return 2;
  }
  
  public void onCreate()
  {
    this.mCountRetry = 2;
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.mAutomator.k.removeObserver(this.a);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateTroop
 * JD-Core Version:    0.7.0.1
 */