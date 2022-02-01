package com.tencent.mobileqq.ark.API;

import aopa;
import aopb;
import aopj;
import com.tencent.mobileqq.app.soso.SosoInterface;

public class ArkAppEventObserverManager$1$2
  implements Runnable
{
  public ArkAppEventObserverManager$1$2(aopb paramaopb) {}
  
  public void run()
  {
    if (aopa.a(this.a.a) != null) {
      aopa.a(this.a.a).a(false, 0.0D, 0.0D);
    }
    SosoInterface.removeOnLocationListener(aopa.a(this.a.a));
    aopa.a(this.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1.2
 * JD-Core Version:    0.7.0.1
 */