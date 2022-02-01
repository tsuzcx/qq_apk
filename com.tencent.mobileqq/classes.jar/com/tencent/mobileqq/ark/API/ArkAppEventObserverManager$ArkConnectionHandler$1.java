package com.tencent.mobileqq.ark.API;

import aphx;
import aphz;
import apib;

public class ArkAppEventObserverManager$ArkConnectionHandler$1
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$1(aphz paramaphz) {}
  
  public void run()
  {
    if ((aphx.a(this.a.a) != null) && (!"none".equals(aphx.b(this.a.a))))
    {
      aphx.a(this.a.a).a(true, "none");
      aphx.a(this.a.a, "none");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.1
 * JD-Core Version:    0.7.0.1
 */