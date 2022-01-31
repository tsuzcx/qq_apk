package com.tencent.mobileqq.ark.API;

import anjo;
import anjq;
import anjs;

public class ArkAppEventObserverManager$ArkConnectionHandler$5
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$5(anjq paramanjq) {}
  
  public void run()
  {
    if ((anjo.a(this.a.a) != null) && (!"wifi".equals(anjo.b(this.a.a))))
    {
      anjo.a(this.a.a).a(true, "wifi");
      anjo.a(this.a.a, "wifi");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.5
 * JD-Core Version:    0.7.0.1
 */