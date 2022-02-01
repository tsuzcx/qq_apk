package com.tencent.mobileqq.ark.API;

import apvn;
import apvp;
import apvr;

public class ArkAppEventObserverManager$ArkConnectionHandler$2
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$2(apvp paramapvp) {}
  
  public void run()
  {
    if ((apvn.a(this.a.a) != null) && (!"cellular".equals(apvn.b(this.a.a))))
    {
      apvn.a(this.a.a).a(true, "cellular");
      apvn.a(this.a.a, "cellular");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.2
 * JD-Core Version:    0.7.0.1
 */