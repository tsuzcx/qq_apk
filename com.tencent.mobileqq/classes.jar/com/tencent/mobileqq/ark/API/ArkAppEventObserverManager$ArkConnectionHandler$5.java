package com.tencent.mobileqq.ark.API;

import alop;
import alor;
import alot;

public class ArkAppEventObserverManager$ArkConnectionHandler$5
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$5(alor paramalor) {}
  
  public void run()
  {
    if ((alop.a(this.a.a) != null) && (!"wifi".equals(alop.b(this.a.a))))
    {
      alop.a(this.a.a).a(true, "wifi");
      alop.a(this.a.a, "wifi");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.5
 * JD-Core Version:    0.7.0.1
 */