package com.tencent.mobileqq.ark.API;

class ArkAppEventObserverManager$ArkConnectionHandler$3
  implements Runnable
{
  ArkAppEventObserverManager$ArkConnectionHandler$3(ArkAppEventObserverManager.ArkConnectionHandler paramArkConnectionHandler) {}
  
  public void run()
  {
    if ((ArkAppEventObserverManager.a(this.a.a) != null) && (!"wifi".equals(ArkAppEventObserverManager.b(this.a.a))))
    {
      ArkAppEventObserverManager.a(this.a.a).a(true, "wifi");
      ArkAppEventObserverManager.a(this.a.a, "wifi");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.3
 * JD-Core Version:    0.7.0.1
 */