package com.qwallet.temp.impl;

import com.qwallet.temp.IAIOAnimationControlManager;
import com.qwallet.temp.IAnimationMessageProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class AIOAnimationControlManagerImpl
  implements IAIOAnimationControlManager
{
  private QQAppInterface mApp;
  
  private AIOAnimationControlManager getManager()
  {
    if (checkAppRuntimeInValid()) {
      return null;
    }
    return (AIOAnimationControlManager)this.mApp.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
  }
  
  public boolean addPlayAnimationList(IAnimationMessageProxy paramIAnimationMessageProxy, boolean paramBoolean)
  {
    AIOAnimationControlManager localAIOAnimationControlManager = getManager();
    if (localAIOAnimationControlManager != null) {
      return localAIOAnimationControlManager.a(new AIOAnimationControlManagerImpl.1(this, paramIAnimationMessageProxy), paramBoolean);
    }
    return false;
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
      QLog.d("AIOAnimationControlManagerImpl", 2, new Object[] { "checkAppRuntimeInValid: ", Boolean.valueOf(bool) });
    }
    return this.mApp == null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy() {}
  
  public void removeAllGiftMsgByTroop(String paramString)
  {
    AIOAnimationControlManager localAIOAnimationControlManager = getManager();
    if (localAIOAnimationControlManager != null) {
      localAIOAnimationControlManager.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.impl.AIOAnimationControlManagerImpl
 * JD-Core Version:    0.7.0.1
 */