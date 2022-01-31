package com.tencent.mobileqq.ark.API;

import alad;
import alaf;
import alah;

public class ArkAppEventObserverManager$ArkConnectionHandler$3
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$3(alaf paramalaf) {}
  
  public void run()
  {
    if ((alad.a(this.a.a) != null) && (!"wifi".equals(alad.b(this.a.a))))
    {
      alad.a(this.a.a).a(true, "wifi");
      alad.a(this.a.a, "wifi");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.3
 * JD-Core Version:    0.7.0.1
 */