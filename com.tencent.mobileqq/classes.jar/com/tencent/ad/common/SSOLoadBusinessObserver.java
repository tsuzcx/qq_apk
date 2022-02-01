package com.tencent.ad.common;

import android.os.Bundle;
import com.tencent.gdtad.log.GdtLog;
import mqq.observer.BusinessObserver;

public class SSOLoadBusinessObserver
  implements BusinessObserver
{
  public SSOLoadBusinessObserver.SSOLoadListener a;
  
  public SSOLoadBusinessObserver(SSOLoadBusinessObserver.SSOLoadListener paramSSOLoadListener)
  {
    this.a = paramSSOLoadListener;
  }
  
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
 * Qualified Name:     com.tencent.ad.common.SSOLoadBusinessObserver
 * JD-Core Version:    0.7.0.1
 */