package com.tencent.mobileqq.ark.API;

import alad;
import alae;
import alam;
import com.tencent.mobileqq.app.soso.SosoInterface;

public class ArkAppEventObserverManager$1$2
  implements Runnable
{
  public ArkAppEventObserverManager$1$2(alae paramalae) {}
  
  public void run()
  {
    if (alad.a(this.a.a) != null) {
      alad.a(this.a.a).a(false, 0.0D, 0.0D);
    }
    SosoInterface.b(alad.a(this.a.a));
    alad.a(this.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1.2
 * JD-Core Version:    0.7.0.1
 */