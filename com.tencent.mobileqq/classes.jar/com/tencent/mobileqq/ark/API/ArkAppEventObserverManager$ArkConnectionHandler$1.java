package com.tencent.mobileqq.ark.API;

import apsb;
import apsd;
import apsf;

public class ArkAppEventObserverManager$ArkConnectionHandler$1
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$1(apsd paramapsd) {}
  
  public void run()
  {
    if ((apsb.a(this.a.a) != null) && (!"none".equals(apsb.b(this.a.a))))
    {
      apsb.a(this.a.a).a(true, "none");
      apsb.a(this.a.a, "none");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.1
 * JD-Core Version:    0.7.0.1
 */