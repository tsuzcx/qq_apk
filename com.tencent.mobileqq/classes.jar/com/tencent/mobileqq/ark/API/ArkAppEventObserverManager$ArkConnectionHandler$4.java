package com.tencent.mobileqq.ark.API;

import alad;
import alaf;
import alah;

public class ArkAppEventObserverManager$ArkConnectionHandler$4
  implements Runnable
{
  public ArkAppEventObserverManager$ArkConnectionHandler$4(alaf paramalaf) {}
  
  public void run()
  {
    if ((alad.a(this.a.a) != null) && (!"cellular".equals(alad.b(this.a.a))))
    {
      alad.a(this.a.a).a(true, "cellular");
      alad.a(this.a.a, "cellular");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.4
 * JD-Core Version:    0.7.0.1
 */