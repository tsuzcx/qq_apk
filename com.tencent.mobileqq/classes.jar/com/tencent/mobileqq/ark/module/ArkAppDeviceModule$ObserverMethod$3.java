package com.tencent.mobileqq.ark.module;

import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.component.ArkAppEventObserverManager;
import com.tencent.mobileqq.qroute.QRoute;

class ArkAppDeviceModule$ObserverMethod$3
  implements AuthDialogEventHandler
{
  ArkAppDeviceModule$ObserverMethod$3(ArkAppDeviceModule.ObserverMethod paramObserverMethod, long paramLong) {}
  
  public void a()
  {
    ArkAppDeviceModule.ObserverMethod.3.1 local1 = new ArkAppDeviceModule.ObserverMethod.3.1(this);
    this.b.a.a.a(local1, this.a);
  }
  
  public void b()
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.b.a.f, new ArkAppDeviceModule.ObserverMethod.3.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ObserverMethod.3
 * JD-Core Version:    0.7.0.1
 */