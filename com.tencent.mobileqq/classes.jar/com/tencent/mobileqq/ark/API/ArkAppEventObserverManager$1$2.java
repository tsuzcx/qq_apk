package com.tencent.mobileqq.ark.API;

import apsb;
import apsc;
import apsk;
import com.tencent.mobileqq.app.soso.SosoInterface;

public class ArkAppEventObserverManager$1$2
  implements Runnable
{
  public ArkAppEventObserverManager$1$2(apsc paramapsc) {}
  
  public void run()
  {
    if (apsb.a(this.a.a) != null) {
      apsb.a(this.a.a).a(false, 0.0D, 0.0D);
    }
    SosoInterface.removeOnLocationListener(apsb.a(this.a.a));
    apsb.a(this.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1.2
 * JD-Core Version:    0.7.0.1
 */