package com.tencent.biz.pubaccount.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.api.IPublicAccountCheck;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import mqq.app.MobileQQ;

public class PublicAccountCheckImpl
  extends AsyncStep
  implements IPublicAccountCheck
{
  PublicAccountObserverImpl mPublicAccountObserver;
  
  protected int doStep()
  {
    Object localObject = (PublicAccountHandlerImpl)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
    if (this.mStepId == 6)
    {
      if (!this.mAutomator.d.getBoolean("isPublicAccountListOK", false))
      {
        registeObserver();
        ((PublicAccountHandlerImpl)localObject).setNotNeedUpdate();
        ((PublicAccountHandlerImpl)localObject).getUserFollowList();
        return 2;
      }
    }
    else
    {
      boolean bool = ((PublicAccountHandlerImpl)localObject).isNeedUpdate();
      if (bool)
      {
        registeObserver();
        ((PublicAccountHandlerImpl)localObject).getUserFollowList();
      }
      localObject = this.mAutomator.k.getApplication().getApplicationContext().getSharedPreferences(this.mAutomator.k.getAccount(), 0);
      long l = System.currentTimeMillis();
      if (l - ((SharedPreferences)localObject).getLong("eqqlist_login_update_ts", 0L) > 86400000L)
      {
        EnterpriseQQHandler localEnterpriseQQHandler = (EnterpriseQQHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
        if (localEnterpriseQQHandler != null) {
          localEnterpriseQQHandler.a(SystemClock.uptimeMillis());
        }
        ((SharedPreferences)localObject).edit().putLong("eqqlist_login_update_ts", l);
      }
      localObject = this.mAutomator.k.getEntityManagerFactory().createEntityManager();
      this.mAutomator.k.getMessageFacade().a((EntityManager)localObject);
      if (bool) {
        return 2;
      }
    }
    return 7;
  }
  
  public void onDestroy()
  {
    if (this.mPublicAccountObserver != null)
    {
      this.mAutomator.k.removeObserver(this.mPublicAccountObserver);
      this.mPublicAccountObserver = null;
    }
  }
  
  void registeObserver()
  {
    if (this.mPublicAccountObserver == null)
    {
      this.mPublicAccountObserver = new PublicAccountObserverImpl();
      this.mPublicAccountObserver.setOnCallback(new PublicAccountCheckImpl.1(this));
      this.mAutomator.k.addObserver(this.mPublicAccountObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountCheckImpl
 * JD-Core Version:    0.7.0.1
 */