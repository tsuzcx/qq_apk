package com.tencent.mobileqq.ark.API;

import aphx;
import aphz;
import apib;

public class ArkAppEventObserverManager$ArkConnectionHandler$4
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$4(aphz paramaphz) {}
  
  public void run()
  {
    if ((aphx.a(this.a.a) != null) && (!"cellular".equals(aphx.b(this.a.a))))
    {
      aphx.a(this.a.a).a(true, "cellular");
      aphx.a(this.a.a, "cellular");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.4
 * JD-Core Version:    0.7.0.1
 */