package com.tencent.mobileqq.ark.API;

import anff;
import anfh;
import anfj;

public class ArkAppEventObserverManager$ArkConnectionHandler$3
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$3(anfh paramanfh) {}
  
  public void run()
  {
    if ((anff.a(this.a.a) != null) && (!"wifi".equals(anff.b(this.a.a))))
    {
      anff.a(this.a.a).a(true, "wifi");
      anff.a(this.a.a, "wifi");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.3
 * JD-Core Version:    0.7.0.1
 */