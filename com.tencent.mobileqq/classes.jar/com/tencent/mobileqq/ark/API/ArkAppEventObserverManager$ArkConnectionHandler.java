package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class ArkAppEventObserverManager$ArkConnectionHandler
  implements INetInfoHandler
{
  ArkAppEventObserverManager$ArkConnectionHandler(ArkAppEventObserverManager paramArkAppEventObserverManager) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetMobile2None mLastNetType=" + ArkAppEventObserverManager.b(this.a));
    }
    ArkAppCenter.a().post(ArkAppEventObserverManager.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.6(this));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetMobile2Wifi mLastNetType=" + ArkAppEventObserverManager.b(this.a));
    }
    ArkAppCenter.a().post(ArkAppEventObserverManager.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.5(this));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetNone2Mobile mLastNetType=" + ArkAppEventObserverManager.b(this.a));
    }
    ArkAppCenter.a().post(ArkAppEventObserverManager.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.4(this));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetNone2Wifi mLastNetType=" + ArkAppEventObserverManager.b(this.a));
    }
    ArkAppCenter.a().post(ArkAppEventObserverManager.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.3(this));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetWifi2Mobile mLastNetType=" + ArkAppEventObserverManager.b(this.a));
    }
    ArkAppCenter.a().post(ArkAppEventObserverManager.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.2(this));
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onNetWifi2None mLastNetType=" + ArkAppEventObserverManager.b(this.a));
    }
    ArkAppCenter.a().post(ArkAppEventObserverManager.a(this.a), new ArkAppEventObserverManager.ArkConnectionHandler.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler
 * JD-Core Version:    0.7.0.1
 */