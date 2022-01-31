package com.tencent.mobileqq.ark.API;

import alop;
import alor;
import alot;

public class ArkAppEventObserverManager$ArkConnectionHandler$6
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$6(alor paramalor) {}
  
  public void run()
  {
    if ((alop.a(this.a.a) != null) && (!"none".equals(alop.b(this.a.a))))
    {
      alop.a(this.a.a).a(true, "none");
      alop.a(this.a.a, "none");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.6
 * JD-Core Version:    0.7.0.1
 */