package com.tencent.mobileqq.ark.API;

import apvn;
import apvp;
import apvr;

public class ArkAppEventObserverManager$ArkConnectionHandler$5
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$5(apvp paramapvp) {}
  
  public void run()
  {
    if ((apvn.a(this.a.a) != null) && (!"wifi".equals(apvn.b(this.a.a))))
    {
      apvn.a(this.a.a).a(true, "wifi");
      apvn.a(this.a.a, "wifi");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.5
 * JD-Core Version:    0.7.0.1
 */