package com.tencent.mobileqq.ark.API;

import alop;
import alor;
import alot;

public class ArkAppEventObserverManager$ArkConnectionHandler$4
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$4(alor paramalor) {}
  
  public void run()
  {
    if ((alop.a(this.a.a) != null) && (!"cellular".equals(alop.b(this.a.a))))
    {
      alop.a(this.a.a).a(true, "cellular");
      alop.a(this.a.a, "cellular");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.4
 * JD-Core Version:    0.7.0.1
 */