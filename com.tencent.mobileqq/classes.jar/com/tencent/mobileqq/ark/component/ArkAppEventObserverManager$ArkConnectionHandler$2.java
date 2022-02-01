package com.tencent.mobileqq.ark.component;

class ArkAppEventObserverManager$ArkConnectionHandler$2
  implements Runnable
{
  ArkAppEventObserverManager$ArkConnectionHandler$2(ArkAppEventObserverManager.ArkConnectionHandler paramArkConnectionHandler) {}
  
  public void run()
  {
    if ((ArkAppEventObserverManager.q(this.a.a) != null) && (!"cellular".equals(ArkAppEventObserverManager.p(this.a.a))))
    {
      ArkAppEventObserverManager.q(this.a.a).a(true, "cellular");
      ArkAppEventObserverManager.a(this.a.a, "cellular");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.ArkConnectionHandler.2
 * JD-Core Version:    0.7.0.1
 */