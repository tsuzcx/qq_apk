package com.tencent.mobileqq.ark.API;

import aloo;
import aloq;
import alos;

public class ArkAppEventObserverManager$ArkConnectionHandler$2
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$2(aloq paramaloq) {}
  
  public void run()
  {
    if ((aloo.a(this.a.a) != null) && (!"cellular".equals(aloo.b(this.a.a))))
    {
      aloo.a(this.a.a).a(true, "cellular");
      aloo.a(this.a.a, "cellular");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.2
 * JD-Core Version:    0.7.0.1
 */