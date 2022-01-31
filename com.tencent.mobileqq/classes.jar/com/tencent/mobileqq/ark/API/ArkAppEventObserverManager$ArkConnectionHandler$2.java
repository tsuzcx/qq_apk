package com.tencent.mobileqq.ark.API;

import anff;
import anfh;
import anfj;

public class ArkAppEventObserverManager$ArkConnectionHandler$2
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$2(anfh paramanfh) {}
  
  public void run()
  {
    if ((anff.a(this.a.a) != null) && (!"cellular".equals(anff.b(this.a.a))))
    {
      anff.a(this.a.a).a(true, "cellular");
      anff.a(this.a.a, "cellular");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.2
 * JD-Core Version:    0.7.0.1
 */