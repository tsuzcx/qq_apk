package com.tencent.mobileqq.ark.API;

import apvn;
import apvo;
import apvw;
import com.tencent.mobileqq.app.soso.SosoInterface;

public class ArkAppEventObserverManager$1$2
  implements Runnable
{
  public ArkAppEventObserverManager$1$2(apvo paramapvo) {}
  
  public void run()
  {
    if (apvn.a(this.a.a) != null) {
      apvn.a(this.a.a).a(false, 0.0D, 0.0D);
    }
    SosoInterface.b(apvn.a(this.a.a));
    apvn.a(this.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1.2
 * JD-Core Version:    0.7.0.1
 */