package com.tencent.mobileqq.ark.component;

class ArkAppEventObserverManager$ArkConnectionHandler$5
  implements Runnable
{
  ArkAppEventObserverManager$ArkConnectionHandler$5(ArkAppEventObserverManager.ArkConnectionHandler paramArkConnectionHandler) {}
  
  public void run()
  {
    if ((ArkAppEventObserverManager.q(this.a.a) != null) && (!"wifi".equals(ArkAppEventObserverManager.p(this.a.a))))
    {
      ArkAppEventObserverManager.q(this.a.a).a(true, "wifi");
      ArkAppEventObserverManager.a(this.a.a, "wifi");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.ArkConnectionHandler.5
 * JD-Core Version:    0.7.0.1
 */