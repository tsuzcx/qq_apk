package com.tencent.mobileqq.ark.module;

import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;

class ArkAppDeviceModule$ObserverMethod$5
  implements AuthDialogEventHandler
{
  ArkAppDeviceModule$ObserverMethod$5(ArkAppDeviceModule.ObserverMethod paramObserverMethod, long paramLong) {}
  
  public void a()
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.b.a.f, new ArkAppDeviceModule.ObserverMethod.5.1(this));
  }
  
  public void b()
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(this.b.a.f, new ArkAppDeviceModule.ObserverMethod.5.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ObserverMethod.5
 * JD-Core Version:    0.7.0.1
 */