package com.tencent.mobileqq.ark.API;

import aphx;
import aphz;
import apib;

public class ArkAppEventObserverManager$ArkConnectionHandler$5
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$5(aphz paramaphz) {}
  
  public void run()
  {
    if ((aphx.a(this.a.a) != null) && (!"wifi".equals(aphx.b(this.a.a))))
    {
      aphx.a(this.a.a).a(true, "wifi");
      aphx.a(this.a.a, "wifi");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.5
 * JD-Core Version:    0.7.0.1
 */