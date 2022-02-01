package com.tencent.mobileqq.ark.component;

class ArkAppEventObserverManager$ArkConnectionHandler$6
  implements Runnable
{
  ArkAppEventObserverManager$ArkConnectionHandler$6(ArkAppEventObserverManager.ArkConnectionHandler paramArkConnectionHandler) {}
  
  public void run()
  {
    if ((ArkAppEventObserverManager.q(this.a.a) != null) && (!"none".equals(ArkAppEventObserverManager.p(this.a.a))))
    {
      ArkAppEventObserverManager.q(this.a.a).a(true, "none");
      ArkAppEventObserverManager.a(this.a.a, "none");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.ArkConnectionHandler.6
 * JD-Core Version:    0.7.0.1
 */