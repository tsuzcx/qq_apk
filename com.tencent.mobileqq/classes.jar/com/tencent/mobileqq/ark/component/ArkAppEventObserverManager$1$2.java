package com.tencent.mobileqq.ark.component;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;

class ArkAppEventObserverManager$1$2
  implements Runnable
{
  ArkAppEventObserverManager$1$2(ArkAppEventObserverManager.1 param1) {}
  
  public void run()
  {
    if (ArkAppEventObserverManager.a(this.a.a) != null) {
      ArkAppEventObserverManager.a(this.a.a).a(false, 0.0D, 0.0D);
    }
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(ArkAppEventObserverManager.a(this.a.a));
    ArkAppEventObserverManager.a(this.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.1.2
 * JD-Core Version:    0.7.0.1
 */