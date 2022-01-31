package com.tencent.mobileqq.ark.API;

import anjo;
import anjp;
import anjx;
import com.tencent.mobileqq.app.soso.SosoInterface;

public class ArkAppEventObserverManager$1$2
  implements Runnable
{
  public ArkAppEventObserverManager$1$2(anjp paramanjp) {}
  
  public void run()
  {
    if (anjo.a(this.a.a) != null) {
      anjo.a(this.a.a).a(false, 0.0D, 0.0D);
    }
    SosoInterface.b(anjo.a(this.a.a));
    anjo.a(this.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1.2
 * JD-Core Version:    0.7.0.1
 */