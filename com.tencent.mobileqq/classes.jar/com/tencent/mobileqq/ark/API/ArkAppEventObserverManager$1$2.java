package com.tencent.mobileqq.ark.API;

import anff;
import anfg;
import anfo;
import com.tencent.mobileqq.app.soso.SosoInterface;

public class ArkAppEventObserverManager$1$2
  implements Runnable
{
  public ArkAppEventObserverManager$1$2(anfg paramanfg) {}
  
  public void run()
  {
    if (anff.a(this.a.a) != null) {
      anff.a(this.a.a).a(false, 0.0D, 0.0D);
    }
    SosoInterface.b(anff.a(this.a.a));
    anff.a(this.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1.2
 * JD-Core Version:    0.7.0.1
 */