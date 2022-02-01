package com.tencent.mobileqq.ark.API;

import apsb;
import apsd;
import apsf;

public class ArkAppEventObserverManager$ArkConnectionHandler$3
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$3(apsd paramapsd) {}
  
  public void run()
  {
    if ((apsb.a(this.a.a) != null) && (!"wifi".equals(apsb.b(this.a.a))))
    {
      apsb.a(this.a.a).a(true, "wifi");
      apsb.a(this.a.a, "wifi");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.3
 * JD-Core Version:    0.7.0.1
 */