package com.tencent.mobileqq.ark.API;

import alop;
import aloq;
import aloy;
import com.tencent.mobileqq.app.soso.SosoInterface;

public class ArkAppEventObserverManager$1$2
  implements Runnable
{
  public ArkAppEventObserverManager$1$2(aloq paramaloq) {}
  
  public void run()
  {
    if (alop.a(this.a.a) != null) {
      alop.a(this.a.a).a(false, 0.0D, 0.0D);
    }
    SosoInterface.b(alop.a(this.a.a));
    alop.a(this.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1.2
 * JD-Core Version:    0.7.0.1
 */