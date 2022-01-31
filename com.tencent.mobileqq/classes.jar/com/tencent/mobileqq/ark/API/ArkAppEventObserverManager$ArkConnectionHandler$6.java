package com.tencent.mobileqq.ark.API;

import anff;
import anfh;
import anfj;

public class ArkAppEventObserverManager$ArkConnectionHandler$6
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$6(anfh paramanfh) {}
  
  public void run()
  {
    if ((anff.a(this.a.a) != null) && (!"none".equals(anff.b(this.a.a))))
    {
      anff.a(this.a.a).a(true, "none");
      anff.a(this.a.a, "none");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.6
 * JD-Core Version:    0.7.0.1
 */