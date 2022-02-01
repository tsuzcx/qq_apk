package com.tencent.mobileqq.ark.API;

import aopa;
import aopc;
import aope;

public class ArkAppEventObserverManager$ArkConnectionHandler$6
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$6(aopc paramaopc) {}
  
  public void run()
  {
    if ((aopa.a(this.a.a) != null) && (!"none".equals(aopa.b(this.a.a))))
    {
      aopa.a(this.a.a).a(true, "none");
      aopa.a(this.a.a, "none");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.6
 * JD-Core Version:    0.7.0.1
 */