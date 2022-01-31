package com.tencent.gdtad.ipc;

import android.os.Bundle;
import com.tencent.gdtad.log.GdtLog;
import mqq.observer.BusinessObserver;

public class GdtSSoLoadBusinessObserver
  implements BusinessObserver
{
  public GdtSSoLoadBusinessObserver.GdtSSoLoadListener a;
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    GdtLog.b("GdtSSOLoadAD", "onReceive i " + paramInt + " success " + paramBoolean + " bundle " + paramBundle);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while (this.a == null);
      this.a.a(paramBundle);
      return;
    } while (this.a == null);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.ipc.GdtSSoLoadBusinessObserver
 * JD-Core Version:    0.7.0.1
 */