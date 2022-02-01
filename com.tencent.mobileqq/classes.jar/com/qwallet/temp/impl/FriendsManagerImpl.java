package com.qwallet.temp.impl;

import com.qwallet.temp.IFriendsManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class FriendsManagerImpl
  implements IFriendsManager
{
  private QQAppInterface mApp;
  
  private boolean checkAppRuntimeInValid()
  {
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (this.mApp == null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("FriendsManagerImpl", 2, new Object[] { "checkAppRuntimeInValid: ", Boolean.valueOf(bool) });
    }
    return this.mApp == null;
  }
  
  private FriendsManager getManager()
  {
    return (FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER);
  }
  
  public Friends findFriendEntityByUin(String paramString)
  {
    if (checkAppRuntimeInValid()) {
      return null;
    }
    return getManager().m(paramString);
  }
  
  public boolean isFriend(String paramString)
  {
    if (checkAppRuntimeInValid()) {
      return false;
    }
    return getManager().n(paramString);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.impl.FriendsManagerImpl
 * JD-Core Version:    0.7.0.1
 */