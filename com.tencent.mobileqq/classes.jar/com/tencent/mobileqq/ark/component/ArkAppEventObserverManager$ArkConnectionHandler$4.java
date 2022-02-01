package com.tencent.mobileqq.ark.component;

class ArkAppEventObserverManager$ArkConnectionHandler$4
  implements Runnable
{
  ArkAppEventObserverManager$ArkConnectionHandler$4(ArkAppEventObserverManager.ArkConnectionHandler paramArkConnectionHandler) {}
  
  public void run()
  {
    if ((ArkAppEventObserverManager.a(this.a.a) != null) && (!"cellular".equals(ArkAppEventObserverManager.b(this.a.a))))
    {
      ArkAppEventObserverManager.a(this.a.a).a(true, "cellular");
      ArkAppEventObserverManager.a(this.a.a, "cellular");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.ArkConnectionHandler.4
 * JD-Core Version:    0.7.0.1
 */