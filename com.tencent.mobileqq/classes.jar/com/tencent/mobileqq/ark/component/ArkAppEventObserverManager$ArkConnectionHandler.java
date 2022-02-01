package com.tencent.mobileqq.ark.component;

import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class ArkAppEventObserverManager$ArkConnectionHandler
  implements INetInfoHandler
{
  ArkAppEventObserverManager$ArkConnectionHandler(ArkAppEventObserverManager paramArkAppEventObserverManager) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetMobile2None mLastNetType=");
      localStringBuilder.append(ArkAppEventObserverManager.p(this.a));
      QLog.d("ArkAppEventObserverManager", 2, localStringBuilder.toString());
    }
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppEventObserverManager.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.6(this));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onNetMobile2Wifi mLastNetType=");
      paramString.append(ArkAppEventObserverManager.p(this.a));
      QLog.d("ArkAppEventObserverManager", 2, paramString.toString());
    }
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppEventObserverManager.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.5(this));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onNetNone2Mobile mLastNetType=");
      paramString.append(ArkAppEventObserverManager.p(this.a));
      QLog.d("ArkAppEventObserverManager", 2, paramString.toString());
    }
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppEventObserverManager.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.4(this));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onNetNone2Wifi mLastNetType=");
      paramString.append(ArkAppEventObserverManager.p(this.a));
      QLog.d("ArkAppEventObserverManager", 2, paramString.toString());
    }
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppEventObserverManager.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.3(this));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onNetWifi2Mobile mLastNetType=");
      paramString.append(ArkAppEventObserverManager.p(this.a));
      QLog.d("ArkAppEventObserverManager", 2, paramString.toString());
    }
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppEventObserverManager.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.2(this));
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetWifi2None mLastNetType=");
      localStringBuilder.append(ArkAppEventObserverManager.p(this.a));
      QLog.d("ArkAppEventObserverManager", 2, localStringBuilder.toString());
    }
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppEventObserverManager.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.ArkConnectionHandler
 * JD-Core Version:    0.7.0.1
 */