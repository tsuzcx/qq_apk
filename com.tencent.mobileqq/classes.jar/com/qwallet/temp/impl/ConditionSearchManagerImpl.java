package com.qwallet.temp.impl;

import com.qwallet.temp.IConditionSearchManager;
import com.qwallet.temp.IConditionSearchManager.IConfigListenerProxy;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class ConditionSearchManagerImpl
  implements IConditionSearchManager
{
  private QQAppInterface mApp;
  private Map<IConditionSearchManager.IConfigListenerProxy, ConditionSearchManager.IConfigListener> mConfigListeners = new HashMap();
  
  private ConditionSearchManager getManager()
  {
    return (ConditionSearchManager)this.mApp.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
  }
  
  public void addListener(IConditionSearchManager.IConfigListenerProxy paramIConfigListenerProxy)
  {
    if (checkAppRuntimeInValid()) {
      return;
    }
    ConditionSearchManagerImpl.1 local1 = new ConditionSearchManagerImpl.1(this, paramIConfigListenerProxy);
    getManager().c(local1);
    this.mConfigListeners.put(paramIConfigListenerProxy, local1);
  }
  
  public boolean checkAppRuntimeInValid()
  {
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (this.mApp == null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("ConditionSearchManagerImpl", 2, new Object[] { "checkAppRuntimeInValid: ", Boolean.valueOf(bool) });
    }
    return this.mApp == null;
  }
  
  public int checkUpdate()
  {
    if (checkAppRuntimeInValid()) {
      return 0;
    }
    return getManager().a();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy() {}
  
  public void removeListener(IConditionSearchManager.IConfigListenerProxy paramIConfigListenerProxy)
  {
    if (checkAppRuntimeInValid()) {
      return;
    }
    if (this.mConfigListeners.containsKey(paramIConfigListenerProxy))
    {
      getManager().d(this.mConfigListeners.get(paramIConfigListenerProxy));
      this.mConfigListeners.remove(paramIConfigListenerProxy);
    }
  }
  
  public int resultOk()
  {
    return 0;
  }
  
  public int update(int paramInt, boolean paramBoolean)
  {
    if (checkAppRuntimeInValid()) {
      return 0;
    }
    return getManager().a(paramInt, paramBoolean);
  }
  
  public int updateOk()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.ConditionSearchManagerImpl
 * JD-Core Version:    0.7.0.1
 */