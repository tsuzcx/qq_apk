package com.tencent.mobileqq.ark.API;

class ArkAppEventObserverManager$ArkConnectionHandler$6
  implements Runnable
{
  ArkAppEventObserverManager$ArkConnectionHandler$6(ArkAppEventObserverManager.ArkConnectionHandler paramArkConnectionHandler) {}
  
  public void run()
  {
    if ((ArkAppEventObserverManager.a(this.a.a) != null) && (!"none".equals(ArkAppEventObserverManager.b(this.a.a))))
    {
      ArkAppEventObserverManager.a(this.a.a).a(true, "none");
      ArkAppEventObserverManager.a(this.a.a, "none");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ArkConnectionHandler.6
 * JD-Core Version:    0.7.0.1
 */