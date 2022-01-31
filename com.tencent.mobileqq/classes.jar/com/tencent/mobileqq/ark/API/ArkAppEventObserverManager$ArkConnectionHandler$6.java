package com.tencent.mobileqq.ark.API;

import alad;
import alaf;
import alah;

public class ArkAppEventObserverManager$ArkConnectionHandler$6
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$6(alaf paramalaf) {}
  
  public void run()
  {
    if ((alad.a(this.a.a) != null) && (!"none".equals(alad.b(this.a.a))))
    {
      alad.a(this.a.a).a(true, "none");
      alad.a(this.a.a, "none");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.6
 * JD-Core Version:    0.7.0.1
 */